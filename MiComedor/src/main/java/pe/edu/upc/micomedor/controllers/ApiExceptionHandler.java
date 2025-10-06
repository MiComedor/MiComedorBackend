package pe.edu.upc.micomedor.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrity(DataIntegrityViolationException ex) {
        Throwable root = getRootCause(ex);

        // Detecta violación de unicidad por SQLState estándar (23505 en PostgreSQL).
        boolean uniqueViolation = isUniqueViolation(root);

        if (uniqueViolation) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                    "code", "DNI_DUPLICADO",
                    "message", "Ya existe un beneficiario con ese DNI."
            ));
        }

        // Otros errores de integridad
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "code", "DATA_INTEGRITY",
                "message", "No se puede completar la operación por restricción de datos."
        ));
    }

    private boolean isUniqueViolation(Throwable root) {
        // Si la causa es SQLException, inspecciona el SQLState.
        if (root instanceof SQLException sqlEx) {
            String state = sqlEx.getSQLState();
            if ("23505".equals(state)) { // unique_violation en PostgreSQL
                return true;
            }
        }
        // Fallback por mensaje (por si otra capa envolvió la excepción)
        if (root != null && root.getMessage() != null) {
            String msg = root.getMessage().toLowerCase();
            return msg.contains("unique") || msg.contains("unicidad") || msg.contains("duplicate");
        }
        return false;
    }

    private Throwable getRootCause(Throwable t) {
        Throwable r = t;
        while (r.getCause() != null && r.getCause() != r) {
            r = r.getCause();
        }
        return r;
    }
}

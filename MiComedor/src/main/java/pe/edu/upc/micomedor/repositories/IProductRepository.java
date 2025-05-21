package pe.edu.upc.micomedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micomedor.entities.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT description_product, expiration_date\n" +
            "FROM product\n" +
            "WHERE expiration_date BETWEEN CURRENT_DATE AND CURRENT_DATE + INTERVAL '5 days'\n" +
            "  AND user_id = :idUser\n" +
            "ORDER BY expiration_date", nativeQuery = true)
    List<Object[]> productosAvencerDiario(@Param("idUser") int idUser);

    @Query(value = "SELECT \n" +
            "  description_product,\n" +
            "  CASE EXTRACT(DOW FROM expiration_date)\n" +
            "    WHEN 0 THEN 'Domingo'\n" +
            "    WHEN 1 THEN 'Lunes'\n" +
            "    WHEN 2 THEN 'Martes'\n" +
            "    WHEN 3 THEN 'Miércoles'\n" +
            "    WHEN 4 THEN 'Jueves'\n" +
            "    WHEN 5 THEN 'Viernes'\n" +
            "    WHEN 6 THEN 'Sábado'\n" +
            "  END AS dia_vencimiento,\n" +
            "  TO_CHAR(expiration_date, 'DD/MM/YYYY') AS fecha_vencimiento\n" +
            "FROM product\n" +
            "WHERE expiration_date BETWEEN CURRENT_DATE AND CURRENT_DATE + INTERVAL '5 days'\n" +
            "  AND user_id = :idUser\n" +
            "ORDER BY expiration_date", nativeQuery = true)
    List<Object[]> productosAvencerSemana(@Param("idUser") int idUser);
}

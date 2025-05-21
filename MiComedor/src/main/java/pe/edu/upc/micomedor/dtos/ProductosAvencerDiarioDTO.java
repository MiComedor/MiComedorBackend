package pe.edu.upc.micomedor.dtos;
import java.time.LocalDate;

public class ProductosAvencerDiarioDTO {
    private String descripcionProducto;
    private LocalDate expirationDate;

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}

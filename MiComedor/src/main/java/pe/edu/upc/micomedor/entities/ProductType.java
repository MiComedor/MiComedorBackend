package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductType")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProductType;

    @Column(name = "nameProductType", nullable = false, length = 50)
    private String nameProductType;

    // Constructor vacío requerido por JPA
    public ProductType() {
    }

    // Constructor completo (por si lo necesitas)
    public ProductType(String nameProductType, int idProductType) {
        this.nameProductType = nameProductType;
        this.idProductType = idProductType;
    }

    // ✅ Constructor solo con el nombre, útil para inserts simples
    public ProductType(String nameProductType) {
        this.nameProductType = nameProductType;
    }

    // Getters y Setters
    public int getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(int idProductType) {
        this.idProductType = idProductType;
    }

    public String getNameProductType() {
        return nameProductType;
    }

    public void setNameProductType(String nameProductType) {
        this.nameProductType = nameProductType;
    }
}

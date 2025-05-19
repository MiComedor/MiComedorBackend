package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    @Column(name = "descriptionProduct", nullable = false, length = 50)
    private String descriptionProduct;
    @Column(name = "amountProduct", nullable = false)
    private float amountProduct;
    @ManyToOne
    @JoinColumn(name = "ProductType_id")
    private ProductType productType;
    @ManyToOne
    @JoinColumn(name = "UnitOfMeasurement_id")
    private UnitOfMeasurement unitOfMeasurement;
    @ManyToOne
    @JoinColumn(name = "User_id")
    private Users users;
    @Column(name = "expiration_date", nullable = true)
    private LocalDate expirationDate;

    public Product() {
    }
    public Product(int idProduct, String descriptionProduct, float amountProduct, ProductType productType, UnitOfMeasurement unitOfMeasurement, Users users) {
        this.idProduct = idProduct;
        this.descriptionProduct = descriptionProduct;
        this.amountProduct = amountProduct;
        this.productType = productType;
        this.unitOfMeasurement = unitOfMeasurement;
        this.users = users;
        this.expirationDate = LocalDate.now();
    }

    public LocalDate getExpirationDate() { return expirationDate;}

    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate;}
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public float getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(float amountProduct) {
        this.amountProduct = amountProduct;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

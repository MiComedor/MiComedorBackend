package pe.edu.upc.micomedor.dtos;

import pe.edu.upc.micomedor.entities.ProductType;
import pe.edu.upc.micomedor.entities.UnitOfMeasurement;
import pe.edu.upc.micomedor.entities.Users;

public class ProductDTO {
    private int idProduct;
    private String descriptionProduct;
    private float amountProduct;
    private ProductType productType;
    private UnitOfMeasurement unitOfMeasurement;
    private Users users;

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

package pe.edu.upc.micomedor.dtos;

import pe.edu.upc.micomedor.entities.ProductType;
import pe.edu.upc.micomedor.entities.UnitOfMeasurement;
import pe.edu.upc.micomedor.entities.Users;

public class ProductDTO {
    private int idProduct;
    private String descriptionProduct;
    private float amountProduct;
    private int productType_id;
    private int unitOfMeasurement_id;
    private int user_id;

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    private String expirationDate;

    public int getProductType_id() {
        return productType_id;
    }

    public void setProductType_id(int productType_id) {
        this.productType_id = productType_id;
    }

    public int getUnitOfMeasurement_id() {
        return unitOfMeasurement_id;
    }

    public void setUnitOfMeasurement_id(int unitOfMeasurement_id) {
        this.unitOfMeasurement_id = unitOfMeasurement_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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


}

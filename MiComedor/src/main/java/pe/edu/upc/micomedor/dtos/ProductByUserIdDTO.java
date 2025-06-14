package pe.edu.upc.micomedor.dtos;


public class ProductByUserIdDTO {

    private int idProduct;
    private String descriptionProduct;
    private double amountProduct;
    private String expirationDate;
    private String unitOfMeasurementAbbreviation;
    private int user_id;
    private int unitOfMeasurement_id;
    private int productType_id;


    public ProductByUserIdDTO() {
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

    public double getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(double amountProduct) {
        this.amountProduct = amountProduct;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUnitOfMeasurementAbbreviation() {
        return unitOfMeasurementAbbreviation;
    }

    public void setUnitOfMeasurementAbbreviation(String unitOfMeasurementAbbreviation) {
        this.unitOfMeasurementAbbreviation = unitOfMeasurementAbbreviation;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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







}

package pe.edu.upc.micomedor.dtos;
import java.time.LocalDate;

public class RationByUserIdDTO {
    private int idRation;
    private LocalDate date;
    private double price;
    private int dniBenefeciary;
    private String nameRationType;

    public int getIdRation() {
        return idRation;
    }

    public void setIdRation(int idRation) {
        this.idRation = idRation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDniBenefeciary() {
        return dniBenefeciary;
    }

    public void setDniBenefeciary(int dniBenefeciary) {
        this.dniBenefeciary = dniBenefeciary;
    }

    public String getNameRationType() {
        return nameRationType;
    }

    public void setNameRationType(String nameRationType) {
        this.nameRationType = nameRationType;
    }
}

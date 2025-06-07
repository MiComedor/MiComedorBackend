package pe.edu.upc.micomedor.dtos;

import pe.edu.upc.micomedor.entities.*;

import java.time.LocalDate;

public class RationDTO {
    private int idRation;
    private LocalDate date;
    private double price;
    private Users users;
    private RationType rationType;
    private Beneficiary beneficiary;

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public RationType getRationType() {
        return rationType;
    }

    public void setRationType(RationType rationType) {
        this.rationType = rationType;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }
}

package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "Ration")
public class Ration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRation;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "price", nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "idRationType")
    private RationType rationType;
    @ManyToOne
    @JoinColumn(name = "idBeneficiary")
    private Beneficiary beneficiary;


    public Ration() {
    }

    public Ration(int idRation, LocalDate date, double price, Users users, RationType rationType, Beneficiary beneficiary) {
        this.idRation = idRation;
        this.date = date;
        this.price = price;
        this.users = users;
        this.rationType = rationType;
        this.beneficiary = beneficiary;
    }

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

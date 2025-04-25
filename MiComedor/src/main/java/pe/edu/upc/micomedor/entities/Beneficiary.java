package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Beneficiary")
public class Beneficiary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBeneficiary;
    @Column(name = "dniBenefeciary", nullable = false)
    private int dniBenefeciary;
    @Column(name = "fullnameBenefeciary", nullable = false, length = 50)
    private String fullnameBenefeciary;
    @Column(name = "ageBeneficiary", nullable = false)
    private int ageBeneficiary;
    @Column(name = "observationsBeneficiary", nullable = false, length = 300)
    private String observationsBeneficiary;
    public Beneficiary() {
    }

    public Beneficiary(int idBeneficiary, int dniBenefeciary, String fullnameBenefeciary, int ageBeneficiary, String observationsBeneficiary) {
        this.idBeneficiary = idBeneficiary;
        this.dniBenefeciary = dniBenefeciary;
        this.fullnameBenefeciary = fullnameBenefeciary;
        this.ageBeneficiary = ageBeneficiary;
        this.observationsBeneficiary = observationsBeneficiary;
    }
    public int getIdBeneficiary() {
        return idBeneficiary;
    }

    public void setIdBeneficiary(int idBeneficiary) {
        this.idBeneficiary = idBeneficiary;
    }

    public int getDniBenefeciary() {
        return dniBenefeciary;
    }

    public void setDniBenefeciary(int dniBenefeciary) {
        this.dniBenefeciary = dniBenefeciary;
    }

    public String getFullnameBenefeciary() {
        return fullnameBenefeciary;
    }

    public void setFullnameBenefeciary(String fullnameBenefeciary) {
        this.fullnameBenefeciary = fullnameBenefeciary;
    }

    public int getAgeBeneficiary() {
        return ageBeneficiary;
    }

    public void setAgeBeneficiary(int ageBeneficiary) {
        this.ageBeneficiary = ageBeneficiary;
    }

    public String getObservationsBeneficiary() {
        return observationsBeneficiary;
    }

    public void setObservationsBeneficiary(String observationsBeneficiary) {
        this.observationsBeneficiary = observationsBeneficiary;
    }
}

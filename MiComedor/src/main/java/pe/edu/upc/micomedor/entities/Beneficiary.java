package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Beneficiary")
public class Beneficiary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBeneficiary;

    @Column(name = "dniBenefeciary", nullable = false, unique = true) // Unicidad GLOBAL
    private int dniBenefeciary;

    @Column(name = "fullnameBenefeciary", nullable = false, length = 50)
    private String fullnameBenefeciary;

    @Column(name = "ageBeneficiary", nullable = false)
    private int ageBeneficiary;

    @Column(name = "observationsBeneficiary", nullable = false, length = 300)
    private String observationsBeneficiary;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private Users users;

    public Beneficiary() {}

    public Beneficiary(int idBeneficiary, int dniBenefeciary, String fullnameBenefeciary, int ageBeneficiary, String observationsBeneficiary, boolean isActive, Users users) {
        this.idBeneficiary = idBeneficiary;
        this.dniBenefeciary = dniBenefeciary;
        this.fullnameBenefeciary = fullnameBenefeciary;
        this.ageBeneficiary = ageBeneficiary;
        this.observationsBeneficiary = observationsBeneficiary;
        this.isActive = isActive;
        this.users = users;
    }

    public int getIdBeneficiary() { return idBeneficiary; }
    public void setIdBeneficiary(int idBeneficiary) { this.idBeneficiary = idBeneficiary; }

    public int getDniBenefeciary() { return dniBenefeciary; }
    public void setDniBenefeciary(int dniBenefeciary) { this.dniBenefeciary = dniBenefeciary; }

    public String getFullnameBenefeciary() { return fullnameBenefeciary; }
    public void setFullnameBenefeciary(String fullnameBenefeciary) { this.fullnameBenefeciary = fullnameBenefeciary; }

    public int getAgeBeneficiary() { return ageBeneficiary; }
    public void setAgeBeneficiary(int ageBeneficiary) { this.ageBeneficiary = ageBeneficiary; }

    public String getObservationsBeneficiary() { return observationsBeneficiary; }
    public void setObservationsBeneficiary(String observationsBeneficiary) { this.observationsBeneficiary = observationsBeneficiary; }

    public boolean getIsActive() { return isActive; }
    public void setIsActive(boolean active) { isActive = active; }

    public Users getUsers() { return users; }
    public void setUsers(Users users) { this.users = users; }
}

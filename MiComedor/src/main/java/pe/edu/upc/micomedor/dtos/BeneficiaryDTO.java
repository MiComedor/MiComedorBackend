package pe.edu.upc.micomedor.dtos;

import pe.edu.upc.micomedor.entities.Users;

public class BeneficiaryDTO {
    private int idBeneficiary;
    private int dniBenefeciary;
    private String fullnameBenefeciary;
    private int ageBeneficiary;
    private String observationsBeneficiary;
    private boolean isActive = true;
    private Users users;

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
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }
}

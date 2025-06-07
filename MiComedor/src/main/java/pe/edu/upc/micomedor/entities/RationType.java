package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="RationType")
public class RationType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRationType;
    @Column(name = "nameRationType",length = 50, unique = true)
    private String nameRationType;

    public int getIdRationType() {
        return idRationType;
    }

    public void setIdRationType(int idRationType) {
        this.idRationType = idRationType;
    }

    public String getNameRationType() {
        return nameRationType;
    }

    public void setNameRationType(String nameRationType) {
        this.nameRationType = nameRationType;
    }

    public RationType() {
    }
    public RationType(int idRationType, String nameRationType) {
        this.idRationType = idRationType;
        this.nameRationType = nameRationType;
    }


}

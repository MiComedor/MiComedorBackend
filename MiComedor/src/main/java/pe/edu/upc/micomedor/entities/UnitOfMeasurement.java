package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name="UnitOfMeasurementDTO")
public class UnitOfMeasurement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUnitOfMeasurement;
    @Column(name = "name", length = 50, unique = true)
    private String name;
    @Column(name = "abbreviation", length = 50, unique = true)
    private String abbreviation;

    public UnitOfMeasurement() {
    }


    public UnitOfMeasurement(int idUnitOfMeasurement, String name, String abbreviation) {
        this.idUnitOfMeasurement = idUnitOfMeasurement;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public int getIdUnitOfMeasurement() {
        return idUnitOfMeasurement;
    }

    public void setIdUnitOfMeasurement(int idUnitOfMeasurement) {
        this.idUnitOfMeasurement = idUnitOfMeasurement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
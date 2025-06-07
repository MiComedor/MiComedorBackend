package pe.edu.upc.micomedor.dtos;

public class UnitOfMeasurementDTO {
    private int idUnitOfMeasurement;
    private String name;
    private String abbreviation;

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

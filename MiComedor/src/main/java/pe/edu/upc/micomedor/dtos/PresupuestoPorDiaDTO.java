package pe.edu.upc.micomedor.dtos;

public class PresupuestoPorDiaDTO {
    private float ingresosHoy;
    private float egresosHoy;
    private float saldoFinal;

    public float getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(float saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public float getEgresosHoy() {
        return egresosHoy;
    }

    public void setEgresosHoy(float egresosHoy) {
        this.egresosHoy = egresosHoy;
    }

    public float getIngresosHoy() {
        return ingresosHoy;
    }

    public void setIngresosHoy(float ingresosHoy) {
        this.ingresosHoy = ingresosHoy;
    }
}
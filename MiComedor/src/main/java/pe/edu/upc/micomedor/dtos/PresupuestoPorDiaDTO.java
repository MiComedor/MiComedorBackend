package pe.edu.upc.micomedor.dtos;

public class PresupuestoPorDiaDTO {
    private int ingresosHoy;
    private int egresosHoy;
    private int saldoFinal;

    public int getIngresosHoy() {
        return ingresosHoy;
    }

    public void setIngresosHoy(int ingresosHoy) {
        this.ingresosHoy = ingresosHoy;
    }

    public int getEgresosHoy() {
        return egresosHoy;
    }

    public void setEgresosHoy(int egresosHoy) {
        this.egresosHoy = egresosHoy;
    }

    public int getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(int saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
}

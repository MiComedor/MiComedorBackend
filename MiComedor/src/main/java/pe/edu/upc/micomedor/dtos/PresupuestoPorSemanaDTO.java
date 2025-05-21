package pe.edu.upc.micomedor.dtos;
import java.time.LocalDate;
public class PresupuestoPorSemanaDTO {
    private LocalDate Fecha;
    private String dia;
    private String fechasDiaMes;
    private int ingresosPorDia;
    private int egresosPorDia;
    private int saldoPorDia;

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFechasDiaMes() {
        return fechasDiaMes;
    }

    public void setFechasDiaMes(String fechasDiaMes) {
        this.fechasDiaMes = fechasDiaMes;
    }

    public int getIngresosPorDia() {
        return ingresosPorDia;
    }

    public void setIngresosPorDia(int ingresosPorDia) {
        this.ingresosPorDia = ingresosPorDia;
    }

    public int getEgresosPorDia() {
        return egresosPorDia;
    }

    public void setEgresosPorDia(int egresosPorDia) {
        this.egresosPorDia = egresosPorDia;
    }

    public int getSaldoPorDia() {
        return saldoPorDia;
    }

    public void setSaldoPorDia(int saldoPorDia) {
        this.saldoPorDia = saldoPorDia;
    }
}

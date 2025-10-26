package pe.edu.upc.micomedor.dtos;
import java.time.LocalDate;
public class PresupuestoPorSemanaDTO {
    private LocalDate Fecha;
    private String dia;
    private String fechasDiaMes;
    private float ingresosPorDia;
    private float egresosPorDia;
    private float saldoPorDia;

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

    public float getSaldoPorDia() {
        return saldoPorDia;
    }

    public void setSaldoPorDia(float saldoPorDia) {
        this.saldoPorDia = saldoPorDia;
    }

    public float getEgresosPorDia() {
        return egresosPorDia;
    }

    public void setEgresosPorDia(float egresosPorDia) {
        this.egresosPorDia = egresosPorDia;
    }

    public float getIngresosPorDia() {
        return ingresosPorDia;
    }

    public void setIngresosPorDia(float ingresosPorDia) {
        this.ingresosPorDia = ingresosPorDia;
    }
}
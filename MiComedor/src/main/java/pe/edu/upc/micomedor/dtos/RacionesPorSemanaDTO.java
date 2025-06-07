package pe.edu.upc.micomedor.dtos;

public class RacionesPorSemanaDTO {
    private String dia;
    private String fecha;
    private int totalRaciones;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotalRaciones() {
        return totalRaciones;
    }

    public void setTotalRaciones(int totalRaciones) {
        this.totalRaciones = totalRaciones;
    }
}

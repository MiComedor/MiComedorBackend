package pe.edu.upc.micomedor.dtos;

public class BeneficiarioPorSemanaDTO {
    private String dia;
    private String fecha;
    private int totalBeneficiarios;

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

    public int getTotalBeneficiarios() {
        return totalBeneficiarios;
    }

    public void setTotalBeneficiarios(int totalBeneficiarios) {
        this.totalBeneficiarios = totalBeneficiarios;
    }
}

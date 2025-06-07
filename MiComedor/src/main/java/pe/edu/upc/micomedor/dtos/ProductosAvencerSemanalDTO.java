package pe.edu.upc.micomedor.dtos;

public class ProductosAvencerSemanalDTO {
    private String descripcionProducto;
    private String diaVencimientos;
    private String fechaVencimiento;

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getDiaVencimientos() {
        return diaVencimientos;
    }

    public void setDiaVencimientos(String diaVencimientos) {
        this.diaVencimientos = diaVencimientos;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}

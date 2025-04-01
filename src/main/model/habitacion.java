package src.main.model;

public class habitacion {
    public int numHab;
    public tipohabitacion tipo;
    private estadohabitacion estado;
    private String descripcion;

    public habitacion(int numHab, tipohabitacion tipo, String descripcion) {
        this.numHab = numHab;
        this.tipo = tipo;
        this.estado = estadohabitacion.DISPONIBLE;
        this.descripcion = descripcion;
    }
    
    public tipohabitacion getTipo() {
        return tipo;
    }

    public String toString() {
        return "Habitación " + numHab + " - " + tipo + " (" + estado + ") ";
    }
}

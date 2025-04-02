package src.main.model;

public class habitacion {
    public int numHab;
    public tipohabitacion tipo;
    public estadohabitacion estado;

    public habitacion(int numHab, tipohabitacion tipo) {
        this.numHab = numHab;
        this.tipo = tipo;
        this.estado = estadohabitacion.DISPONIBLE;
    }
    
    public tipohabitacion getTipo() {
        return tipo;
    }

    public String toString() {
        return "Habitación " + numHab + " - " + tipo + " (" + estado + ") ";
    }
}

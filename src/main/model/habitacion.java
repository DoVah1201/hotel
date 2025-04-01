package src.main.model;

public class habitacion {
    private int numHab;
    private tipoHab tipo;
    private estadoHab estado;
    private String descripcion;

    public Habitacion(int numHab, tipoHab tipo, String descripcion) {
        this.numHab = numHab;
        this.tipo = tipo;
        this.estado = estadoHab.DISPONIBLE;
        this.descripcion = descripcion;
    }
    
    public tipoHab getTipo() {
        return tipo;
    }

    public String toString() {
        return "Habitación" + numHab + " - " + tipo + " (" + estado + ") ";
    }
}

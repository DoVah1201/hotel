package model;

public class Habitacion {
    public int numHab;
    public TipoHabitacion tipo;
    public EstadoHabitacion estado;

    public Habitacion(int numHab, TipoHabitacion tipo, EstadoHabitacion estado) {
        this.numHab = numHab;
        this.tipo = tipo;
        this.estado = estado;
    }
    
    public TipoHabitacion getTipo() {
        return tipo;
    }

    public String toString() {
        return "Habitación " + numHab + " - " + tipo + " (" + estado + ") Precio/noche: $" + tipo.getPrecioPorNoche();
    }
}
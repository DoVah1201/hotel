package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private static int ultimoId = 0;
    
    public int id;
    public Habitacion habitacion;
    public Cliente cliente;
    public LocalDate entrada;
    public LocalDate salida;
    public double precioTotal;

    public Reserva(Habitacion habitacion, Cliente cliente, LocalDate entrada, LocalDate salida) {
        this.id = ++ultimoId;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.entrada = entrada;
        this.salida = salida;
        calcularPrecio();
    }

    private void calcularPrecio() {
        long dias = ChronoUnit.DAYS.between(entrada, salida);
        this.precioTotal = dias * habitacion.tipo.getPrecioPorNoche();
    }

    public String toString() {
        return "Reserva #" + id + " - Hab: " + habitacion.numHab + 
               " Cliente: " + cliente.id + " (" + entrada + " a " + salida + 
               ") Total: $" + precioTotal;
    }
}
package src.main.model;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class reserva {
    
     private static int uId = 0; // Contador de IDs
    
    public int id;
    public habitacion habitacion;
    public cliente cliente;
    public LocalDate entrada;
    public LocalDate salida;
    public double precioTotal;

    public reserva(habitacion habitacion, cliente cliente, LocalDate entrada, LocalDate salida) {

        this.id = ++uId;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this. entrada = entrada;
        this.salida =salida;

    }

    private void precioCalculado() {
        long dia = ChronoUnit.DAYS.between(entrada, salida);
        this.precioTotal = dia * habitacion.tipo.getPrecio();
    }

    public String toString() {
        return "reserva #" + id + " - " + habitacion.numHab + "(" + entrada + " a " + salida +")";
    }

}

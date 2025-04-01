package src.main.model;

import java.util.ArrayList;
import java.util.List;

public class cliente {
    private static int ultimoId = 0;

    public int id;
    public String nombre;
    public List<reserva> reservasActuales;
    public List<reserva> historialReservas;

    public cliente(String nombre) {
        this.id = ++ultimoId;
        this.nombre = nombre;
        this.reservasActuales = new ArrayList<>();
        this.historialReservas = new ArrayList<>();
    }

    public boolean puedeReservar() {
        return reservasActuales.size() < 3;
    }
    
    public void añadirReserva(reserva r) {
        reservasActuales.add(r);
    }

    public String toString() {
        return "Cliente #" + id + ": " + nombre;
    }
}

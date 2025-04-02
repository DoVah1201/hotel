package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int ultimoId = 0;

    public int id;
    public String nombre;
    public List<Reserva> reservasActuales;
    public List<Reserva> historialReservas;

    public Cliente(String nombre) {
        this.id = ++ultimoId;
        this.nombre = nombre;
        this.reservasActuales = new ArrayList<>();
        this.historialReservas = new ArrayList<>();
    }

    public boolean puedeReservar() {
        return reservasActuales.size() < 3;
    }
    
    public void añadirReserva(Reserva r) {
        reservasActuales.add(r);
    }

    public String toString() {
        return "Cliente #" + id + ": " + nombre + " (Reservas activas: " + reservasActuales.size() + ")";
    }
}
package src.main.controladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import src.main.model.cliente;
import src.main.model.estadohabitacion;
import src.main.model.habitacion;
import src.main.model.reserva;
import src.main.model.tipohabitacion;
import src.main.restricciones.excepcionesHotel;

public class GestorHotel {
    public List<habitacion> habitaciones;
    public List<cliente> clientes;
    public List<reserva> reservas;

    public GestorHotel() {
        habitaciones = new ArrayList<>();
        clientes = new ArrayList<>();
        reservas = new ArrayList<>();
        iniciarHotel();
    }

    private void iniciarHotel() {
        for (int i = 1; i <= 5; i++) {
            habitaciones.add(new habitacion(100 + i, tipohabitacion.INDIVIDUAL, ""));
        }

        for (int i = 1; i <= 5; i++) {
            habitaciones.add(new habitacion(200 + i, tipohabitacion.DOBLE, ""));
        }

        for (int i = 1; i <= 5; i++) {
            habitaciones.add(new habitacion(300 + i, tipohabitacion.SUITE, ""));
        }
    }

    public habitacion buscarHabitacion(int numHab) {
        for (habitacion h : habitaciones) {
            if (h.numHab == numHab) {
                return h;
            }
        }
    }

    public void hacerReserva(int numHab, int idCliente, LocalDate in, LocalDate out) throws excepcionesHotel {
        if (in.isBefore(LocalDate.now())) {
            throw new excepcionesHotel("No se pueden reservar fechas pasadas");
        }

        if (out.isBefore(in)) {
            throw new excepcionesHotel("La fecha de salida debe ser posterior a la entrada");
        }

        habitacion hab = buscarHabitacion(numHab);
        if (hab == null) {
            throw new excepcionesHotel("Habitación no existente");
        }

        if (hab.estado != estadohabitacion.DISPONIBLE) {
            throw new excepcionesHotel("Habitación no disponible");
        }

        cliente cli = null;
        for (cliente c : clientes) {
            if(c.id == idCliente) {
                cli = c;
                break;
            }
        }

        if (cli == null) {
            throw new excepcionesHotel("Cliente no registrado");
        }

        if (!cli.puedeReservar()) {
            throw new excepcionesHotel("El cliente tiene demasiadas reservas");
        }

        reserva nueva = new reserva(hab, cli, in, out);
        reservas.add(nueva);
        cli.añadirReserva(nueva);
        hab.estado = estadohabitacion.RESERVADA;

        System.out.println("Reserva realizada con éxito: " + nueva);
    }
}

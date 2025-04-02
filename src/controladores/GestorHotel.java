package controladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.ExcepcionesHotel;
import model.Cliente;
import model.EstadoHabitacion;
import model.Habitacion;
import model.Reserva;
import model.TipoHabitacion;

public class GestorHotel {
    private List<Habitacion> habitaciones;
    private List<Cliente> clientes;
    private List<Reserva> reservas;

    public GestorHotel() {
        habitaciones = new ArrayList<>();
        clientes = new ArrayList<>();
        reservas = new ArrayList<>();
        iniciarHotel();
    }

    private void iniciarHotel() {
        
        for (int i = 0; i < 5; i++) {
            habitaciones.add(new Habitacion(100 + i, TipoHabitacion.INDIVIDUAL, EstadoHabitacion.DISPONIBLE));
        }

        
        for (int i = 0; i < 5; i++) {
            habitaciones.add(new Habitacion(200 + i, TipoHabitacion.DOBLE, EstadoHabitacion.DISPONIBLE));
        }

      
        for (int i = 0; i < 5; i++) {
            habitaciones.add(new Habitacion(300 + i, TipoHabitacion.SUITE, EstadoHabitacion.DISPONIBLE));
        }
    }

    public int registrarCliente(String nombre) {
        Cliente nuevoCliente = new Cliente(nombre);
        clientes.add(nuevoCliente);
        return nuevoCliente.id;
    }

    public Habitacion buscarHabitacion(int numHab) throws ExcepcionesHotel {
        for (Habitacion h : habitaciones) {
            if (h.numHab == numHab) {
                return h;
            }
        }
        throw new ExcepcionesHotel("Habitación no encontrada");
    }

    public Cliente buscarCliente(int idCliente) throws ExcepcionesHotel {
        for (Cliente c : clientes) {
            if (c.id == idCliente) {
                return c;
            }
        }
        throw new ExcepcionesHotel("Cliente no registrado");
    }

    public void hacerReserva(int numHab, int idCliente, LocalDate entrada, LocalDate salida) throws ExcepcionesHotel {
        // Validaciones existentes...
        if (entrada.isBefore(LocalDate.now())) {
            throw new ExcepcionesHotel("No se pueden reservar fechas pasadas");
        }
    
        if (salida.isBefore(entrada)) {
            throw new ExcepcionesHotel("La fecha de salida debe ser posterior a la entrada");
        }
    
        Habitacion hab = buscarHabitacion(numHab);
        if (hab.estado != EstadoHabitacion.DISPONIBLE) {
            throw new ExcepcionesHotel("Habitación no disponible");
        }
    
        Cliente cli = buscarCliente(idCliente);
        if (!cli.puedeReservar()) {
            throw new ExcepcionesHotel("El cliente tiene demasiadas reservas activas (máximo 3)");
        }
    
        // Crear la reserva
        Reserva nueva = new Reserva(hab, cli, entrada, salida);
        reservas.add(nueva);
        cli.añadirReserva(nueva);
        

        hab.estado = EstadoHabitacion.RESERVADA;
        System.out.println("Estado de la habitación " + hab.numHab + " cambiado a RESERVADA."); 
    
    }

    public void cancelarReserva(int idReserva) throws ExcepcionesHotel {
        Reserva reservaCancelar = null;
        for (Reserva r : reservas) {
            if (r.id == idReserva) {
                reservaCancelar = r;
                break;
            }
        }
        
        if (reservaCancelar == null) {
            throw new ExcepcionesHotel("Reserva no encontrada");
        }
        
        if (reservaCancelar.entrada.isBefore(LocalDate.now())) {
            throw new ExcepcionesHotel("No se puede cancelar una reserva ya comenzada");
        }
        
        reservaCancelar.habitacion.estado = EstadoHabitacion.DISPONIBLE;
        reservaCancelar.cliente.reservasActuales.remove(reservaCancelar);
        reservas.remove(reservaCancelar);
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
}
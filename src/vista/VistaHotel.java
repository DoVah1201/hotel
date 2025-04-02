package vista;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import model.Habitacion;

public class VistaHotel {
    private Scanner scanner;

    public VistaHotel() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("=== SISTEMA DE RESERVAS ===");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Hacer una reserva");
        System.out.println("3. Ver habitaciones");
        System.out.println("4. Cancelar reserva");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    public String obtenerDatosCliente() {
        System.out.println("--- NUEVO CLIENTE ---");
        System.out.print("Nombre completo: ");
        return scanner.nextLine();
    }

    public Object[] obtenerDatosReserva() {
        System.out.println("--- NUEVA RESERVA ---");
        
        System.out.print("Número de habitación: ");
        int numHab = Integer.parseInt(scanner.nextLine());
            
        System.out.print("ID de cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        
        LocalDate entrada = obtenerFecha("Fecha de entrada (YYYY-MM-DD): ");
        LocalDate salida = obtenerFecha("Fecha de salida (YYYY-MM-DD): ");
        
        return new Object[]{numHab, idCliente, entrada, salida};
    }

    private LocalDate obtenerFecha(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto. Use YYYY-MM-DD");
            }
        }
    }

    public void mostrarError(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }

    public void mostrarExito(String mensaje) {
        System.out.println("ÉXITO: " + mensaje);
    }

    public int obtenerIdReservaCancelacion() {
        System.out.println("--- CANCELAR RESERVA ---");
        System.out.print("ID de reserva a cancelar: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarHabitaciones(List<Habitacion> habitaciones) {
        System.out.println("--- HABITACIONES DISPONIBLES ---");
        for (Habitacion h : habitaciones) {
            System.out.println(h);
        }
    }
}
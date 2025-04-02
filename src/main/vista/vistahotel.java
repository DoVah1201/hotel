package src.main.vista;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class vistahotel {
        
    private Scanner scanner;

    public vistahotel() {
        scanner = new Scanner(System.in);
    }

    public void Menu() {
        System.out.println("=== SISTEMA DE RESERVAS ===");
        System.out.println("1_ Registrar nuevo cliente");
        System.out.println("2_ Hacer una reserva");
        System.out.println("3_ Ver habitaciones");
        System.out.println("4_ Cancelar reserva");
        System.out.println("5_ Salir");
        System.out.println("Escoja una opcion");
    }

    public int leer() {
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public String[] registroCliente() {
        System.out.println("--- NUEVO CLIENTE ---");
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        return new String[]{nombre};
    }

    public Object[] datosReserva() {
        System.out.println("--- NUEVA RESERVA ---");
        
        System.out.print("Número de habitación: ");
        int numHab = Integer.parseInt(scanner.nextLine());
            
        System.out.print("ID de cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        
        LocalDate entrada = Fecha("Fecha de entrada (YYYY-MM-DD): ");
        LocalDate salida = Fecha("Fecha de salida (YYYY-MM-DD): ");
        
        return new Object[]{numHab, idCliente, entrada, salida};
    }

    private LocalDate Fecha(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto. Usa YYYY-MM-DD");
            }
        }
    }

    public void Error(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }

    public void Exito(String mensaje) {
        System.out.println("ÉXITO: " + mensaje);
    }

    public int datosCancelacion() {
        System.out.println("--- CANCELAR RESERVA ---");
        System.out.print("ID de reserva a cancelar: ");
        return Integer.parseInt(scanner.nextLine());
    }
}

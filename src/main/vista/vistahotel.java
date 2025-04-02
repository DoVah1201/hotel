package src.main.vista;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.lang.*;

public class vistahotel {
        
private Scanner scanner;

public vistahotel() {
    scanner = new Scanner(System.in);
}

public void Menu () {

    System.out.println("=== SISTEMA DE RESERVAS ===");
    System.out.println("1_ Registrar nuevo cliente");
    System.out.println("2_ Hacer una reserva");
    System.out.println("3_ Ver habitaciones");
    System.out.println("4_ Cancelar reserva");
    System.out.println("5_ Salir");
    System.out.println("Escoja una opcion");

}

public int leer() {
    try {
        return Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
        return -1;
    }
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
    
    LocalDate entrada = leer("Fecha de entrada (YYYY-MM-DD): ");
    LocalDate salida = leer("Fecha de salida (YYYY-MM-DD): ");
    
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

}

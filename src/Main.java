import controladores.GestorHotel;
import vista.VistaHotel;
import excepciones.ExcepcionesHotel;

public class Main {
    public static void main(String[] args) {
        GestorHotel controlador = new GestorHotel();
        VistaHotel vista = new VistaHotel();

        System.out.println("BIENVENIDO AL SISTEMA DE RESERVAS DEL HOTEL");

        boolean salir = false;
        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();

            try {
                switch (opcion) {
                    case 1:
                        String nombreCliente = vista.obtenerDatosCliente();
                        int idCliente = controlador.registrarCliente(nombreCliente); // Capturar el ID devuelto
                        vista.mostrarExito("Cliente registrado exitosamente. ID: " + idCliente); // Mostrar el ID
                        break;

                    case 2:
                        Object[] datosReserva = vista.obtenerDatosReserva();
                        controlador.hacerReserva(
                                (int) datosReserva[0],
                                (int) datosReserva[1],
                                (java.time.LocalDate) datosReserva[2],
                                (java.time.LocalDate) datosReserva[3]);
                        vista.mostrarExito("Reserva realizada con éxito");
                        break;

                    case 3:
                        vista.mostrarHabitaciones(controlador.getHabitaciones());
                        break;

                    case 4:
                        int idReserva = vista.obtenerIdReservaCancelacion();
                        controlador.cancelarReserva(idReserva);
                        vista.mostrarExito("Reserva cancelada exitosamente");
                        break;

                    case 5:
                        salir = true;
                        break;

                    default:
                        vista.mostrarError("Opción no válida");
                }

            } catch (ExcepcionesHotel e) {
                vista.mostrarError("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                vista.mostrarError("Error en formato numérico");
            } catch (Exception e) {
                vista.mostrarError("Error inesperado: " + e.getMessage());
            }
        }
        System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
    }
}
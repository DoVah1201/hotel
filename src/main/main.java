package src.main;

import src.main.controladores.*;
import src.main.vista.*;
import src.main.excepciones.*;
import src.main.model.estadohabitacion;
import src.main.model.habitacion;
import src.main.model.tipohabitacion;
import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        GestorHotel controlador = new GestorHotel();
        vistahotel vista = new vistahotel();

        System.out.println("BIENVENIDO AL SISTEMA DE RESERVAS DEL HOTEL");

        boolean Salir = false;
        while (!Salir) {
            vista.Menu();
            int opcion = vista.leer();

            try {
                switch (opcion) {
                    case 1:
                        String[] datosCliente = vista.registroCliente();
                        vista.Exito("Cliente registrado (no implementado)");
                        break;

                    case 2:
                        Object[] datosReserva = vista.datosReserva();
                        controlador.hacerReserva(
                                (int) datosReserva[0],
                                (int) datosReserva[1],
                                (java.time.LocalDate) datosReserva[2],
                                (java.time.LocalDate) datosReserva[3]);
                        vista.Exito("Reserva realizada");
                        break;

                    case 3:
                        System.out.println("--- HABITACIONES ---");
                        for (src.main.model.habitacion h : controlador.habitaciones) {
                            System.out.println();
                        }

                        break;

                    case 4:
                        int idReserva = vista.datosCancelacion();
                        controlador.cancelarReserva(idReserva);
                        vista.Exito("Reserva cancelada");
                        break;

                    case 5:
                        Salir = true;
                        break;

                    default:
                        vista.Error("Opción no válida");
                }
            } catch (Exception e) {
                vista.Error(e.getMessage());
            } catch (excepcionesHotel e) {
                vista.Error("Error inesperado: " + e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
    }
}
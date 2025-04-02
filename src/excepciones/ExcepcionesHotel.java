package excepciones;

public class ExcepcionesHotel extends Exception {
    // Constructor que recibe un mensaje como argumento
    public ExcepcionesHotel(String mensaje) {
        super(mensaje); // Llama al constructor de la clase base (Exception) con el mensaje
    }
}

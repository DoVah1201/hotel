package model;

public enum TipoHabitacion {
    INDIVIDUAL(50), 
    DOBLE(80), 
    SUITE(150);
    
    private double precioPorNoche;
    
    TipoHabitacion(double precio) {
        this.precioPorNoche = precio;
    }
    
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
}
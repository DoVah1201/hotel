package src.main.model;

public enum tipohabitacion {
    
        INDIVIDUAL(50), DOBLE(80), SUITE(150);
        
        private double precioPorNoche;
        
         tipohabitacion(double precio) {
            this.precioPorNoche = precio;
        }
        
        public double getPrecioPorNoche() {
            return precioPorNoche;
        }
    }



# 🏨 Gestor de Reservas de Hotel - Proyecto DAW

**Sistema de gestión de reservas para hoteles implementado en Java con arquitectura MVC**

## 📝 Descripción

Este proyecto es un sistema de gestión de reservas para un hotel ficticio desarrollado como parte del módulo de programación en 1º DAW. Permite:

- Registrar clientes
- Gestionar habitaciones (individuales, dobles, suites)
- Realizar reservas con control de fechas
- Consultar disponibilidad
- Gestionar hasta 3 reservas activas por cliente

## 🛠️ Tecnologías utilizadas

- **Lenguaje**: Java 11
- **Patrón arquitectónico**: MVC (Modelo-Vista-Controlador)
- **Control de versiones**: Git
- **Persistencia**: Datos en memoria (sin base de datos)

## 🗂️ Estructura del proyecto
hotel/
├── src/main
│ ├── model/ 
│ │ ├── cliente.java
│ │ ├── habitacion.java
│ │ ├── reserva.java
│ │ ├── tipohabitacion.java
│ │ └── estadohabitacion.java
│ ├── vista/ 
│ │ └── vistahotel.java
│ ├── controladores/ 
│ │ └── GestorHotel.java
│ ├── excepciones/ 
│ │ └── excepcionesHotel.java
│ └──main.java
├── .gitignore
├── README.md
└── LICENSE


## 🚀 Cómo ejecutar

1. Clonar el repositorio:
   
   ```bash
   git clone https://github.com/tu-usuario/hotel-manager.git

2. Compilar y ejecutar

cd hotel-manager
javac src/*/*.java -d bin
java -cp bin src.Main

3. Usar el menu interactivo

✨ Características principales
✅ Gestión de habitaciones:

3 plantas (15 habitaciones totales)

Tipos: Individual (50€), Doble (80€), Suite (150€)

Estados: Disponible/Reservada/Ocupada

✅ Control de reservas:

Máximo 3 reservas por cliente

Validación de fechas (no pasadas, check-out > check-in)

Precio calculado por noches

✅ Interfaz sencilla:

Menú por consola

Mensajes de error descriptivos

Validación de entradas

📌 Requisitos del sistema
JDK 11 o superior

Git (opcional para control de versiones)

🤝 Contribución

Este proyecto es parte del currículo educativo y no acepta contribuciones externas, pero puedes:

Hacer fork para prácticas personales

Reportar issues si encuentras errores

Adaptar el código para tus necesidades

📄 Licencia
Proyecto educativo sin licencia específica. Libre para uso académico.

⌨️ Hecho con mucho café por Saúl González Navarro y Marisa Peña Rey- Estudiantes de 1º DAW Villa de Agüimes, Gran canaria🎓
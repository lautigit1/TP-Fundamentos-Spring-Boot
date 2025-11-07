# TP - Fundamentos de Spring Boot (Gestor de Tareas)

**Alumno:** Lautaro Salinas - Legajo 52834
**Asignatura:** Programación III - UTN

## Descripción
Esta es una aplicación de consola hecha en Spring Boot que levanta un Gestor de Tareas (To-Do List) simple. La data se guarda en memoria (se borra cuando cerrás la app), porque el objetivo era demostrar los fundamentos de Spring:
* Inyección de dependencias (por constructor, como tiene que ser).
* Estereotipos (`@Service`, `@Repository`).
* Configuración externa usando `application.properties`.
* Manejo de **Profiles** (`dev` y `prod`) para distintos entornos.

## Tecnologías
* Java 17+
* Spring Boot 3.x
* Maven
* Lombok (para no escribir getters/setters como un cavernícola)
* Spring Boot DevTools

## Cómo clonar y ejecutar
```bash
git clone https://github.com/lautigit1/tp-fundamentos-spring-boot.git
cd tp-fundamentos-spring-boot
mvn clean package
mvn spring-boot:run
El proyecto viene configurado para correr con el profile dev por defecto.

Cambiar entre profiles (dev / prod)
Podés cambiar el perfil activo de dos maneras:

En el archivo: En src/main/resources/application.properties, cambiá la línea:

Properties

spring.profiles.active=dev   # (cambiar por prod)
Por argumento (recomendado): No tocás nada y le mandás el perfil al comando de Maven:

Bash

mvn spring-boot:run -Dspring-boot.run.profiles=prod
Qué se imprime en consola (flujo)
Al ejecutar la app, vas a ver este flujo de operaciones en la terminal:

Mensaje de bienvenida (distinto para dev y prod).

Configuración actual (nombre, max-tareas, mostrar-estadísticas).

Listado de tareas iniciales (cargadas desde el Repository).

Se agrega una nueva tarea.

Listado de tareas pendientes.

Se marca la primera tarea como completada.

Se muestran estadísticas (si el profile dev está activo).

Listado de tareas completadas.

Mensaje de despedida (distinto para dev y prod).

# Conclusiones personales

Si bien esta aplicación mantiene un alcance funcional acotado (un gestor de tareas en memoria), el objetivo principal del trabajo era aplicar y comprender los pilares fundamentales de Spring Boot. Las conclusiones obtenidas son las siguientes:

Inversión de Control (IoC) e Inyección de Dependencias (DI): Este es, sin dudas, el concepto central. En lugar de que nuestras clases creen sus propias dependencias (ej: new TareaRepository()), delegamos esa responsabilidad al contenedor de Spring. Al solicitar las dependencias vía constructor, logramos un código mucho más limpio, modular y, sobre todo, desacoplado. Esto facilita enormemente el mantenimiento y la realización de pruebas unitarias.

Esterotipos y Detección de Componentes: El uso de anotaciones como @Service y @Repository no es solo semántico. Le indican a Spring que debe escanear estas clases, crear una instancia de ellas (un Bean) y gestionarla dentro de su contenedor, dejándola lista para ser inyectada en cualquier otra clase que la necesite. Esto automatiza la configuración de forma muy eficiente.

Configuración Externalizada: Mover la configuración (como el nombre de la app o el límite de tareas) fuera del código fuente, hacia los archivos application.properties, es una práctica fundamental. Permite modificar el comportamiento de la aplicación en diferentes entornos (desarrollo, testing, producción) sin necesidad de tocar el código Java ni de recompilar el proyecto.

Gestión de Perfiles (Profiles): Este concepto ata todo lo anterior. La capacidad de definir perfiles (dev, prod) y tener archivos de propiedades específicos para cada uno (application-dev.properties, etc.) resultó ser extremadamente potente. Permite que la misma base de código se comporte de manera radicalmente distinta según dónde se ejecute, habilitando logs de depuración en un entorno y configuraciones de rendimiento en otro.

En resumen, Spring Boot elimina una cantidad masiva de código "boilerplate" (repetitivo) y guía al desarrollador hacia la adopción de patrones de diseño sólidos que resultan en aplicaciones más robustas, flexibles y fáciles de mantener.
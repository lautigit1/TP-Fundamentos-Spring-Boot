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

## Capturas de pantalla

![Consola modo DEV](https://raw.githubusercontent.com/lautigit1/tp-fundamentos-spring-boot/master/src/main/resources/screenshots/captura1.png)
...
![Consola modo PROD](https://raw.githubusercontent.com/lautigit1/tp-fundamentos-spring-boot/master/src/main/resources/screenshots/captura2.png)
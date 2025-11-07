# TP - Fundamentos de Spring Boot (Gestor de Tareas)

**Alumno:** Lautaro Salinas - Legajo 52834 
**Asignatura:** Programación III - UTN

## Descripción
Aplicación de consola (Spring Boot) que implementa un **Gestor de Tareas (To-Do List)** en memoria, diseñada para demostrar: inyección por constructor, estereotipos (`@Service`, `@Repository`), configuración por `application.properties`, y **profiles** (`dev`, `prod`).

## Tecnologías
- Java 17+
- Spring Boot 3.x
- Maven
- Lombok (para reducir boilerplate)
- Spring Boot DevTools

## Cómo clonar y ejecutar
```bash
git clone https://github.com/tu-usuario/tu-repo-tareas.git
cd tu-repo-tareas
mvn clean package
mvn spring-boot:run
```

> El proyecto viene configurado para correr con el profile `dev` por defecto (revisar `application.properties`).

## Cambiar entre profiles (dev / prod)
En `src/main/resources/application.properties` podés cambiar:
```properties
spring.profiles.active=dev   # o prod
```
O correr con profile por argumento:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

## Qué se imprime en consola (flujo)
1. Mensaje de bienvenida (según profile)
2. Configuración actual (app.nombre, app.max-tareas, app.mostrar-estadisticas)
3. Listado de tareas iniciales
4. Se agrega una nueva tarea
5. Listado de pendientes
6. Se marca una tarea como completada
7. Se muestran estadísticas
8. Listado de completadas
9. Mensaje de despedida

## Capturas de pantalla
Guardá tus capturas en `src/main/resources/screenshots` y linkéalas desde aquí.

## Observaciones / Conclusiones personales
- Inyección por constructor mejora testabilidad y desacopla capas.
- Repositorio en memoria es útil para fines didácticos; para producción usar DB y JPA.

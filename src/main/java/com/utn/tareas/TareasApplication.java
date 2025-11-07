package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication

public class TareasApplication implements CommandLineRunner {

    private final TareaService tareaService;
    private final MensajeService mensajeService;

    public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
        this.tareaService = tareaService;
        this.mensajeService = mensajeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TareasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mensajeService.mostrarBienvenida();

        // Mostrar configuracion
        tareaService.imprimirConfiguracion();

        // Listar tareas iniciales
        System.out.println("Tareas iniciales:");
        listar(tareaService.listarTodas());

        // Agregar nueva tarea
        System.out.println("\nAgregando nueva tarea...");
        Tarea agregada = tareaService.agregar("Nueva tarea desde CommandLineRunner", Prioridad.ALTA);
        System.out.println("Agregada: " + agregada);

        // Listar pendientes
        System.out.println("\nTareas pendientes:");
        listar(tareaService.listarPendientes());

        // Marcar una tarea como completada (ej: la primera)
        List<Tarea> todas = tareaService.listarTodas();
        if (!todas.isEmpty()) {
            Long idParaCompletar = todas.get(0).getId();
            boolean ok = tareaService.marcarComoCompletada(idParaCompletar);
            System.out.println("\nMarcando como completada la tarea id=" + idParaCompletar + " -> " + (ok ? "OK" : "NO ENCONTRADA"));
        }

        // Mostrar estadisticas
        System.out.println("\nEstadísticas:");
        System.out.println(tareaService.obtenerEstadisticas());

        // Listar completadas
        System.out.println("\nTareas completadas:");
        listar(tareaService.listarCompletadas());

        mensajeService.mostrarDespedida();
    }

    private void listar(List<Tarea> tareas) {
        tareas.forEach(t -> System.out.println(t));
    }
}

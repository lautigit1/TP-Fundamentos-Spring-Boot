package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    private final TareaRepository repository;

    @Value("${app.nombre:GestorTareas}")
    private String appNombre;

    @Value("${app.max-tareas:100}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas:true}")
    private boolean mostrarEstadisticas;

    public TareaService(TareaRepository repository) {
        this.repository = repository;
    }

    public Tarea agregar(String descripcion, Prioridad prioridad) {
        List<Tarea> actuales = repository.obtenerTodas();
        if (actuales.size() >= maxTareas) {
            throw new IllegalStateException("No se puede agregar: se alcanzó el límite de tareas (" + maxTareas + ")");
        }
        Tarea nueva = new Tarea(null, descripcion, false, prioridad);
        return repository.guardar(nueva);
    }

    public List<Tarea> listarTodas() {
        return repository.obtenerTodas();
    }

    public List<Tarea> listarPendientes() {
        return repository.obtenerTodas().stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }

    public List<Tarea> listarCompletadas() {
        return repository.obtenerTodas().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    public boolean marcarComoCompletada(Long id) {
        return repository.buscarPorID(id).map(t -> {
            t.setCompletada(true);
            repository.guardar(t);
            return true;
        }).orElse(false);
    }

    public String obtenerEstadisticas() {
        int total = repository.obtenerTodas().size();
        int completadas = (int) repository.obtenerTodas().stream().filter(Tarea::isCompletada).count();
        int pendientes = total - completadas;
        String resultado = String.format("Total: %d, Completadas: %d, Pendientes: %d",
                total, completadas, pendientes);
        if (mostrarEstadisticas) {
            return resultado;
        } else {
            return "Estadísticas deshabilitadas (app.mostrar-estadisticas=false)";
        }
    }

    public void imprimirConfiguracion() {
        System.out.println("---- Configuración ----");
        System.out.println("app.nombre = " + appNombre);
        System.out.println("app.max-tareas = " + maxTareas);
        System.out.println("app.mostrar-estadisticas = " + mostrarEstadisticas);
        System.out.println("-----------------------");
    }
}

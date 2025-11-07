package com.utn.tareas.repository;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {

    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public TareaRepository() {
        // Tareas de ejemplo
        tareas.add(new Tarea(idCounter.getAndIncrement(), "Estudiar Spring Boot - TP", false, Prioridad.ALTA));
        tareas.add(new Tarea(idCounter.getAndIncrement(), "Hacer backup", true, Prioridad.MEDIA));
        tareas.add(new Tarea(idCounter.getAndIncrement(), "Enviar informe", false, Prioridad.BAJA));
    }

    public Tarea guardar(Tarea tarea) {
        if (tarea.getId() == null) {
            tarea.setId(idCounter.getAndIncrement());
        } else {
            eliminarPorID(tarea.getId());
        }
        tareas.add(tarea);
        return tarea;
    }

    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(tareas);
    }

    public Optional<Tarea> buscarPorID(Long id) {
        return tareas.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public boolean eliminarPorID(Long id) {
        return tareas.removeIf(t -> t.getId().equals(id));
    }
}

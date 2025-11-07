package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MensajeDevService implements MensajeService {

    @Override
    public void mostrarBienvenida() {
        System.out.println("¡Bienvenido al modo DEV! - TareasApp (perfil dev)");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("Cerrando aplicación en modo DEV. ¡Revisa los logs con DEBUG si hace falta!");
    }
}

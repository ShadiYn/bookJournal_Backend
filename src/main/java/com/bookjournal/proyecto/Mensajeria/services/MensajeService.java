package com.bookjournal.proyecto.Mensajeria.services;

import com.bookjournal.proyecto.Mensajeria.Entities.Mensaje;
import com.bookjournal.proyecto.Mensajeria.repositories.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajeService {

    private final MensajeRepository mensajeRepository;

    @Autowired
    public MensajeService(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    // Método para guardar un mensaje
    public Mensaje guardarMensaje(Mensaje mensaje) {
        if (mensaje.getRemitenteId() == null || mensaje.getDestinatarioId() == null || mensaje.getTexto() == null) {
            throw new IllegalArgumentException("Los campos del mensaje no pueden ser nulos");
        }
        // Validación adicional si es necesario

        return mensajeRepository.save(mensaje);  // Guardar el mensaje en la base de datos
    }

    // Métodos adicionales según sea necesario, como recuperar mensajes por usuario
}

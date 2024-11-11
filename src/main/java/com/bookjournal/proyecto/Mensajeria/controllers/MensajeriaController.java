package com.bookjournal.proyecto.Mensajeria.controllers;

import com.bookjournal.proyecto.Mensajeria.Entities.Mensaje;
import com.bookjournal.proyecto.Mensajeria.Entities.Usuario;
import com.bookjournal.proyecto.Mensajeria.repositories.MensajeRepository;
import com.bookjournal.proyecto.Mensajeria.repositories.UsuarioRepository;
import com.bookjournal.proyecto.Mensajeria.services.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("message")
public class MensajeriaController {

    @Autowired
    UsuarioRepository usuarioRepository;  // Inyecta UsuarioRepository

    @Autowired
    MensajeRepository mensajeRepository;  // Inyecta MensajeRepository

    @Autowired
    MensajeService mensajeService;
    // Guardar un nuevo mensaje
    @PostMapping
    public ResponseEntity<String> crearMensaje(@RequestBody Mensaje mensaje) {
        System.out.println("Datos recibidos: " + mensaje);
        // Verifica que el mensaje no sea nulo y que los campos estén completos
        if (mensaje.getRemitenteId() == null || mensaje.getDestinatarioId() == null || mensaje.getTexto() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los campos del mensaje no pueden ser nulos");
        }
        // Lógica para guardar el mensaje o lo que sea necesario
        return ResponseEntity.ok("Mensaje enviado correctamente");
    }



    // Consultar los mensajes de un usuario (por remitente o destinatario)
    @GetMapping("/{id}")
    public List<Map<String, String>> consultaMensajes(@PathVariable("id") Long id) {
        // Recuperar mensajes por ID de remitente o destinatario
        List<Mensaje> mensajes = mensajeRepository.findByRemitente_IdOrDestinatario_Id(id, id);
        return mensajes.stream().map(mensaje -> {
            Map<String, String> mensajeData = new HashMap<>();
            mensajeData.put("nombreRemitente", mensaje.getRemitenteNombre());
            mensajeData.put("texto", mensaje.getTexto());
            return mensajeData;
        }).collect(Collectors.toList());
    }
}

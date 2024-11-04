package com.bookjournal.proyecto.Mensajeria.controllers;


import com.bookjournal.proyecto.Mensajeria.Entities.Mensaje;
import com.bookjournal.proyecto.Mensajeria.MensajeDTO;
import com.bookjournal.proyecto.Mensajeria.repositories.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    MensajeRepository mensajeRepository;

    @PostMapping
    public void createMensaje(@RequestBody Mensaje mensaje) {
        mensajeRepository.save(mensaje);
    }

    @GetMapping("/{id}")
    public List<Map<String, String>> consultaMensajes(@PathVariable("id") Integer id) {
        List<Mensaje> mensajes = mensajeRepository.findMensajesFromIdRemitente(id);
        return mensajes.stream().map(mensaje -> {
            Map<String, String> mensajeData = new HashMap<>();
            mensajeData.put("nombreRemitente", mensaje.getRemitenteNombre());
            mensajeData.put("texto", mensaje.getTexto());
            return mensajeData;
        }).collect(Collectors.toList());
    }





}

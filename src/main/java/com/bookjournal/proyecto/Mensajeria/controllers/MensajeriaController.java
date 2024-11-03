package com.bookjournal.proyecto.Mensajeria.controllers;


import com.bookjournal.proyecto.Mensajeria.Entities.Mensaje;
import com.bookjournal.proyecto.Mensajeria.repositories.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Mensaje> consultaMensajes(@PathVariable("id") Integer id) {
        List<Mensaje> mensajes = mensajeRepository.findMensajesFromIdRemitente(id);
        return mensajes;
    }}

package com.bookjournal.proyecto.Mensajeria.controllers;

import com.bookjournal.proyecto.Mensajeria.Entities.Usuario;
import com.bookjournal.proyecto.Mensajeria.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{nombre}")
    public Integer login(@PathVariable String nombre) {

        Usuario u = usuarioRepository.findUsuario(nombre);
        if (u == null) {
            Usuario newUsuario = new Usuario();
            newUsuario.setNombre(nombre);
            Usuario u2 = usuarioRepository.save(newUsuario);
            return u2.getId();
        }
        return u.getId();
    }

    @GetMapping
    public List<Usuario> getUsers() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }



}

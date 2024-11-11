package com.bookjournal.proyecto.Mensajeria.controllers;

import com.bookjournal.proyecto.Mensajeria.Entities.Usuario;
import com.bookjournal.proyecto.Mensajeria.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inyecta el PasswordEncoder

    // Endpoint para obtener todos los usuarios
    @GetMapping("/all")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Método de login
    @PostMapping("/login")
    public Integer login(@RequestBody Map<String, String> loginData) {
        String nombre = loginData.get("nombre");
        String contraseña = loginData.get("contraseña");

        Usuario u = usuarioRepository.findUsuario(nombre);
        if (u != null && passwordEncoder.matches(contraseña, u.getContraseña())) { // Compara la contraseña encriptada
            return Math.toIntExact(u.getId());
        }
        return null; // Si la autenticación falla
    }

    // Método de registro
    @PostMapping("/register")
    public Integer register(@RequestBody Usuario newUsuario) {
        Usuario existingUser = usuarioRepository.findUsuario(newUsuario.getNombre());
        if (existingUser == null) {
            // Encriptamos la contraseña antes de guardarla
            String encodedPassword = passwordEncoder.encode(newUsuario.getContraseña());
            newUsuario.setContraseña(encodedPassword); // Seteamos la contraseña encriptada

            Usuario u = usuarioRepository.save(newUsuario); // Guardamos el nuevo usuario
            return Math.toIntExact(u.getId()); // Devolvemos el ID del nuevo usuario
        }
        return null; // Si el usuario ya existe
    }

    // Método para obtener todos los usuarios (opcional)
    @GetMapping
    public List<Usuario> getUsers() {
        return usuarioRepository.findAll();
    }
}

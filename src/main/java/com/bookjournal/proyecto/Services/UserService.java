package com.bookjournal.proyecto.Services;

import com.bookjournal.proyecto.entities.User;
import com.bookjournal.proyecto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user); // Asegúrate de que esto se está ejecutando
    }


    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll(); // Devuelve todos los usuarios
    }
}
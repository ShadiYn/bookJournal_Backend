package com.bookjournal.proyecto.repositories;

import com.bookjournal.proyecto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
User findByEmail(String email);
}

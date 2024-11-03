package com.bookjournal.proyecto.bookJournal.Controllers.repositories;

import com.bookjournal.proyecto.bookJournal.Controllers.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
User findByEmail(String email);
}

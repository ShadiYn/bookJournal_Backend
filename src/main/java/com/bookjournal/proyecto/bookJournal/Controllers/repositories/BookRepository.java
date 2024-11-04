package com.bookjournal.proyecto.bookJournal.Controllers.repositories;

import com.bookjournal.proyecto.bookJournal.Controllers.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // No hay métodos adicionales que busquen por userId
}

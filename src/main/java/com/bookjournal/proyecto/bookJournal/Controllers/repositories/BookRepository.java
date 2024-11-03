package com.bookjournal.proyecto.bookJournal.Controllers.repositories;

import com.bookjournal.proyecto.bookJournal.Controllers.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUserId(Long userId);
}

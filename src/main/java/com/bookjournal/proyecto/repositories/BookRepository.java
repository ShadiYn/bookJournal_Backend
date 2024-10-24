package com.bookjournal.proyecto.repositories;

import com.bookjournal.proyecto.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUserId(Long userId);
}

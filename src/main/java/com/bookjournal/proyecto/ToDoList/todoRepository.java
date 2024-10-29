package com.bookjournal.proyecto.ToDoList;

import com.bookjournal.proyecto.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface todoRepository extends JpaRepository<to_do, Long> {
}

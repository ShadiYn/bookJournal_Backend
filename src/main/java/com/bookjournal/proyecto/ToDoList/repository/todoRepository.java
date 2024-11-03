package com.bookjournal.proyecto.ToDoList.repository;

import com.bookjournal.proyecto.ToDoList.entities.to_do;
import org.springframework.data.jpa.repository.JpaRepository;

public interface todoRepository extends JpaRepository<to_do, Long> {
}

package com.bookjournal.proyecto.ToDoList.controller;


import com.bookjournal.proyecto.ToDoList.entities.to_do;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class todoController {

    @Autowired
    private com.bookjournal.proyecto.ToDoList.service.todoService todoService;

    @GetMapping
    public List<to_do> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<to_do> getTodoById(@PathVariable Long id) {
        to_do todo = todoService.getTodoById(id);
        return todo != null ? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<to_do> createTodo(@RequestBody to_do todo) {
        to_do createdTodo = todoService.createTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<to_do> updateTodo(@PathVariable Long id, @RequestBody to_do updatedTodo) {
        to_do todo = todoService.updateTodo(id, updatedTodo);
        return todo != null ? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }
}


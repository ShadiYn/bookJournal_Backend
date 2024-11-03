package com.bookjournal.proyecto.ToDoList.service;


import com.bookjournal.proyecto.ToDoList.entities.to_do;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class todoService {

    @Autowired
    private com.bookjournal.proyecto.ToDoList.repository.todoRepository todoRepository;

    public List<to_do> getAllTodos() {
        return todoRepository.findAll();
    }

    public to_do getTodoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public to_do createTodo(to_do todo) {
        return todoRepository.save(todo);
    }

    public to_do updateTodo(Long id, to_do updatedTodo) {
        Optional<to_do> existingTodo = todoRepository.findById(id);
        if (existingTodo.isPresent()) {
            to_do todo = existingTodo.get();
            todo.setTitle(updatedTodo.getTitle());
            todo.setDescription(updatedTodo.getDescription());
            todo.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(todo);
        }
        return null;
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}

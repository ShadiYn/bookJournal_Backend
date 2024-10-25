package com.bookjournal.proyecto.Controllers;

import com.bookjournal.proyecto.Services.BookService;
import com.bookjournal.proyecto.entities.Book;
import com.bookjournal.proyecto.entities.User;
import com.bookjournal.proyecto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    private final String uploadDir = "uploads/"; // Directorio donde se guardarán las imágenes

    @GetMapping("/user/{userId}")
    public List<Book> getBooksByUserId(@PathVariable Long userId) {
        return bookService.getBooksByUserId(userId);
    }


    @GetMapping("/")
    public List<Book> getAllUsers() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        try {
            Book savedBook = bookRepository.save(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        } catch (Exception e) {
            // Loguear el error y retornar un código de error adecuado
            System.out.println("Error al crear el libro: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}

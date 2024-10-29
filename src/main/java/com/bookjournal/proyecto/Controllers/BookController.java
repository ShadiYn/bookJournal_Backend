package com.bookjournal.proyecto.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import com.bookjournal.proyecto.entities.Book;
import com.bookjournal.proyecto.Services.BookService;
import com.bookjournal.proyecto.repositories.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    private final Path root = Paths.get("public");

    @PostConstruct
    public void init() {
        try {
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory!");
        }
    }

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
    public ResponseEntity<?> createBook(@RequestParam("bookData") String bookData,
                                        @RequestParam("file") MultipartFile file) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = objectMapper.readValue(bookData, Book.class);

        // Guardar la imagen
        try {
            String imagePath = saveImage(file);
            book.setImagePath(imagePath);

            // Guarda el libro en la base de datos
            bookRepository.save(book); // Guarda el libro después de establecer la imagen
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la imagen.");
        }

        return ResponseEntity.ok(book);
    }


    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(Objects.requireNonNull(file.getOriginalFilename())));
            return ResponseEntity.ok().body("{\"resp\":\"Archivo cargado con éxito\"}");

        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    private String saveImage(MultipartFile file) throws IOException {

        String imageName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = root.resolve(imageName); // Usar la ruta definida al inicio
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        return imageName;
    }



}

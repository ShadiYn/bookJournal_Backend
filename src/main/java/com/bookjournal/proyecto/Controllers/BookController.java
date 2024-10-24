package com.bookjournal.proyecto.Controllers;

import com.bookjournal.proyecto.Services.BookService;
import com.bookjournal.proyecto.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/user/{userId}")
    public List<Book> getBooksByUserId(@PathVariable Long userId){
        return bookService.getBooksByUserId(userId);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        System.out.println("Creating book: " + book);
        return bookService.createBook(book);
    }


    @GetMapping("/")
    public List<Book> getAllUsers() {
        return bookService.getAllBooks(); // Devuelve todos los usuarios
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }
}

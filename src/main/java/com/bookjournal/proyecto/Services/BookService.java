package com.bookjournal.proyecto.Services;

import com.bookjournal.proyecto.entities.Book;
import com.bookjournal.proyecto.entities.User;
import com.bookjournal.proyecto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooksByUserId(Long userId){
        return bookRepository.findByUserId(userId);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book); // Solo guarda una vez
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll(); // Devuelve todos los usuarios
    }
}

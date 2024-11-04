package com.bookjournal.proyecto.bookJournal.Controllers.Services;

import com.bookjournal.proyecto.bookJournal.Controllers.entities.Book;
import com.bookjournal.proyecto.bookJournal.Controllers.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // Método eliminado: getBooksByUserId

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll(); // Devuelve todos los libros
    }
}

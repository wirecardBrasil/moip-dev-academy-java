package br.com.moip.devacademy.library.controller;

import br.com.moip.devacademy.library.entity.Book;
import br.com.moip.devacademy.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leticia.alves on 04/04/18.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable(value = "id") Long bookId, @RequestBody Book bookDetails) {

        Book book = bookRepository.findById(bookId).get();

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());

        bookRepository.save(book);

        return book;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable(value = "id") Long userId) {
        Book book = bookRepository.findById(userId).get();
        bookRepository.delete(book);
    }
}

package com.example.reactive.controller.impl;

import com.example.reactive.controller.BookController;
import com.example.reactive.entity.Book;
import com.example.reactive.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookRepository bookRepository;

    @Override
    public Mono<Book> saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Mono<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

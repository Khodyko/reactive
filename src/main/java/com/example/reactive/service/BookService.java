package com.example.reactive.service;

import com.example.reactive.entity.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    Mono<Book> saveBook(Book book);


    Mono<Book> getBookById( Long id);

    Flux<Book> getAllBooks();
}

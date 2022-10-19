package com.example.reactive.controller;

import com.example.reactive.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/book")
public interface BookController {

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<Book> saveBook(@RequestBody Book book);

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    Mono<Book> getBookById(@PathVariable Long id);

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/all")
    Flux<Book> getAllBooks();
}

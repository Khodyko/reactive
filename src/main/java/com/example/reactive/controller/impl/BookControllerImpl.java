package com.example.reactive.controller.impl;

import com.example.reactive.controller.BookController;
import com.example.reactive.entity.Book;
import com.example.reactive.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

  private final BookService bookService;

    @Override
    public Mono<Book> saveBook(Book book) {
        return bookService.saveBook(book);
    }

    @Override
    public Mono<Book> getBookById(Long id) {
        return bookService.getBookById(id).map((a)->{
            Long b=0L;
            for (int i = 0; i < 600000; i++) {
                b++;
            }
            return a;
        });
    }

    @Override
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}

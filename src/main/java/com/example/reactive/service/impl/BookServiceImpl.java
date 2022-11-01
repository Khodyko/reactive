package com.example.reactive.service.impl;

import com.example.reactive.entity.Book;
import com.example.reactive.repository.BookRepository;
import com.example.reactive.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public Mono<Book> saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Mono<Book> getBookById(Long id) {
        return Mono.defer(()-> Mono.from(bookRepository.findAllBookWithDelayById(id)
                             .subscribeOn(Schedulers.boundedElastic())));
    }

    @Override
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

package com.example.reactive.repository;

import com.example.reactive.entity.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;


public interface BookRepository extends ReactiveCrudRepository<Book, Long> {

    @Query(value = "SELECT * FROM Book b, pg_sleep(0.2) where b.id=:id ")
    Mono<Book> findAllBookWithDelayById(Long id);
}

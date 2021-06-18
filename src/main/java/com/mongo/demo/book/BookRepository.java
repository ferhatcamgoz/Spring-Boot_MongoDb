package com.mongo.demo.book;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,Long> {

    List<Book> findByAuthorId(Long authorId);

}

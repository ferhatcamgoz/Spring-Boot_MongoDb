package com.mongo.demo.author;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, Long> {
	
	Author findByName(String name);

}

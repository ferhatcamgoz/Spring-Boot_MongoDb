package com.mongo.demo.book;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongo.demo.author.Author;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Document("books")
public class Book {
	@Id
	private long id;
	
	private String name;

	private long authorId;
	

	
	
}

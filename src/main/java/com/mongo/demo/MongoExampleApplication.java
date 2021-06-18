package com.mongo.demo;

import com.mongo.demo.author.Author;
import com.mongo.demo.author.AuthorRepository;
import com.mongo.demo.book.Book;
import com.mongo.demo.book.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableMongoRepositories
public class MongoExampleApplication {

	public static void main(String[] args) {

		SpringApplication.run(MongoExampleApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner createInitialUsers(AuthorRepository authorRepository, BookRepository bookRepository){
		return (args)->{
			int id=1;
			for(int i =1;i<=10;i++) {
				Author user = new Author();
				user.setName("user" + i);
				user.setId(i);
				user.setPassword(new BCryptPasswordEncoder().encode("1"));
				if(i%2==0){
					user.setRole("admin");
				}
				else user.setRole("user");
				authorRepository.save(user);
			}
				for(int j =1;j<=10;j++){


					for (int i = 1; i <= 3; i++) {
						Book book= new Book();
						book.setAuthorId(j);
						book.setId(id);
						id+=1;
						book.setName(j+". yazarın"+i+". kitabı");

						bookRepository.save(book);
					}




				}





		};
	}

}

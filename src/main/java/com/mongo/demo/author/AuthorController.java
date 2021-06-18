package com.mongo.demo.author;

import java.util.ArrayList;
import java.util.List;

import com.mongo.demo.book.Book;
import com.mongo.demo.book.BookRepository;
import com.mongo.demo.util.CurrnetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/a")
public class AuthorController {



	@Autowired
	AuthorService authorService;

	@Autowired
	AuthorSecurtiyService authorSecurtiyService;

	@GetMapping
	List<Author> getAll(){
		return authorService.getAllAuthor();

	}
	@GetMapping("/{id:[0-9]+}")
	Author getOne(@PathVariable Long id){
		return authorService.getOneAuthor(id);
	}
	@PostMapping
	Author save(@RequestBody Author author){

		return authorService.save(author);
	}
	@PutMapping()
	@PreAuthorize("#author.id == principal.id")
	Author authorUpdate(@RequestBody Author author){

	return authorService.authorUpdate(author);
	}

	@DeleteMapping("/{id:[0-9]+}")
	@PreAuthorize("@authorSecurtiyService.authorizationControl(#id,#author)")
	boolean delete(@PathVariable long id,@CurrnetUser Author author) {

		return authorService.delete(id);
	}

	@PostMapping("/login")
	Author login(@CurrnetUser Author author){
		return	author;
	}
}

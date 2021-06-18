package com.mongo.demo.book;

import com.mongo.demo.author.Author;
import com.mongo.demo.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/b")
public class BookController {
	
@Autowired
	AuthorRepository authorRepository;

    @Autowired
    BookService bookService;

    @GetMapping("/{author_id:[0-9]+}")
    List<Book> getByAuthor(@PathVariable Long author_id){
        return bookService.getByAuthor(author_id);

    }

	@PostMapping()
	Book create( @RequestBody Book book){
	    bookService.create(book);
	return book;
	}

	@PutMapping()
	Book update( @RequestBody Book book){
		return bookService.update(book);
	}
	@DeleteMapping("/{book_id:[0-9]+}")
	void delete(@PathVariable Long book_id) {
		bookService.delete(book_id);
	}
}

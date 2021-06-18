package com.mongo.demo.book;

import com.mongo.demo.author.AuthorRepository;
import com.mongo.demo.author.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {

    private  final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public BookService(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository=authorRepository;
        this.bookRepository = bookRepository;

    }


   public List<Book> getByAuthor( Long author_id){
        return bookRepository.findByAuthorId(author_id);

    }
    public Book create(  Book book){
        bookRepository.save(book);
        return book;
    }

    public Book update(  Book book){
        Book book1 = bookRepository.findById(book.getId()).get();
        book1.setName(book.getName());
        book1.setAuthorId(book.getAuthorId());
        bookRepository.save(book1);
        return book;
    }
    public void delete(@PathVariable Long book_id){
        bookRepository.deleteById(book_id);
    }
}

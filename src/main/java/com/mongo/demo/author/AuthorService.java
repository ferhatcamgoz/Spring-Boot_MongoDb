package com.mongo.demo.author;

import com.mongo.demo.book.Book;
import com.mongo.demo.book.BookRepository;
import com.mongo.demo.util.CurrnetUser;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private  final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository,BookRepository bookRepository){
        this.authorRepository=authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Author> getAllAuthor(){
        List<Author> authors=authorRepository.findAll();
        for(Author author:authors){
            List<Book> books =bookRepository.findByAuthorId(author.getId());
              author.setBooks(books);
        }
        return	authors;
    }
    public Author getOneAuthor( Long id){
        List<Book> books =bookRepository.findByAuthorId(id);
        Author author=authorRepository.findById(id).get();
        author.setBooks(books);
        return	author;
    }
    public Author save( Author author){
        return	authorRepository.save(author);
    }
    public Author authorUpdate( Author author){

        Author author1 = authorRepository.findById(author.getId()).get();
        author1.setName(author.getName());
        authorRepository.save(author1);

        return author;
    }
   public  boolean delete( long id) {
        authorRepository.deleteById(id);
        return true;
    }

}

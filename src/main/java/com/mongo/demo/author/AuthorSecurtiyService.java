package com.mongo.demo.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorSecurtiyService {

    @Autowired
    AuthorRepository authorRepository;

    public boolean authorizationControl(long id, Author author){
        Optional<Author> author1= authorRepository.findById(id);
        if(!author1.isPresent()){
            return false;
        }
        if(author.getRole().equalsIgnoreCase("admin")){
            return true;
        }
        if(author1.get().getId()!=author.getId()){
            System.out.println("geldii");
            return false;
        }


        return true;

    }
}

package com.mongo.demo.configration;

import com.mongo.demo.author.Author;
import com.mongo.demo.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Author author =authorRepository.findByName(s);
        if(author==null){
            throw new UsernameNotFoundException("User not found");
        }
        return author;
    }
}

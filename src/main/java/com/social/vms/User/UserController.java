package com.social.vms.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>("user is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}



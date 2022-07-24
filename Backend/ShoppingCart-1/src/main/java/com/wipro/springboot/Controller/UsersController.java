package com.wipro.springboot.Controller;



import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

import com.wipro.springboot.Entity.Users;
import com.wipro.springboot.Service.UsersService;


@RestController
public class UsersController {
 
    @Autowired
    private UsersService service;
     
    // RESTful API methods for Retrieval operations
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/users")
    public List<Users> list() {
        return service.listAll();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> get(@PathVariable Integer id) {
        try {
            Users user = service.get(id);
            return new ResponseEntity<Users>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }      
    }
    // RESTful API method for Create operation
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/users")
    public void add(@RequestBody Users users) {
        service.save(users);
    }
    @CrossOrigin("http://localhost:4200")
    @PutMapping("/users/{id}")
	public void update(@RequestBody Users users) {
		 service.update(users);
	}
    
    // RESTful API method for Delete operation
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    
   
}
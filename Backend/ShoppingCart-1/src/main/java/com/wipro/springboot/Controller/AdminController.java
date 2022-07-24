package com.wipro.springboot.Controller;



import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

import com.wipro.springboot.Entity.Admin;
import com.wipro.springboot.Service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
 
    @Autowired
    private AdminService service;
     
    // RESTful API methods for Retrieval operations
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admin")
    public List<Admin> list() {
        return service.listAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admin/{id}")
    public ResponseEntity<Admin> get(@PathVariable Integer id) {
        try {
        	Admin admin = service.get(id);
            return new ResponseEntity<Admin>(admin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }      
    }
    // RESTful API method for Create operation
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/admin")
    public void add(@RequestBody Admin admin) {
        service.save(admin);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/admin/{id}")
	public void update(@RequestBody Admin admin) {
		 service.update(admin);
	}
    
    // RESTful API method for Delete operation
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/admin/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    
   
}
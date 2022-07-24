package com.wipro.springboot.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

import com.wipro.springboot.Entity.Category;
import com.wipro.springboot.Service.CategoryService;

 
@RestController
public class CategoryController {
 
    @Autowired
    private CategoryService service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/category")
    public List<Category> list() {
        return service.listAll();
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> get(@PathVariable Integer id) {
        try {
        	Category category = service.get(id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }      
    }
    // RESTful API method for Create operation
    @PostMapping("/category")
    public void add(@RequestBody Category category) {
        service.save(category);
    }
     
    @PutMapping("/category/{id}")
	public void update(@RequestBody Category category) {
		 service.update(category);
	}
    
    // RESTful API method for Delete operation
    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    
   
}
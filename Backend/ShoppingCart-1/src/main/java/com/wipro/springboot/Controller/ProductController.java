package com.wipro.springboot.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

import com.wipro.springboot.Entity.Product;
import com.wipro.springboot.Service.ProductService;


@RestController
public class ProductController {
 
    @Autowired
    private ProductService service;
     
    // RESTful API methods for Retrieval operations
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/products")
    public List<Product> list() {
        return service.listAll();
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
        	Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }      
    }
    // RESTful API method for Create operation
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/products")
    public void add(@RequestBody Product product) {
        service.save(product);
    }
    @CrossOrigin("http://localhost:4200")
    @PutMapping("/products/{id}")
	public void update(@RequestBody Product product) {
		 service.update(product);
	}
    
    // RESTful API method for Delete operation
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    
   
}
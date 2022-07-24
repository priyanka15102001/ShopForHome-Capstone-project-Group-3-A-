package com.wipro.springboot.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

import com.wipro.springboot.Entity.Wishlist;
import com.wipro.springboot.Service.WishListService;

@CrossOrigin("http://localhost:4200")
@RestController
public class WishlistController {
 
    @Autowired
    private WishListService service;
     
    // RESTful API methods for Retrieval operations
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/wishlist")
    public List<Wishlist> list() {
        return service.listAll();
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/wishlist/{id}")
    public ResponseEntity<Wishlist> get(@PathVariable Integer id) {
        try {
        	Wishlist wishlist = service.get(id);
            return new ResponseEntity<Wishlist>(wishlist, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Wishlist>(HttpStatus.NOT_FOUND);
        }      
    }
    // RESTful API method for Create operation
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/wishlist")
    public void add(@RequestBody Wishlist wishlist) {
        service.save(wishlist);
    }
    
    @CrossOrigin("http://localhost:4200")
     
    @PutMapping("/wishlist/{id}")
	public void update(@RequestBody Wishlist wishlist) {
		 service.update(wishlist);
	}
    
    // RESTful API method for Delete operation
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/wishlist/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    
   
}
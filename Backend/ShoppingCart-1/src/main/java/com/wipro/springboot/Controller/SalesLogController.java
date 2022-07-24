package com.wipro.springboot.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

import com.wipro.springboot.Entity.SalesLog;
import com.wipro.springboot.Service.SalesLogService;

//@CrossOrigin("http://localhost:4200")
@RestController
public class SalesLogController {
 
    @Autowired
    private SalesLogService service;
     
    // RESTful API methods for Retrieval operations
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/sales-log")
    public List<SalesLog> list() {
        return service.listAll();
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/sales-log/{id}")
    public ResponseEntity<SalesLog> get(@PathVariable Integer id) {
        try {
        	SalesLog saleslog = service.get(id);
            return new ResponseEntity<SalesLog>(saleslog, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<SalesLog>(HttpStatus.NOT_FOUND);
        }      
    }
    // RESTful API method for Create operation
//    @CrossOrigin("http://localhost:4200")
    @PostMapping("/sales-log")
    public void add(@RequestBody SalesLog saleslog) {
        service.save(saleslog);
    }
     
  
    
    // RESTful API method for Delete operation
//    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/sales-log/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
 } 
   

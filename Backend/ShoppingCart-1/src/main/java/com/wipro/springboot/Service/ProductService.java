package com.wipro.springboot.Service;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springboot.Entity.Product;
import com.wipro.springboot.Repository.ProductRepository;
 
@Service
@Transactional
public class ProductService {
 
    @Autowired
    private ProductRepository repo1;
     
    public List<Product> listAll() {
        return repo1.findAll();
    }
     
    public void save(Product product) {
        repo1.save(product);
    }
     
    public Product get(Integer id) {
        return repo1.findById(id).get();
    }
    
    public void update(Product product) {
       repo1.save(product);
    }
     
    public void delete(Integer id) {
        repo1.deleteById(id);
    }
    
}
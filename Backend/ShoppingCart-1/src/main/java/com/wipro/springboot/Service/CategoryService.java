package com.wipro.springboot.Service;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springboot.Entity.Category;
import com.wipro.springboot.Repository.CategoryRepository;
 
@Service
@Transactional
public class CategoryService {
 
    @Autowired
    private CategoryRepository repo1;
     
    public List<Category> listAll() {
        return repo1.findAll();
    }
     
    public void save(Category category) {
        repo1.save(category);
    }
     
    public Category get(Integer id) {
        return repo1.findById(id).get();
    }
    
    public void update(Category category) {
       repo1.save(category);
    }
     
    public void delete(Integer id) {
        repo1.deleteById(id);
    }
    
}
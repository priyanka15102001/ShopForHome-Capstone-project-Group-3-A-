package com.wipro.springboot.Service;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springboot.Entity.Admin;
import com.wipro.springboot.Repository.AdminRepository;
 
@Service
@Transactional
public class AdminService {
 
    @Autowired
    private AdminRepository repo1;
     
    public List<Admin> listAll() {
        return repo1.findAll();
    }
     
    public void save(Admin admin) {
        repo1.save(admin);
    }
     
    public Admin get(Integer id) {
        return repo1.findById(id).get();
    }
    
    public void update(Admin admin) {
       repo1.save(admin);
    }
     
    public void delete(Integer id) {
        repo1.deleteById(id);
    }
    
}
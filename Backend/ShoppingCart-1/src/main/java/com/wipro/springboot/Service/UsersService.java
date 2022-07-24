package com.wipro.springboot.Service;


import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springboot.Entity.Users;
import com.wipro.springboot.Repository.UsersRepository;
 
@Service
@Transactional
public class UsersService {
 
    @Autowired
    private UsersRepository repo6;
     
    public List<Users> listAll() {
        return repo6.findAll();
    }
     
    public void save(Users user) {
        repo6.save(user);
    }
     
    public Users get(Integer id) {
        return repo6.findById(id).get();
    }
    
    public void update(Users user) {
       repo6.save(user);
    }
     
    public void delete(Integer id) {
        repo6.deleteById(id);
    }
    
}
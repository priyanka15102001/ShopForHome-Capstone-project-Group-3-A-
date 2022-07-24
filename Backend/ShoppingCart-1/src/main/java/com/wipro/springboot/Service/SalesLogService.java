package com.wipro.springboot.Service;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springboot.Entity.SalesLog;
import com.wipro.springboot.Repository.SalesLogRepository;
 
@Service
@Transactional
public class SalesLogService {

    @Autowired
    private SalesLogRepository repo1;
     
    public List<SalesLog> listAll() {
        return repo1.findAll();
    }
     
    public void save(SalesLog saleslog) {
        repo1.save(saleslog);
    }
     
    public SalesLog get(Integer id) {
        return repo1.findById(id).get();
    }
    
    public void update(SalesLog saleslog) {
       repo1.save(saleslog);
    }
     
    public void delete(Integer id) {
        repo1.deleteById(id);
    }
    
}
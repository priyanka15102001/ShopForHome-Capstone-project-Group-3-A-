package com.wipro.springboot.Service;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springboot.Entity.Wishlist;
import com.wipro.springboot.Repository.WishlistRepository;
 
@Service
@Transactional
public class WishListService {
 
    @Autowired
    private WishlistRepository repo1;
     
    public List<Wishlist> listAll() {
        return repo1.findAll();
    }
     
    public void save(Wishlist wishlist) {
        repo1.save(wishlist);
    }
     
    public Wishlist get(Integer id) {
        return repo1.findById(id).get();
    }
    
    public void update(Wishlist wishlist) {
       repo1.save(wishlist);
    }
     
    public void delete(Integer id) {
        repo1.deleteById(id);
    }
    
}
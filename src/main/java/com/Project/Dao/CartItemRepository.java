package com.Project.Dao;

import com.Project.Entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")   // Cross Origin allows back end and front end to communicate.
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}

package com.raw1.app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raw1.app.model.Cart;
@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

}

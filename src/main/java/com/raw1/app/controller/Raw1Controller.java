package com.raw1.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raw1.app.DTO.CartItemDTO;
import com.raw1.app.Repo.CartItemRepo;
import com.raw1.app.Repo.CartRepo;
import com.raw1.app.Repo.ProductRepo;
import com.raw1.app.Repo.SubscriptionRepo;
import com.raw1.app.Repo.UserRepo;
import com.raw1.app.model.Cart;
import com.raw1.app.model.CartItem;
import com.raw1.app.model.Product;
import com.raw1.app.model.Subscription;
import com.raw1.app.model.UserR;
import com.raw1.app.service.impl;

@RestController
public class Raw1Controller {

//	@Autowired
//	ProductRepo productRepo;
//	@Autowired
//	UserRepo userRepo;
//	@Autowired
//	CartRepo cartRepo;
//	@Autowired
//	SubscriptionRepo subRepo;
//	@Autowired
//	CartItemRepo cartItemRepo;
	
	@Autowired
	impl rawService;

	@GetMapping("/addUser")
	public UserR addUser(@RequestBody UserR user) {
		
		return rawService.createUser(user);
		
//		UserR user1=new UserR();
//		//user1.setAddress("1XXXX");
//		user1.setFirstName("Alex");
//		user1.setLastName("xxxx");
//		user1.setPhone("9999999");
//		user1=userRepo.save(user1);
//		
//		Subscription userSUb=new Subscription();
//		userSUb.setUserr(user1);
//		userSUb.setStartDate(LocalDate.of(24, 05, 01));
//		userSUb.setEndDate(LocalDate.of(24, 05, 01));
//		userSUb.setSubscriptionStatus("Active");
//		userSUb=subRepo.save(userSUb);
//		
//		Cart userCart=new Cart();
//		userCart.setSubscription(userSUb);
//		userCart=cartRepo.save(userCart);
//		
//		userSUb.setCart(userCart);
//		userSUb=subRepo.save(userSUb);
//		
//		Optional<Product> prod=productRepo.findById((long) 1);
//		
//		CartItem item = new CartItem();
//		item.setProduct(prod.get());
//		item.setCart(userCart);
//		item.setFrequency("daily");
//		item.setQuantity(500);
//		cartItemRepo.save(item);
//		userCart.getCartItems().add(item);
//		userCart=cartRepo.save(userCart);
		
	}

	@GetMapping("/addProductToCart/{userID}")
	public boolean addProductToCart(@PathVariable long userID,@RequestBody CartItemDTO cartItem) {
		
		return rawService.addItemToCart(userID, cartItem);
//		System.out.println(userRepo.findById((long)10).get());
//		System.out.println(userRepo.findById((long)10).get().getSubscription());
//		System.out.println(userRepo.findById((long)10).get().getSubscription().getCart());
//		System.out.println(userRepo.findById((long)10).get().getSubscription().getCart().getCartItems());
	}
	
}

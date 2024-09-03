package com.raw1.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class impl implements rawService{
	@Autowired
	ProductRepo productRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	CartRepo cartRepo;
	@Autowired
	SubscriptionRepo subRepo;
	@Autowired
	CartItemRepo cartItemRepo;
	@Override
	public UserR createUser(UserR user) {

//		UserR user1=new UserR();
//		//user1.setAddress("1XXXX");
//		user1.setFirstName("Alex");
//		user1.setLastName("xxxx");
//		user1.setPhone("9999999");
		user=userRepo.save(user);
		
		Subscription userSUb=new Subscription();
		userSUb.setUserr(user);
//		userSUb.setStartDate(LocalDate.of(24, 05, 01));
//		userSUb.setEndDate(LocalDate.of(24, 05, 01));
		userSUb.setSubscriptionStatus("InActive");
		userSUb=subRepo.save(userSUb);
		
		Cart userCart=new Cart();
		userCart.setSubscription(userSUb);
		userCart=cartRepo.save(userCart);
		
		userSUb.setCart(userCart);
		userSUb=subRepo.save(userSUb);
		
		return user;
	}

	@Override
	public boolean addItemToCart(long userId,CartItemDTO cartItemDTO) {
		// TODO Auto-generated method stub
		System.out.println(userId + "" + cartItemDTO);
		Optional<UserR> user= userRepo.findById(userId);
		if(user.isPresent()) {
			Optional<Product> product=productRepo.findById(cartItemDTO.getProductId());
			if(product.isPresent()) {
				Cart cart=user.get().getSubscription().getCart();
				
				CartItem item = new CartItem();
				item.setProduct(product.get());
				item.setStatus("enable");
				item.setCart(cart);
				item.setFrequency(cartItemDTO.getFrequency());
				item.setQuantity(cartItemDTO.getQuantity());
				
				cartItemRepo.save(item);
				
				cart.getCartItems().add(item);
				cart=cartRepo.save(cart);
			}
		}
		
		return true;
	}

	@Override
	public List<CartItem> getTommorow() {
		// TODO Auto-generated method stub
		
		return null;
	}

}

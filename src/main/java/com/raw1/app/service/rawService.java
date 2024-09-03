package com.raw1.app.service;

import java.util.List;

import com.raw1.app.DTO.CartItemDTO;
import com.raw1.app.model.CartItem;
import com.raw1.app.model.UserR;

public interface rawService {
	public UserR createUser(UserR user);
	public boolean addItemToCart(long userId ,CartItemDTO cartItemDTO );
	public List<CartItem> getTommorow();
	
}

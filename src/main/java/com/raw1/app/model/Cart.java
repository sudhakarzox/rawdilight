package com.raw1.app.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@Entity
public class Cart {
	
	public Cart() {
		cartItems=new ArrayList<CartItem>();
	}
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

//	    @OneToOne
//	    @JoinColumn(name = "userr_id")
//	    private UserR userr;

	    @OneToMany(mappedBy = "cart")
	    private List<CartItem> cartItems;

	    //@OneToOne(mappedBy = "cart")
	    //@JoinColumn(name = "subscription_id")
	    //private Subscription subscription;
	    
	    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
	    private Subscription subscription;

		@Override
		public String toString() {
			return "Cart [id=" + id + "]";
		}
	    
	    
}

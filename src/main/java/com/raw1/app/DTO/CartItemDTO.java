package com.raw1.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
	 
	 private long productId;
	 private int quantity;
	 private String frequency;
	 private String status;
	 
}

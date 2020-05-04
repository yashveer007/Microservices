package com.cg.ecommerce.stockmgmt.services;

import com.cg.ecommerce.stockmgmt.entities.Cart;

import java.util.List;

public interface ICartService {

		Cart add(Cart item);

	    List<Cart>fetchCartItems(int userId);
}

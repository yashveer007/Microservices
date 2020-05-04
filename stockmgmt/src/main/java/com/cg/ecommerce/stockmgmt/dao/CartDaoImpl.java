package com.cg.ecommerce.stockmgmt.dao;

import com.cg.ecommerce.stockmgmt.entities.*;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CartDaoImpl implements ICartDao{
    private Map<Integer,Cart>store=new HashMap<>();

  
    @Override
    public Cart add(Cart item) {
        int id = getGenerateId();
    	item.setId(id);
    	store.put(item.getId(),item);
        return item;
    }

    
	@Override
	public List<Cart> fetchCartItems(int userId) {
		Collection<Cart> collections = store.values();
		List<Cart> list = new ArrayList<>();
		for (Cart cart : collections) {
			if(cart.getUserId()==userId) {
				list.add(cart);
			}		
		}
		return list;
	}
	
	private int generateId;
	
	private int getGenerateId()
	{
		return ++generateId;
	}


}

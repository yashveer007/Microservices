package com.cg.ecommerce.stockmgmt.services;

import com.cg.ecommerce.stockmgmt.dao.*;
import com.cg.ecommerce.stockmgmt.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICartServiceImpl implements ICartService {
    private ICartDao productDao;

    public ICartDao getProductDao() {
        return productDao;
    }

    @Autowired
    public void setProductDao(ICartDao dao) {
        this.productDao = dao;
    }

	@Override
	public Cart add(Cart item) {
		Cart cart = productDao.add(item);
		return cart;
	}

	@Override
	public List<Cart> fetchCartItems(int userId) {
		List<Cart> list = productDao.fetchCartItems(userId);
		return list;
	}
}

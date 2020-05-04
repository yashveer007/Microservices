package com.cg.ecommerce.prodmgmt.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.ecommerce.prodmgmt.entities.*;
import org.springframework.stereotype.Repository;

@Repository
public class IProductDAOImpl implements IProductDao{

	private Map<String,Product> store = new HashMap<>();
	
	@Override
	public Product add(Product product) {
		store.put(product.getProductId(),product);
		return product;
	}

	@Override
	public List<Product> fetchAll() {
		Collection collection = store.values();
		List<Product> list = new ArrayList<>(collection);
		return list;
	}

	@Override
	public Product findById(String id) {
		Product product = store.get(id);
		return product;
	}

}

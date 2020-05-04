package com.cg.ecommerce.prodmgmt.services;

import com.cg.ecommerce.prodmgmt.dao.*;



import com.cg.ecommerce.prodmgmt.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements IProductService {
    
	private IProductDao productDao;

    public IProductDao getProductDao() {
        return productDao;
    }

    @Autowired
    public void setProductDao(IProductDao dao) {
        this.productDao = dao;
    }

    
    @Override
    public Product add(Product product) {
        productDao.add(product);
        return product;
    }

    @Override
    public List<Product> fetchAll() {
        List<Product> products = productDao.fetchAll();
        return products;
    }

    @Override
    public Product findById(String id) {
    	Product product  = productDao.findById(id);
    	return product;
    }

}

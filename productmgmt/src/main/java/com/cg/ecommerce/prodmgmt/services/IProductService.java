package com.cg.ecommerce.prodmgmt.services;

import com.cg.ecommerce.prodmgmt.entities.*;


import java.util.List;

public interface IProductService {
    
	Product add(Product product);

    List<Product> fetchAll();

    Product findById(String id);
}

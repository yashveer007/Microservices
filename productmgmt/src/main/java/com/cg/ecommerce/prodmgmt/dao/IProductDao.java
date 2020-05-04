package com.cg.ecommerce.prodmgmt.dao;

import java.util.List;


import com.cg.ecommerce.prodmgmt.entities.Product;



public interface IProductDao {

	Product add(Product product);

    List<Product> fetchAll();

    Product findById(String id);


}

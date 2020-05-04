package com.cg.ecommerce.stockmgmt.dao;

import com.cg.ecommerce.stockmgmt.entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ICartDao {

    Cart add(Cart item);

    List<Cart> fetchCartItems(int userId);

}

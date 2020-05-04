package com.cg.ecommerce.stockmgmt.controller;

import com.cg.ecommerce.stockmgmt.dao.*;
import com.cg.ecommerce.stockmgmt.dto.CartDTO;
import com.cg.ecommerce.stockmgmt.dto.CartItemDetailsDTO;
import com.cg.ecommerce.stockmgmt.dto.ProductDTO;
//import org.cap.dto.CartItemDetailsDTO;
//import org.cap.dto.ProductDTO;
import com.cg.ecommerce.stockmgmt.entities.*;
import com.cg.ecommerce.stockmgmt.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import  java.util.*;

@RestController
@RequestMapping("/cartitems")
public class CartRestController {

	private static Logger log = LoggerFactory.getLogger(CartRestController.class);
	
    @Autowired
    private ICartService service;
    
    @Value("${productservice.baseurl}")
    private String productServiceBaseUrl;

    public String getProductServiceBaseUrl() {
		return productServiceBaseUrl;
	}

	public void setProductServiceBaseUrl(String productServiceBaseUrl) {
		this.productServiceBaseUrl = productServiceBaseUrl;
	}

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
    public ResponseEntity<Boolean> addCartItem(@RequestBody CartDTO dto){
      Cart cart = new Cart();
      cart.setProductId(dto.getProductId());
      cart.setUserId(dto.getUserId());
      cart = service.add(cart);
      ResponseEntity<Boolean>response=new ResponseEntity<>(true, HttpStatus.OK);
      log.info("Cart item added successfully, cart item " + cart.getId()+", " + cart.getProductId() +", "+ cart.getUserId());
      return response;
    }

    @GetMapping("/cartdetails/{userid}")
    public ResponseEntity<List<CartItemDetailsDTO>> cartDetails(@PathVariable("userid") int userId){
       List<Cart> cartItem = service.fetchCartItems(userId);
       List<CartItemDetailsDTO> desiredDtos = new ArrayList<>();
       for (Cart cart : cartItem) {
		ProductDTO productdto = fetchProductById(cart.getProductId());
		CartItemDetailsDTO cartdto = cartItemDetails(cart,productdto);
		desiredDtos.add(cartdto);
       }
       ResponseEntity<List<CartItemDetailsDTO>> response=new ResponseEntity<>(desiredDtos,HttpStatus.OK);
       return response;
    }


    public ProductDTO fetchProductById(String id)
    {
    	String url = productServiceBaseUrl + "/get/" + id;
    	ProductDTO dto = restTemplate.getForObject(url, ProductDTO.class);
    	return dto;
    }
  
    public CartItemDetailsDTO cartItemDetails(Cart item,ProductDTO productDto)
    {
    	CartItemDetailsDTO cartItemDetailsDto = new	CartItemDetailsDTO();
    	cartItemDetailsDto.setProductPrice(productDto.getProductPrice());
    	cartItemDetailsDto.setProductId(item.getProductId());
    	cartItemDetailsDto.setProductName(productDto.getProductName());
    	return cartItemDetailsDto;
    }

}

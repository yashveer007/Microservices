package com.cg.ecommerce.stockmgmt.dto;

public class CartDTO {
	
	private String productId;
	
	private int userId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}

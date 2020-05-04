package com.cg.ecommerce.stockmgmt.dto;

public class ProductDTO {
	
	private String productId;

    public String getProductId(){
        return productId;
    }

    public void setProductId(String id){
        this.productId=id;
    }

    private String productName;

    public String getProductName(){
        return productName;
    }

    public void setProductName(String name){
        this.productName=name;
    }
	
	private double productPrice;
	
	public double getProductPrice(){
		return productPrice;
	}
	
	public void setProductPrice(double productPrice){
		this.productPrice = productPrice;
	}

	private int availableItemsCount;

	public int getAvailableItemsCount() {
		return availableItemsCount;
	}

	public void setAvailableItemsCount(int availableItemsCount) {
		this.availableItemsCount = availableItemsCount;
	}


}

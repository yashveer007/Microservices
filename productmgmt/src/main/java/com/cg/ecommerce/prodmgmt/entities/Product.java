package com.cg.ecommerce.prodmgmt.entities;

import java.util.Objects;

public class Product {
	
	
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

	@Override
	public int hashCode() {
		//final int prime = 31;
		//int result = 1;
		//result = prime * result + ((productId == null) ? 0 : productId.hashCode());
	//	return result;
		
		return Objects.hash(productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	private int availableItemsCount;

	public int getAvailableItemsCount() {
		return availableItemsCount;
	}

	public void setAvailableItemsCount(int availableItemsCount) {
		this.availableItemsCount = availableItemsCount;
	}

}

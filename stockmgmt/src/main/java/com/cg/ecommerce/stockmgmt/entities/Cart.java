package com.cg.ecommerce.stockmgmt.entities;


public class Cart {

	
	private int id;
	
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String productId;

    public String getProductId(){
        return productId;
    }

    public void setProductId(String id){
        this.productId=id;
    }

    private int userId;

    public int getUserId(){
        return userId;
    }

    public void setUserId(int id){
        this.userId=id;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

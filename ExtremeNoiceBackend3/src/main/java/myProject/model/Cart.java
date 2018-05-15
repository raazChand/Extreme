package myProject.model;

public class Cart 
{
	private int cartId;
	private int productId;
	private int quantity;
	private int price;
	private int UserName;
	
	public int getCartId() 
	{
		return cartId;
	}
	public void setCartId(int cartId) 
	{
		this.cartId = cartId;
	}
	public int getProductId() 
	{
		return productId;
	}
	public void setProductId(int productId) 
	{
		this.productId = productId;
	}
	public int getQuantity() 
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	public int getUserName() 
	{
		return UserName;
	}
	public void setUserName(int userName) 
	{
		UserName = userName;
	}
	

}

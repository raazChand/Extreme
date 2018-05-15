package myProject.dao;

import myProject.model.Cart;



public interface CartDAO 
{
	public boolean addCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public boolean updateCart(Cart cart);
	public Cart getCart(int cartId);

}

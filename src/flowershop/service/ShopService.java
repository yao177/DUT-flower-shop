package flowershop.service;

import flowershop.entity.*;
import flowershop.entity.Shop;

public interface ShopService {
	// find out how many orders
	public int shopNum();
	
	// whether the basket is empty
	public boolean isEmpty(Shop shop);
	
	// show all the flowers in the shop
	public void printFlower();
	
	// show everything in the basket
	public boolean printBasket(Shop shop);
	
	// judge whether one kind of flower has been taken in
	public boolean isAdded(Shop shop, int fId);
	
	// add another kind of flower
	public boolean addFlower(Shop shop, int fId, int fNum);
	
	// change the number of one kind of flower
	public boolean changeNum(Shop shop, int fId, int fNum);
	
	//delete one kind of flower
	public boolean deleteFlower(Shop shop, int fId);
	
	// count the total money
	public double totalMoney(Shop shop);
	
	// count the final money after bonus
	public double discountMoney(Shop shop);
	
	// pay for the basket
	public void payMoney(Shop shop);
}

package flowershop.service;

import flowershop.entity.*;
import flowershop.service.*;
import flowershop.dao.*;
import flowershop.dao.impl.*;

public interface CustomerService {
	// watch all kinds of flowers
	public void watchFlowers();
	
	// put one kind of flower in the basket
	public boolean addFlowers(Shop shop, int fId, int fNum);
	
	// recharge the ID card
	public void rechargeCard(Customer customer, double chargeMoney);
	
	// pay for the basket
	public boolean payPayment(Shop shop, Customer customer);
	
	// look for what are bought in the past
	public void pastPayment(Customer customer);
}

package flowershop.service;

import flowershop.entity.Customer;
import flowershop.entity.Manager;

public interface LoginService {
	public Customer customerLogin();
	public Manager managerLogin();
	
}

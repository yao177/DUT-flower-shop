package flowershop.dao;

import flowershop.entity.Customer;
import java.util.*;

public interface CustomerDao {
	public void add(Customer customer);
	public void delete(Customer customer);
	public void update(Customer customer);
	public Customer findById(int id);
	public List<Customer> findByName(String name);
	public List<Customer> findByVipLevel(int level);
	public List<Customer> findAll();
}
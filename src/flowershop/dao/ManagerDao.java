package flowershop.dao;

import java.util.List;

import flowershop.entity.Manager;

public interface ManagerDao {
	public void add(Manager manager);
	public void delete(Manager manager);
	public void update(Manager manager);
	public Manager findById(int id);
	public List<Manager> findAll();
}

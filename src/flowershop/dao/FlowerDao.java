package flowershop.dao;
import java.util.List;

import flowershop.entity.Flower;

//import Flower 
public interface FlowerDao {
	public void add(Flower flower);
	public void delete(Flower flower);
	public void update(Flower flower);
	public Flower findById(int id);
	public Flower findByName(String name);
	public List<Flower> findByType(String type);
	public List<Flower> findByPrice(double price);
	public List<Flower> findAll();
}

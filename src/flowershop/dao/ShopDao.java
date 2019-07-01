package flowershop.dao;
import java.util.List;

import flowershop.entity.Shop;

public interface ShopDao {
	public void add(Shop shop);
	//public void delete(Shop shop);
	public void update(Shop shop);
	public Shop findById(int id);
	public List<Shop> findByUseId(int id);
	public int findAllNum();
}

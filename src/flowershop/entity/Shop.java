package flowershop.entity;

import java.util.*;

public class Shop {
	int sId;
	Map<Integer,Integer> sBasket = new HashMap<Integer,Integer>();
	int sUserId;
	boolean sIsShopped;
	double sMoney;
	public Shop() {}
	public Shop(int sId, Map<Integer, Integer> sBasket, int sUerId, boolean sIsShopped, double sMoney) {
		this.sId = sId;
		this.sBasket = sBasket;
		this.sUserId = sUserId;
		this.sIsShopped = sIsShopped;
		this.sMoney = sMoney;
	}

	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public Map<Integer,Integer> getsBasket() {
		return sBasket;
	}
	public void setsBasket(Map<Integer,Integer> sBasket) {
		this.sBasket = sBasket;
	}
	public int getsUserId() {
		return sUserId;
	}
	public void setsUserId(int sUserId) {
		this.sUserId = sUserId;
	}
	public boolean issIsShopped() {
		return sIsShopped;
	}
	public void setsIsShopped(boolean sIsShopped) {
		this.sIsShopped = sIsShopped;
	}
	public double getsMoney() {
		return sMoney;
	}
	public void setsMoney(double sMoney) {
		this.sMoney = sMoney;
	}
	
	
}
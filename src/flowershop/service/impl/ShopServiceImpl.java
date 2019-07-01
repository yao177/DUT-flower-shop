package flowershop.service.impl;

import java.util.*;

import flowershop.entity.*;
import flowershop.service.*;
import flowershop.dao.*;
import flowershop.dao.impl.*;


public class ShopServiceImpl implements ShopService {
	// find out how many orders
	public int shopNum() {
		ShopDaoImpl tmpsDao = new ShopDaoImpl();
		return tmpsDao.findAllNum();
	}
	
	// whether the basket is empty
	public boolean isEmpty(Shop shop) {
		if (shop.getsBasket().size() == 0) {
			return true;
		}
		return false;
	}
	
	// show all the flowers in the shop
	public void printFlower() {
		FlowerDaoImpl tmpDao = new FlowerDaoImpl();
		List<Flower> tmpList = tmpDao.findAll();
		System.out.println("序号" + "\t" + "花名" + "\t" + "种类" + "\t" + "价格" + "\t" + "数量");
		for (int i = 0; i < tmpList.size(); i++) {
			Flower tmpFlower = tmpList.get(i);
			System.out.println(tmpFlower.getfId() + "\t" + tmpFlower.getfName() + "\t" + tmpFlower.getfType() + "\t" + tmpFlower.getfPrice() + "\t" + tmpFlower.getfNum());
		}
	}
	
	// show everything in the basket
	public boolean printBasket(Shop shop) {
		if (isEmpty(shop)) {
			System.out.println("当前购物车为空！");
			return false;
		}
		FlowerDaoImpl tmpfDao = new FlowerDaoImpl();
		System.out.println("花名" + "\t" + "数量");
		Map<Integer, Integer> tmpMap = shop.getsBasket();
		for (Integer key : tmpMap.keySet()) {
			Flower tmpFlower = tmpfDao.findById(key.intValue());
			System.out.println(tmpFlower.getfName() + "\t" + tmpMap.get(key));
		}
		return true;
	}
	
	// judge whether one kind of flower has been taken in
	public boolean isAdded(Shop shop, int fId) {
		return shop.getsBasket().containsKey(fId);
	}
	
	// add another kind of flower
	public boolean addFlower(Shop shop, int fId, int fNum) {
		FlowerDaoImpl tmpfDao = new FlowerDaoImpl();
		Flower tmpFlower = tmpfDao.findById(fId);
		int tmpNum = tmpFlower.getfNum();
		if (tmpNum >= fNum) {
			tmpFlower.setfNum(tmpFlower.getfNum() - fNum);
			tmpfDao.update(tmpFlower);
			if (isAdded(shop, fId) == true) {
				System.out.println("");
				Map<Integer, Integer> tmpMap = shop.getsBasket();
				tmpMap.put(fId, tmpMap.get(fId) + fNum);
				shop.setsBasket(tmpMap);
			} else {
				Map<Integer, Integer> tmpMap = shop.getsBasket();
				tmpMap.put(fId, fNum);
				shop.setsBasket(tmpMap);
			}
			return true;
		} else {
			System.out.println("");
			return false;
		}
	}
	
	// change the number of one kind of flower
	public boolean changeNum(Shop shop, int fId, int fNum) {
		FlowerDaoImpl tmpfDao = new FlowerDaoImpl();
		Flower tmpFlower = tmpfDao.findById(fId);
		int tmpNum = tmpFlower.getfNum();
		Map<Integer, Integer> tmpMap = shop.getsBasket();
		if (isAdded(shop, fId) == false) {
			System.out.print("");
			tmpMap.put(fId, fNum);
			shop.setsBasket(tmpMap);
			return true;
		} else if (tmpNum + tmpMap.get(fId) >= fNum) {
			tmpMap.remove(fId);
			tmpMap.put(fId, fNum);
			shop.setsBasket(tmpMap);
			return true;
		} else {
			System.out.println("");
			return false;
		}
	}
	
	//delete one kind of flower
	public boolean deleteFlower(Shop shop, int fId) {
		FlowerDaoImpl tmpfDao = new FlowerDaoImpl();
		Flower tmpFlower = tmpfDao.findById(fId);
		Map<Integer, Integer> tmpMap = shop.getsBasket();
		if (isAdded(shop, fId) == false) {
			System.out.println("");
			return false;
		} else {
			tmpMap.remove(fId);
			shop.setsBasket(tmpMap);
			return true;
		}
	}
	
	// count the total money
	public double totalMoney(Shop shop) {
		Map<Integer, Integer> tmpMap = shop.getsBasket();
		FlowerDaoImpl tmpfDao = new FlowerDaoImpl();
		double total = 0.0;
		for (Integer key : tmpMap.keySet()) {
			Flower tmpFlower = tmpfDao.findById(key.intValue());
			total += tmpFlower.getfPrice() * tmpMap.get(key);
		}
		return total;
	}
	
	// count the final money after bonus
	public double discountMoney(Shop shop) {
		CustomerDaoImpl tmpDao = new CustomerDaoImpl();
		double afterDiscount = totalMoney(shop);
		Customer tmpCustomer = tmpDao.findById(shop.getsUserId());
		afterDiscount *= tmpCustomer.getVipBonus();
		shop.setsMoney(afterDiscount);
		return afterDiscount;
	}
	
	// pay for the basket
	public void payMoney(Shop shop) {
		shop.setsIsShopped(true);
		ShopDaoImpl tmpsDao = new ShopDaoImpl();
		// tmpsDao.add(shop);
		
		Calendar preCalendar = Calendar.getInstance();
		Calendar presentCalendar  = Calendar.getInstance();
		Map<Integer, Integer> tmpMap = shop.getsBasket();
		FlowerDaoImpl tmpfDao = new FlowerDaoImpl();
		for (Integer key : tmpMap.keySet()) {
			Flower tmpFlower = tmpfDao.findById(key.intValue());
			
			tmpFlower.setfNum(tmpFlower.getfNum() - tmpMap.get(key));
			
			// int tmpDate = Integer.parseInt(tmpFlower.getfUpTime());
			// int tmpYear = tmpDate / 10000;
			// int tmpMonth = tmpDate % 10000 / 100;
			// int tmpDay = tmpDate % 100;
			String tmpString = tmpFlower.getfUpTime();
			String[] tmpDate = tmpString.split("\\-");
			int tmpYear = Integer.parseInt(tmpDate[0]);
			int tmpMonth = Integer.parseInt(tmpDate[1]);
			int tmpDay = Integer.parseInt(tmpDate[2]);
			preCalendar.set(tmpYear, tmpMonth, tmpDay);
			int intervals = (int)((presentCalendar.getTime().getTime() - preCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
			double tmpSell = (double)(tmpFlower.getfUpNum() - tmpFlower.getfNum()) / intervals;
			tmpFlower.setfSell(tmpSell);
		}
	}


}
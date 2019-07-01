package flowershop.service.impl;

import flowershop.entity.*;
import flowershop.service.*;

import java.util.*;

import flowershop.dao.*;
import flowershop.dao.impl.*;

public class CustomerServiceImpl implements CustomerService{
	// watch all kinds of flowers
	public void watchFlowers() {
		ShopServiceImpl tmpShopImpl = new ShopServiceImpl();
		tmpShopImpl.printFlower();
	}
	
	// put one kind of flower in the basket
	public boolean addFlowers(Shop shop, int fId, int fNum) {
		ShopServiceImpl tmpShopImpl = new ShopServiceImpl();
		return tmpShopImpl.addFlower(shop, fId, fNum);
	}
	
	// recharge the ID card
	public void rechargeCard(Customer customer, double chargeMoney) {
		customer.setcBalance(customer.getcBalance() + chargeMoney);
	}
	
	// pay for the basket
	public boolean payPayment(Shop shop, Customer customer) {
		CustomerDaoImpl tmpcDao = new CustomerDaoImpl();
		System.out.println("您当前的余额为" + customer.getcBalance() + "元");
		if (customer.getcBalance() < shop.getsMoney()) {
			System.out.println("余额不足，请充值！");
			Scanner input = new Scanner(System.in);
			System.out.println("是否需要充值会员卡？");
			System.out.println("1. 是" + "\t" + "2. 否");
			int tmpInt = input.nextInt();
			if (tmpInt == 1) {
				System.out.println("请问您需要充值多少金额？");
				double tmpDouble = input.nextDouble();
				rechargeCard(customer, tmpDouble);
				tmpcDao.update(customer);
				System.out.println("充值后余额为" + customer.getcBalance() + "元");
				// return payPayment(shop, customer);
			} else {
				System.out.println("对不起，余额不足，无法购买！");
				return false;
			}
		}
		ShopServiceImpl tmpShopImpl = new ShopServiceImpl();
		tmpShopImpl.payMoney(shop);
		customer.setcBalance(customer.getcBalance() - shop.getsMoney());
		tmpcDao.update(customer);
		System.out.println("购买后余额为" + customer.getcBalance() + "元");
		System.out.println("感谢您的购买！");
		return true;
	}
	
	// look for what are bought in the past
	public void pastPayment(Customer customer) {
		ShopDaoImpl tmpsDao = new ShopDaoImpl();
		List<Shop> tmpShopList = tmpsDao.findByUseId(customer.getUserId());
		for (int i = 0; i < tmpShopList.size(); i++) {
			Shop tmpShop = tmpShopList.get(i);
			System.out.println("以下是第" + tmpShop.getsId() + "订单：");
			System.out.println("花名" + "\t" + "数量");
			Map<Integer, Integer> tmpMap = tmpShop.getsBasket();
			FlowerDaoImpl tmpfDao = new FlowerDaoImpl();
			for (Integer key : tmpMap.keySet()) {
				Flower tmpFlower = tmpfDao.findById(key.intValue());
				System.out.println(tmpFlower.getfName() + "\t" + tmpMap.get(key));
			}
		}
	}
}

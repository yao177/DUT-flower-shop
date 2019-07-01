package flowershop.service.impl;

import java.util.*;
import flowershop.dao.impl.CustomerDaoImpl;
import flowershop.dao.impl.FlowerDaoImpl;
import flowershop.entity.Customer;
import flowershop.entity.Flower;
import flowershop.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{

	@Override
	public void printAllFlower() {
		FlowerDaoImpl tmpDao = new FlowerDaoImpl();
		List<Flower> tmpList = tmpDao.findAll();
		System.out.println("序号" + "\t" + "花名" + "\t" + "种类" + "\t" + "价格"+"\t"+"数量"+"\t"+"最新上架时间"+"\t"+"最新上架数量"+"\t"+"畅销度");
		for (int i = 0; i < tmpList.size(); i++) {
			Flower tmpFlower = tmpList.get(i);
			System.out.println(tmpFlower.getfId() + "\t" + tmpFlower.getfName() + "\t" + tmpFlower.getfType() + "\t" + tmpFlower.getfPrice()+"\t"
					+tmpFlower.getfNum()+"\t"+tmpFlower.getfUpTime()+"\t"+tmpFlower.getfUpNum()+"\t"+tmpFlower.getfSell());
		}
	}

	@Override
	public void printAllCustomer() {
		CustomerDaoImpl dao=new CustomerDaoImpl();
		List<Customer> cList=dao.findAll();
		System.out.println("ID"+"\t"+"姓名"+"\t"+"VIP等级");
		for(int i=0;i<cList.size();i++) {
			Customer customer=cList.get(i);
			String vip="";
			switch(customer.getVipLevel()) {
			case 0:
				vip="普通顾客";
				break;
			case 1:
				vip="普通会员";
				break;
			case 2:
				vip="白金会员";
				break;
			case 3:
				vip="黄金会员";
				break;
			default:
				break;
			}
			System.out.println(customer.getUserId()+"\t"+customer.getUserName()+"\t"+vip);
		}
	}

	@Override
	public void setPrice() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要改变价格的花的ID");
		int num=input.nextInt();
		FlowerDaoImpl dao=new FlowerDaoImpl();
		Flower flower=dao.findById(num);
		System.out.println("请输入要设置为的价格");
		double p=input.nextDouble();
		flower.setfPrice(p);
		dao.update(flower);
	}

		@Override
		public void onsell() {
			Scanner input=new Scanner(System.in);
			FlowerDaoImpl tmpfDao = new FlowerDaoImpl();
			System.out.println("请输入要上架的鲜花总数目");
			int n = input.nextInt();
			for(int i = 0 ; i < n ; i ++){
				System.out.println("请问您需要上架的鲜花是否已存在？ 1. 是 / 2. 否");
				int tmpChoice = input.nextInt();
				if (tmpChoice == 1) {
					System.out.println("请输入要上架鲜花的id");
					int tmpId=input.nextInt();
					System.out.println("请输入要上架的鲜花数量");
					int tmpNum = input.nextInt();
					FlowerDaoImpl dao=new FlowerDaoImpl();
					Flower fl=dao.findById(tmpId);
					fl.setfNum(fl.getfNum()+tmpNum);
					Calendar c = Calendar.getInstance();
					String tmpUptime = Integer.toString(c.get(Calendar.YEAR)) + "-" + Integer.toString(c.get(Calendar.MONTH)) + "-" + Integer.toString(c.get(Calendar.DATE));
					// System.out.println(tmpUptime);
					fl.setfUpTime(tmpUptime);
					dao.update(fl);
				}
				else {
					System.out.println("请输入要上架的鲜花id");
					int fId1 = input.nextInt();
					System.out.println("请输入要上架的鲜花名称");
					String fName1 = input.next();
					System.out.println("请输入要上架的鲜花种类");
					String fType1 = input.next();
					System.out.println("请输入要上架的鲜花价格");
					double fPrice1 = input.nextDouble();
					System.out.println("请输入要上架的鲜花数量");
					int fNum1=input.nextInt();
					Flower fl1=new Flower(fId1,fName1,fType1,fPrice1,fNum1,null,fNum1);
					Calendar c = Calendar.getInstance();
					String tmpUptime = Integer.toString(c.get(Calendar.YEAR)) + "-" + Integer.toString(c.get(Calendar.MONTH)) + "-" + Integer.toString(c.get(Calendar.DATE));
					fl1.setfUpTime(tmpUptime);
					FlowerDaoImpl dao=new FlowerDaoImpl();
					dao.add(fl1);
				}
				System.out.println("该鲜花已经上架成功");
			}
		}

		@Override
		public void offsell() {
			Scanner input=new Scanner(System.in);
			System.out.println("请输入要下架的鲜花总数目");
			int n = input.nextInt();
			for(int i = 0 ; i < n ; i ++){
			System.out.println("请输入要下架的鲜花id");
			int fId = input.nextInt();
			FlowerDaoImpl dao=new FlowerDaoImpl();
			Flower flower=dao.findById(fId);
			dao.delete(flower);
		}
			System.out.println("该鲜花已经下架成功");
			
		}
	
}

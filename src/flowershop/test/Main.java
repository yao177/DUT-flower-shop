package flowershop.test;
import flowershop.dao.impl.*;
import flowershop.entity.*;
import flowershop.entity.Flower;
import flowershop.service.impl.CustomerServiceImpl;
import flowershop.service.impl.LoginServiceImpl;
import flowershop.service.impl.ManagerServiceImpl;
import flowershop.service.impl.ShopServiceImpl;

import java.text.SimpleDateFormat;
import java.util.*;
public class Main {
	public static void main(String[] args){
		Main.startFlowerShop();
	}
	public static void startFlowerShop(){
		System.out.println(" 欢迎使用花店");
		System.out.println("请选择输入登录模式，输入1为顾客登录，输入2为管理员登录");
		Scanner input = new Scanner(System.in);
		boolean type = true;
		String num;
		while (type) {
			num = input.next();
			if ("1".equals(num)) {
				Main.CustomerLogin();
				type = false;
			} else if ("2".equals(num)) {
				Main.ManagerLogin();
				type = false;
			} else {
				System.out.println("输入有误，请按照指定规则输入");
				System.out.println("请选择登录模式，输入1为顾客登录，输入2为管理员登录");
				type = true;
			}
		
	}
}
	public static void CustomerLogin(){
		Scanner input = new Scanner(System.in);
		LoginServiceImpl tmpLogin = new LoginServiceImpl();
		Customer customer = tmpLogin.customerLogin();
		boolean reg = true;
		while (reg) {
			if (null == customer) {
				System.out.println("登录失败，请确认您的用户名和密码后重新输入");
				customer = tmpLogin.customerLogin();
				reg = true;
			} else {
				reg = false;
				System.out.println("登录成功，您可以进入购物车进行操作了");
				Main.goShopping(customer);
				boolean type = true;
			}
		}
	}
	public static void ManagerLogin(){
		Scanner input = new Scanner(System.in);
		LoginServiceImpl service=new LoginServiceImpl();
		Manager manager=service.managerLogin();
		boolean reg = true;
		while (reg) {
			if(null == manager) {
				System.out.println("登录失败，请确认您的用户名和密码后重新输入");
				manager = service.managerLogin();
				reg = true;
			} else {
				reg = false;
				boolean flag=true;
				System.out.println("登录成功，您可以进行以下操作");
				while(flag) {
					System.out.println("1.查看店内所有鲜花信息");
					System.out.println("2.上架鲜花");
					System.out.println("3.下架鲜花");
					System.out.println("4.重新设定鲜花价格");
					System.out.println("5.显示店内所有顾客信息");
					System.out.println("6.退出系统");
					boolean type = true;
					ManagerServiceImpl ser=new ManagerServiceImpl();
					while(type){
						int num = input.nextInt();
						if (1 == num) {
							ser.printAllFlower();
							type = false;
						} else if (2 == num) {
							ser.onsell();
							type = false;
						}else if(3 == num) {
							ser.offsell();
							type = false;
						}else if(4 == num) {
							ser.setPrice();
							type = false;
						}else if(5== num) {
							ser.printAllCustomer();
							type=false;
						}else if(6==num) {
							System.out.println("欢迎下次使用");
							flag=false;
						}
						else {
							System.out.println("输入有误,请重新输入");
							type = true;
						}
					}
				}
				
			}
		}
	}
	
	public static void goShopping(Customer customer) {
		Scanner input = new Scanner(System.in);
		ShopServiceImpl tmpShopService = new ShopServiceImpl();
		CustomerServiceImpl tmpCustomerService = new CustomerServiceImpl();
		Shop tmpShop = new Shop();
		tmpShop.setsId(tmpShopService.shopNum() + 1);
		while(true) {
			System.out.println("请选择以下操作：");
			System.out.println("1. 查看鲜花列表");
			System.out.println("2. 查看以往订单");
			System.out.println("3. 增加鲜花");
			System.out.println("4. 修改数量");
			System.out.println("5. 删除鲜花");
			System.out.println("6. 查看购物车");
			System.out.println("7. 结算付款");
			System.out.println("8. 退出");
			int tmpInt = input.nextInt();
			if (tmpInt == 8) {
				break;
			}
			switch (tmpInt) {
				case 1:
					tmpShopService.printFlower();
					break;
				case 2:
					tmpCustomerService.pastPayment(customer);
					break;
				case 3:
					System.out.println("请输入需要增加的鲜花ID：");
					int tmpId = input.nextInt();
					System.out.println("请输入需要增加的鲜花数量：");
					int tmpNum = input.nextInt();
					tmpShopService.addFlower(tmpShop, tmpId, tmpNum);
					break;
				case 4:
					System.out.println("请输入需要修改的鲜花ID：");
					int tmpId1 = input.nextInt();
					System.out.println("请输入修改会的鲜花数量：");
					int tmpNum1 = input.nextInt();
					tmpShopService.changeNum(tmpShop, tmpId1, tmpNum1);
					break;
				case 5:
					System.out.println("请输入需要删除的鲜花ID：");
					int tmpId2 = input.nextInt();
					tmpShopService.deleteFlower(tmpShop, tmpId2);
					break;
				case 6:
					tmpShopService.printBasket(tmpShop);
					break;
				case 7:
					double moneyBefore = tmpShopService.totalMoney(tmpShop);
					double moneyAfter = tmpShopService.discountMoney(tmpShop);
					System.out.println("您的订单价格为" + moneyBefore + "元，会员折扣后仅需" + moneyAfter + "元！");
					tmpCustomerService.payPayment(tmpShop, customer);
					break;
				default:
					System.out.println("输入错误！");
					break;
	
			}
		}
	}
}


package Main;
import java.util.*;

import FlowerShopServiceImpl.SimpleDateFormat;
import flowershop.dao.*;
import flowershop.dao.impl.*;


public class Main {
	public static void main(String[] args){
		Main.startFlowershop();
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
	public static  CustomerLogin(){
		Scanner input = new Scanner(System.in);
		CustomerServiceImpl Customer = new CustomerServiceImpl();
		Customer customer = Customer.login();
		boolean reg = true;
		while (reg) {
			if (null == customer) {
				System.out.println("登录失败，请确认您的用户名和密码后重新输入");
				customer = Customer.login();
				reg = true;
			} else {
				reg = false;
				System.out.println("登录成功，您可以进入购物车进行操作了");
				System.out.println("操作");
				boolean type = true;
			}
		}
		return customer;
	}
	public static ManagerLogin(){
		Scanner input = new Scanner(System.in);
		ManagerServiceImpl Manager = new ManagerServiceImpl();
		Manager manager = Manager.login();
		boolean reg = true;
		while (reg) {
			if (null == customer) {
				System.out.println("登录失败，请确认您的用户名和密码后重新输入");
				customer = Customer.login();
				reg = true;
			} else {
				reg = false;
				System.out.println("登录成功，您可以选择进行上架或下架操作了");
				System.out.println("1.上架鲜花");
				System.out.println("2.下架鲜花");
				boolean type = true;
				while(type){
					int num = input.nextInt();
					if (1 == num) {
						Main.onshell();
						type = false;
					} else if (2 == num) {
						Main.offShell();
						type = false;
					} else {
						System.out.println("输入有误,请重新输入");
						type = true;
					}
				}
			}
		}
		return manager;
	}
	public static void onshell() {
		System.out.println("请输入要上架的鲜花总数目");
		int n = input.nextInt();
		for(int i = 0 ; i < n ; i ++){
		System.out.println("请输入要上架的鲜花id");
		int fId = input.nextInt();
		System.out.println("请输入要上架的鲜花名称");
		String fName = input.next();
		System.out.println("请输入要上架的鲜花种类");
		String fType = input.next();
		System.out.println("请输入要上架的鲜花已有数量");
		int fNum = input.nextInt();
		System.out.println("请输入要上架的鲜花价格");
		double fPrice = input.nextDouble();
		System.out.println("请输入要上架的鲜花数量");
		int fUpNum = input.nextInt();
		SimpleDateFormat fUpTime = new SimpleDateFormat(yyMMdd);
		String[] fParam = {fId,fName,fType,fNum,fPrice,fUpNum,fUpTime.format(new Date())};
		ManagerServiceImpl.onshell(FlowerYard.Newflower(fParam));
		}
	}
	public static void offshell() {
		System.out.println("请输入要下架的鲜花总数目");
		int n = input.nextInt();
		for(int i = 0 ; i < n ; i ++){
		System.out.println("请输入要下架的鲜花id");
		int fId = input.nextInt();
		ManagerServiceImpl.offshell(FlowerDaoImpl.findById(fId));
		}
	}
	}

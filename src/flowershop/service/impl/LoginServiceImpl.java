package flowershop.service.impl;
import java.util.*;

import flowershop.dao.impl.CustomerDaoImpl;
import flowershop.dao.impl.ManagerDaoImpl;
import flowershop.entity.Customer;
import flowershop.entity.Manager;
import flowershop.service.LoginService;
public class LoginServiceImpl implements LoginService{

	@Override
	public Customer customerLogin() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入您的姓名");
		String name=input.next();
		System.out.println("请输入您的密码");
		String password=input.next();
		boolean flag=false;
		int i;
		CustomerDaoImpl dao =new CustomerDaoImpl();
		List<Customer> cList=dao.findAll();
		for(i=0;i<cList.size();i++) {
			if(cList.get(i).getUserName().equals(name)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			if(cList.get(i).getUserPassword().equals(password)) {
				return cList.get(i);
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public Manager managerLogin() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入您的姓名");
		String name=input.next();
		System.out.println("请输入您的密码");
		String password=input.next();
		boolean flag=false;
		int i;
		ManagerDaoImpl dao =new ManagerDaoImpl();
		List<Manager> mList=dao.findAll();
		for(i=0;i<mList.size();i++) {
			if(mList.get(i).getUserName().equals(name)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			if(mList.get(i).getUserPassword().equals(password)) {
				return mList.get(i);
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}


}

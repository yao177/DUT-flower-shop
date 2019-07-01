package flowershop.service.impl;

import flowershop.dao.impl.CustomerDaoImpl;
import flowershop.entity.Customer;
import flowershop.service.RegisterService;
import java.util.*;

public class RegisterServiceImpl implements RegisterService{

	@Override
	public Customer register() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入您的姓名");
		String name=input.next();
		System.out.println("请设置您的密码");
		String password=input.next();
		System.out.println("请确认您的密码");
		String passwordAgain=input.next();
		while(!passwordAgain.equals(password)) {
			System.out.println("密码验证错误，请重新输入");
			passwordAgain=input.next();
		}
		System.out.println("注册成功");
		CustomerDaoImpl dao=new CustomerDaoImpl();
		List<Customer> allCustomer=dao.findAll();
		int id=allCustomer.size()+1;
		System.out.println("您的ID号为"+id+",请保管好");
		Customer customer=new Customer(id,name,password,0,0);
		dao.add(customer);
		return customer;
	}
}

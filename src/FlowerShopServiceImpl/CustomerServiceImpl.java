package FlowerShopServiceImpl;
import java.util.*;
public class CustomerServiceImpl {
			public Customer login() {
				Scanner input = new Scanner(System.in);
				// 1、输入主人姓名
				System.out.println("请先登录，请您输入顾客的id：");
				int CustomerId = input.nextInt().trim();
				System.out.println("请您输入顾客的密码：");
				String CustomerPassword = input.nextLine().trim();
				UserDao CustomerDao = new UserDaoImpl();
				Customer customer = UserDao.findById(CustomerId);
				if (null != customer) {
					System.out.println("-------恭喜您成功登录-------");
					System.out.println("-------您的基本信息：-------");
					System.out.println("名字：" + customer.getUserName());
					System.out.println("vip level：" + customer.getVipBouns());
				}
				return customer;
			}
	}
}

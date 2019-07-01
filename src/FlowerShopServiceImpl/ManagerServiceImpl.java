package FlowerShopServiceImpl;
import java.util.*;
import java.text.SimpleDateFormat;
public class ManagerServiceImpl {
	public Manager login() {
		Scanner input = new Scanner(System.in);
		// 1、输入主人姓名
		System.out.println("请先登录，请您输入管理员的id：");
		String ManagerId = input.nextInt().trim();
		System.out.println("请您输入管理员的密码：");
		String ManagerPassword = input.nextLine().trim();
		UserDao ManagerDao = new UserDaoImpl();
		Manager manager = UserDao.findById(ManagerId);
		if (null != manager) {
			System.out.println("-------恭喜您成功登录-------");
			System.out.println("-------您的基本信息：-------");
			System.out.println("名字：" + customer.getUserName());
		}
		return manager;
	}
	public void onshell (Flower flower){
	FlowerDaoImpl.add(flower);
	}
	public void offshell(Flower flower){
		FlowerDaoImpl.delete(flower);
	}
}

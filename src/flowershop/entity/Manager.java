package flowershop.entity;


public class Manager extends User{
	public Manager() {}
	public Manager(int uId,String uName,String uPassword) {
		super(uId,uName,uPassword);
	}
	/*public void setVipBonus(int vipLevel,double vipBonus) {
		VipBonus temp = null;
		temp.setVipBonus(vipLevel, vipBonus);
	}*/
}

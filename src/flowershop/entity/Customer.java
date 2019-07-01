package flowershop.entity;

public class Customer extends User {
	private int vipLevel;
	private double cBalance;
	public Customer() {}
	public Customer(int uId,String uName,String uPassword,int vipLevel,double cBalance) {
		super(uId,uName,uPassword);
		this.vipLevel=vipLevel;
		this.cBalance=cBalance;
	}
	public double getcBalance() {
		return cBalance;
	}
	public void setcBalance(double cBalance) {
		this.cBalance = cBalance;
	}
	public int getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(int newVipLevel) {
		vipLevel=newVipLevel;
	}
	public double getVipBonus() {
		switch(vipLevel) {
		case 0:
			return 1;
		case 1:
			return 0.9;
		case 2:
			return 0.8;
		case 3:
			return 0.7;
		default:
			return -1;
		}
	}
	
}

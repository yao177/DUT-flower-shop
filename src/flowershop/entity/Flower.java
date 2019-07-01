package flowershop.entity;

import java.util.*;

public class Flower {
	int fId;		// ID numbers of flowers
	String fName;	// names of flowers
	String fType;	// different kinds of flowers
	double fPrice;	// unit prices of flowers
	int fNum;		// present numbers of flowers
	String fUpTime;	// dates of latest added time
	int fUpNum;		// latest added numbers of flowers
	double fSell;	// whether it sells well or not
	// index = unit of num / unit of time
	//		 = (fUpNum - fNum) / (presentTime - fUpTime)
	// if the 'index' > fWellIndex, it means that this kind of flower sells well.
	static double fWellIndex = 10.0;
	
	public Flower() {}
	public Flower(int fId, String fName, String fType, double fPrice, int fNum, String fUpTime, int fUpNum) {
		this.fId = fId;
		this.fName = fName;
		this.fType = fType;
		this.fPrice = fPrice;
		this.fNum = fNum;
		this.fUpTime = fUpTime;
		this.fUpNum = fUpNum;
	}
	
	// <<getter>> && <<setter>>
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfType() {
		return fType;
	}
	public void setfType(String fType) {
		this.fType = fType;
	}
	public double getfPrice() {
		return fPrice;
	}
	public void setfPrice(double fPrice) {
		this.fPrice = fPrice;
	}
	public int getfNum() {
		return fNum;
	}
	public void setfNum(int fNum) {
		this.fNum = fNum;
	}
	public String getfUpTime() {
		return fUpTime;
	}
	public void setfUpTime(String fUpTime) {
		this.fUpTime = fUpTime;
	}
	public int getfUpNum() {
		return fUpNum;
	}
	public void setfUpNum(int fUpNum) {
		this.fUpNum = fUpNum;
	}
	public double getfSell() {
		return fSell;
	}
	public void setfSell(double fSell) {
		this.fSell=fSell;
	}
	// if one kind of flower sells well, it will return 'true'.
	/*public boolean isSellWell() {
		
	}*/
}
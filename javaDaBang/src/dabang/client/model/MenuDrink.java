package dabang.client.model;

import java.util.ArrayList;
import java.util.Calendar;

public class MenuDrink {
	private int kindOfDrink;//음료종류
	private String size;//Short,Tall,Grande,Venti
	private String syrupType;//시럽종류
	private int syrupNum;//시럽 갯수
	private Calendar d;//날짜
	
	public Calendar getD() {
		return d;
	}

	public void setD(Calendar d) {
		this.d = d;
	}
	private ArrayList<MenuDrink> orderDrink = new ArrayList<MenuDrink>();
	
	public MenuDrink() {}
	
	public MenuDrink(int kindOfDrink, String size, String syrup, int syrupNum, int price) {
		super();
		this.kindOfDrink = kindOfDrink;
		this.size = size;
		this.syrupType = syrup;
		this.syrupNum = syrupNum;
		this.price = price;
	}
	public int getKindOfDrink() {
		return kindOfDrink;
	}
	public void setKindOfDrink(int kindOfDrink) {
		this.kindOfDrink = kindOfDrink;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSyrup() {
		return syrupType;
	}
	public void setSyrup(String syrup) {
		this.syrupType = syrup;
	}
	public int getSyrupNum() {
		return syrupNum;
	}
	public void setSyrupNum(int syrupNum) {
		this.syrupNum = syrupNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int price;//가격
	
	
}

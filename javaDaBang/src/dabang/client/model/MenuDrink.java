package dabang.client.model;

import java.util.ArrayList;
import java.util.Calendar;

public class MenuDrink {
	private String size;//Short,Tall,Grande,Venti
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
	
	public MenuDrink(String size, int syrupNum, int price) {
		super();
		this.size = size;
		this.syrupNum = syrupNum;
		this.price = price;
	}

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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

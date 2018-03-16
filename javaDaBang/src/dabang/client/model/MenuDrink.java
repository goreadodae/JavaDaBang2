package dabang.client.model;

import java.util.ArrayList;
import java.util.Calendar;

public class MenuDrink {
	private int kindOfDrink; // 1. ����������, 2. ����Ǫġ��, 3. Ƽ
	private String size;//Short,Tall,Grande,Venti
	private int syrupNum;//�÷� ����
	private Calendar d;//��¥
	private int price;//����
	
	public Calendar getD() {
		return d;
	}

	public void setD(Calendar d) {
		this.d = d;
	}
	
	private ArrayList<MenuDrink> orderDrink = new ArrayList<MenuDrink>();
	
	public MenuDrink() {}
	
	public MenuDrink(int kindOfDrink, String size, int syrupNum, int price) {
		super();
		this.kindOfDrink = kindOfDrink;
		this.size = size;
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
	
	
	
}

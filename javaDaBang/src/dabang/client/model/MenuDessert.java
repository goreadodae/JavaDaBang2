package dabang.client.model;

import java.util.Calendar;

public class MenuDessert {

	private int kindDessert; 		// 디저트 종류(케이크, 샌드위치)
	private String dessertName; 	// 디저트 이름
	private int dessertNum; 		// 디저트 주문 수량
	private int dessertPrice; 		// 디저트  가격
	private Calendar orderDate;		// 주문 날짜

	public void setCallendar(Calendar orderDate)
	{
		this.orderDate = orderDate;
	}
	public Calendar getCallendar()
	{
		return orderDate;
	}
	
	
	public MenuDessert() {}

	public MenuDessert(int kindDessert, String dessertName, int dessertNum,	int dessertPrice) {

		this.kindDessert = kindDessert;
		this.dessertName = dessertName;
		this.dessertNum = dessertNum;
		this.dessertPrice = dessertPrice;	
	}


	public int getKindDessert() {
		return kindDessert;
	}

	public void setKindDessert(int kindDessert) {
		this.kindDessert = kindDessert;
	}

	public String getDessertName() {
		return dessertName;
	}

	public void setDessertName(String dessertName) {
		this.dessertName = dessertName;
	}

	public int getDessertNum() {
		return dessertNum;
	}

	public void setDessertNum(int dessertNum) {
		this.dessertNum = dessertNum;
	}

	public int getDessertPrice() {
		return dessertPrice;
	}

	public void setDessertPrice(int dessertPrice) {
		this.dessertPrice = dessertPrice;
	}
	
}

package dabang.client.model;

import java.util.Calendar;

public class MenuDessert {

	private int kindDessert; 		// 디저트 종류(케이크, 샌드위치)
	private String dessertName; 	// 디저트 이름
	private int dessertNum; 		// 디저트 주문 수량
	private int dessertPrice; 		// 디저트  가격
	private Calendar orderDate;		// 주문 날짜

	
	public MenuDessert() {}

	public MenuDessert(int kindDessert, String dessertName,
			int dessertNum,	int dessertPrice) {

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
	
	public Calendar getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}
	
	public String toString() { // 디저트 종류, 이름, 수량, 가격, 주문시간 출력
		return this.kindDessert + "\t" + this.dessertName + "\t" +
					this.dessertNum + "\t" + this.dessertPrice + "\t"
					+ this.orderDate;
	}

}

package dabang.client.model;

import java.util.Calendar;

public class MenuDessert {

	private int kindDessert; 		// ����Ʈ ����(����ũ, ������ġ)
	private String dessertName; 	// ����Ʈ �̸�
	private int dessertNum; 		// ����Ʈ �ֹ� ����
	private int dessertPrice; 		// ����Ʈ  ����
	private Calendar orderDate;		// �ֹ� ��¥

	
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
	
	public String toString() { // ����Ʈ ����, �̸�, ����, ����, �ֹ��ð� ���
		return this.kindDessert + "\t" + this.dessertName + "\t" +
					this.dessertNum + "\t" + this.dessertPrice + "\t"
					+ this.orderDate;
	}

}

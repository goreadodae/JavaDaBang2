package dabang.client.model;

import java.io.Serializable;
import java.util.Calendar;

public class Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1678568L;
	private int orderNumber; 	// 주문번호
	private String kindOfMenu;	// 상품종류
	private String menuName; 	// 상품이름
	private int numberOfGoods; 	// 상품수량
	private int price;			// 상품 가격
	private Calendar orderDate; // 날짜
	
	
	public Menu() {}
	
	public Menu(int orderNumber, int numberOfGoods, String menuName, int price) {
		this.orderNumber = orderNumber;
		this.numberOfGoods = numberOfGoods;
		this.menuName = menuName;
		this.price = price;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getNumberOfGoods() {
		return numberOfGoods;
	}

	public void setNumberOfGoods(int numberOfGoods) {
		this.numberOfGoods = numberOfGoods;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public String getKindOfMenu() {
		return kindOfMenu;
	}

	public void setKindOfMenu(String kindOfMenu) {
		this.kindOfMenu = kindOfMenu;
	}
	
	
	@Override
	public String toString()
	{
		return this.orderNumber + " \t\t" +
				this.kindOfMenu + "\t\t" +
				this.menuName + "\t\t" +
				this.numberOfGoods + "\t\t" +
				this.price + "\t\t" +
				this.orderDate;
	}
	
	
}

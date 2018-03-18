package dabang.client.model;

import java.io.Serializable;

public class OrderList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1345341L;
	private String name;
	private String Size;
	private int orderNum;
	private int Price;
	public String toString() {
		return this.name + this.Size + this.orderNum + this.Price;
	}
	public OrderList() {}
	public OrderList(String name, String size, int orderNum, int price) {
		super();
		this.name = name;
		Size = size;
		this.orderNum = orderNum;
		Price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
	
}

package dabang.client.model;

public class OrderList {
	private String name;
	private String Size;
	private int orderNum;
	private int Price;
	
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

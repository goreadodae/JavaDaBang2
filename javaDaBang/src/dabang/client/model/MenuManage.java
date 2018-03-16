package dabang.client.model;

public class MenuManage {

	private String menuname;
	private int menuprice;
	
	public MenuManage() {}
	public MenuManage(String name, int price) {
		this.menuname=name;
		this.menuprice=price;
	}
	
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public int getMenuprice() {
		return menuprice;
	}
	public void setMenuprice(int menuprice) {
		this.menuprice = menuprice;
	}
	public String toString () {
		return this.menuname + "\t" + this.menuprice + "\n";
	}
	
	
	
	
}

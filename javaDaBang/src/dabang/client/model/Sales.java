package dabang.client.model;

public class Sales implements Comparable {
	private String menuName;
	private int totalSalesCount = 0;
	private int totalSalesPrice = 0;
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getTotalSalesCount() {
		return totalSalesCount;
	}
	public void setTotalSalesCount(int totalSalesCount) {
		this.totalSalesCount = totalSalesCount;
	}
	public int getTotalSalesPrice() {
		return totalSalesPrice;
	}
	public void setTotalSalesPrice(int totalSalesPrice) {
		this.totalSalesPrice = totalSalesPrice;
	}
	
	@Override
	public int compareTo(Object o) {
		return this.getTotalSalesCount() - ((Sales)o).getTotalSalesCount(); 
	}
	
}

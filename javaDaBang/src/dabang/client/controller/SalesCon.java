package dabang.client.controller;

import java.util.ArrayList;
import java.util.HashMap;

import dabang.client.model.Member;
import dabang.client.model.Menu;
import dabang.client.model.Sales;

public class SalesCon {
	private HashMap<String, Sales> salesMap = new HashMap<String, Sales>();
	private ArrayList<Sales> salesAl = new ArrayList<Sales>();

	public void addSales(Menu m) {
		Sales salesMenu = new Sales();
		if(salesMap.containsKey(m.getMenuName())) {
			salesMenu.setMenuName(m.getMenuName());
			salesMenu.setTotalSalesCount(salesMap.get(m.getMenuName()).getTotalSalesCount()+m.getNumberOfGoods());
			salesMenu.setTotalSalesPrice(salesMap.get(m.getMenuName()).getTotalSalesPrice()+m.getNumberOfGoods()*m.getPrice());
		}
		else {
			salesMenu.setMenuName(m.getMenuName());
			salesMenu.setTotalSalesCount(m.getNumberOfGoods());
			salesMenu.setTotalSalesPrice(m.getNumberOfGoods()*m.getPrice());
		}
		salesMap.put(m.getMenuName(), salesMenu);
	}

	public HashMap<String, Sales> selectSales() {
		return salesMap;
	}
}

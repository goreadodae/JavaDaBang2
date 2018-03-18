package dabang.client.model;

import java.util.ArrayList;
import java.util.Calendar;

public class MenuDrink extends Menu{
	private int kindOfDrink;//��������
	private String goodsName;//��ǰ�̸�
	private String size;//Short,Tall,Grande,Venti
	private String syrupType;//�÷�����
	private int syrupNum;//�÷� ����
	private Calendar d;//��¥
	
	public Calendar getD() {
		return d;
	}

	public void setD(Calendar d) {
		this.d = d;
	}
	
	public MenuDrink() {}
	
	public MenuDrink(int kindOfDrink, String size, String syrup, int syrupNum) {
		super();
		this.kindOfDrink = kindOfDrink;
		this.size = size;
		this.syrupType = syrup;
		this.syrupNum = syrupNum;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getSyrupType() {
		return syrupType;
	}
	public void setSyrupType(String syrupType) {
		this.syrupType = syrupType;
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
	public String getSyrup() {
		return syrupType;
	}
	public void setSyrup(String syrup) {
		this.syrupType = syrup;
	}
	public int getSyrupNum() {
		return syrupNum;
	}
	public void setSyrupNum(int syrupNum) {
		this.syrupNum = syrupNum;
	}
	
	
}

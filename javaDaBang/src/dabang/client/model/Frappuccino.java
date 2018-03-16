package dabang.client.model;

public class Frappuccino extends MenuDrink{

	private int frappuccinoRoast; //프라푸치노 로스트 양
	private String milkType;//우유종류 일반우유, 저지방우유, 무지방우유, 두유
	private int iceAmount;// 얼음 양 1~3, 적게, 보통, 많이
	private int javaChipNum;//자바칩의 갯수
	private int whippingAmount;//휘핑 양 1~4 없이, 적게, 보통, 많이
	private int drizzleAmount;//드리즐 양 1~3 적게, 보통, 많이
	

	public Frappuccino() {}
	
	public Frappuccino(int frappuccinoRoast, String milkType, int whippingAmount,
			int drizzleAmount, int javaChipNum, int iceAmount) {
		super();
		this.frappuccinoRoast = frappuccinoRoast;
		this.milkType = milkType;
		this.whippingAmount = whippingAmount;
		this.drizzleAmount = drizzleAmount;
		this.javaChipNum = javaChipNum;
		this.iceAmount = iceAmount;
	}
	public String getMilkType() {
		return milkType;
	}
	public void setMilkType(String milkType) {
		this.milkType = milkType;
	}

	public int getWhippingAmount() {
		return whippingAmount;
	}
	public void setWhippingAmount(int whippingAmount) {
		this.whippingAmount = whippingAmount;
	}
	public int getDrizzleAmount() {
		return drizzleAmount;
	}
	public void setDrizzleAmount(int drizzleAmount) {
		this.drizzleAmount = drizzleAmount;
	}

	public int getJavaChipNum() {
		return javaChipNum;
	}
	public void setJavaChipNum(int javaChipNum) {
		this.javaChipNum = javaChipNum;
	}

	public int geticeAmount() {
		return iceAmount;
	}

	public void seticeAmount(int iceAmount) {
		this.iceAmount = iceAmount;
	}
	public int getFrappuccinoRoast() {
		return frappuccinoRoast;
	}

	public void setFrappuccinoRoast(int frappuccinoRoast) {
		this.frappuccinoRoast = frappuccinoRoast;
	}

	public int getIceAmount() {
		return iceAmount;
	}

	public void setIceAmount(int iceAmount) {
		this.iceAmount = iceAmount;
	}
	
}


package dabang.client.model;

public class Frappuccino extends MenuDrink{

	private String milkType;//우유종류 일반우유, 저지방우유, 무지방우유, 두유
	private String whippingType;//휘핑 종류 일반휘핑, 에스프레소 휘핑
	private int whippingAmount;//휘핑 양 1~4 없이, 적게, 보통, 많이
	private int drizzleAmount;//드리즐 양 1~3 적게, 보통, 많이
	private String javaChipType;//자바칩 타입 자바칩, 반반, 통자바칩토핑
	private int javaChipNum;//자바칩의 갯수
	private String powderType;//파우더의 종류
	private int powderNum;//파우더 추가 개수
	

	public Frappuccino() {}
	
	public Frappuccino(String[] frappuccino, String milkType, String whippingType, int whippingAmount,
			int drizzleAmount, String javaChipType, int javaChipNum) {
		super();
		this.milkType = milkType;
		this.whippingType = whippingType;
		this.whippingAmount = whippingAmount;
		this.drizzleAmount = drizzleAmount;
		this.javaChipType = javaChipType;
		this.javaChipNum = javaChipNum;
	}
	public String getMilkType() {
		return milkType;
	}
	public void setMilkType(String milkType) {
		this.milkType = milkType;
	}
	public String getWhippingType() {
		return whippingType;
	}
	public void setWhippingType(String whippingType) {
		this.whippingType = whippingType;
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
	public String getJavaChipType() {
		return javaChipType;
	}
	public void setJavaChipType(String javaChipType) {
		this.javaChipType = javaChipType;
	}
	public int getJavaChipNum() {
		return javaChipNum;
	}
	public void setJavaChipNum(int javaChipNum) {
		this.javaChipNum = javaChipNum;
	}
	public String getPowderType() {
		return powderType;
	}

	public void setPowderType(String powderType) {
		this.powderType = powderType;
	}

	public int getPowderNum() {
		return powderNum;
	}

	public void setPowderNum(int powderNum) {
		this.powderNum = powderNum;
	}
	
}

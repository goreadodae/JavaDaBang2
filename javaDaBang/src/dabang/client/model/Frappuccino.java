package dabang.client.model;

public class Frappuccino extends MenuDrink{

	private int frappuccinoRoast; //����Ǫġ�� �ν�Ʈ ��
	private String milkType;//�������� �Ϲݿ���, ���������, ���������, ����
	private int iceAmount;// ���� �� 1~3, ����, ����, ����
	private int javaChipNum;//�ڹ�Ĩ�� ����
	private int whippingAmount;//���� �� 1~4 ����, ����, ����, ����
	private int drizzleAmount;//�帮�� �� 1~3 ����, ����, ����
	

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


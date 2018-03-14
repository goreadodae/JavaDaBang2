package dabang.client.model;

public class Frappuccino extends MenuDrink{

	private String milkType;//�������� �Ϲݿ���, ���������, ���������, ����
	private String whippingType;//���� ���� �Ϲ�����, ���������� ����
	private int whippingAmount;//���� �� 1~4 ����, ����, ����, ����
	private int drizzleAmount;//�帮�� �� 1~3 ����, ����, ����
	private String javaChipType;//�ڹ�Ĩ Ÿ�� �ڹ�Ĩ, �ݹ�, ���ڹ�Ĩ����
	private int javaChipNum;//�ڹ�Ĩ�� ����
	private String powderType;//�Ŀ���� ����
	private int powderNum;//�Ŀ�� �߰� ����
	

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

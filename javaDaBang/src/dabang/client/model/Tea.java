package dabang.client.model;

public class Tea extends MenuDrink{
	private String hotAndIce;//Hot/Ice
	private int shot; // ��
	private String milk; //���� ���� �Ϲ�,������,������,����
	private int base; // ���̽� ����, ����, ����
	private int whipAmount;//������ �� ����, ����, ����
	private int drizzleAmount;//�帮�� �� ����, ����, ����
	
	public Tea() {}
	
	public Tea(String hotAndIce, int shot, String milk, int base, int whipAmount, int drizzleAmount) {
		super();
		this.hotAndIce = hotAndIce;
		this.shot = shot;
		this.milk = milk;
		this.base = base;
		this.whipAmount = whipAmount;
		this.drizzleAmount = drizzleAmount;
	}
	public int getShot() {
		return shot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}

	public String getMilk() {
		return milk;
	}

	public void setMilk(String milk) {
		this.milk = milk;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getWhipAmount() {
		return whipAmount;
	}

	public void setWhipAmount(int whipAmount) {
		this.whipAmount = whipAmount;
	}

	public int getDrizzleAmount() {
		return drizzleAmount;
	}

	public void setDrizzleAmount(int drizzleAmount) {
		this.drizzleAmount = drizzleAmount;
	}

	public String getHotAndIce() {
		return hotAndIce;
	}
	public void setHotAndIce(String hotAndIce) {
		this.hotAndIce = hotAndIce;
	}

}

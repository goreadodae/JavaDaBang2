package dabang.client.model;

public class Espresso extends MenuDrink{
	
	private String hotAndIce;//Hot/Ice
	private int shot;//��23
	private int waterAmount;//���� �� 1~3 ����, ����, ����
	private int iceAmount;//������ �� 0~1 ���ų�, ����
	private int whipAmount;//���� �� 0~3 ���ų�, ����, ����, ����
	private int drizzleAmount;//�帮�� �� 0~3 ���ų�, ����, ����, ����
	
	public Espresso() {}
	
	public Espresso(String hotAndIce, int shot, int iceAmount, int waterAmount) {
		super();
		this.hotAndIce = hotAndIce;
		this.shot = shot;
		this.iceAmount = iceAmount;
		this.waterAmount = waterAmount;
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
	public int getShot() {
		return shot;
	}
	public void setShot(int shot) {
		this.shot = shot;
	}
	public int getIceAmount() {
		return iceAmount;
	}
	public void setIceAmount(int iceAmount) {
		this.iceAmount = iceAmount;
	}
	public int getWaterAmount() {
		return waterAmount;
	}
	public void setWaterAmount(int waterAmount) {
		this.waterAmount = waterAmount;
	}

	

}

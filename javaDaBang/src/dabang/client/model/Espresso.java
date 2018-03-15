package dabang.client.model;

public class Espresso extends MenuDrink{
	
	private String hotAndIce;//Hot/Ice
	private int shot;//��23
	private int iceAmount;//������ �� 1~4 ����, ����, ����, ����
	private int waterAmount;//���� �� 1~3 ����, ����, ����
	
	public Espresso() {}
	
	public Espresso(String hotAndIce, int shot, int iceAmount, int waterAmount) {
		super();
		this.hotAndIce = hotAndIce;
		this.shot = shot;
		this.iceAmount = iceAmount;
		this.waterAmount = waterAmount;
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

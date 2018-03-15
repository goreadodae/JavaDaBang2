package dabang.client.model;

public class Espresso extends MenuDrink{
	
	private String hotAndIce;//Hot/Ice
	private int shot;//샷23
	private int iceAmount;//얼음의 양 1~4 없이, 적게, 보통, 많이
	private int waterAmount;//물의 양 1~3 적게, 보통, 많이
	
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

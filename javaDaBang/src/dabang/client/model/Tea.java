package dabang.client.model;

public class Tea extends MenuDrink{
	private String hotAndIce;//Hot/Ice
	private int iceAmount;//얼음의 양 1~4 없이, 적게, 보통, 많이
	private int waterAmount;//물의 양 1~3 적게, 보통, 많이
	
	public Tea() {}
	
	public Tea(String hotAndIce, int iceAmount, int waterAmount) {
		super();
		this.hotAndIce = hotAndIce;
		this.iceAmount = iceAmount;
		this.waterAmount = waterAmount;
	}
	public String getHotAndIce() {
		return hotAndIce;
	}
	public void setHotAndIce(String hotAndIce) {
		this.hotAndIce = hotAndIce;
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

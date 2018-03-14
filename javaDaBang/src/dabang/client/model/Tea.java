package dabang.client.model;

public class Tea extends MenuDrink{
	private String hotAndIce;//Hot/Ice
	private int iceAmount;//������ �� 1~4 ����, ����, ����, ����
	private int waterAmount;//���� �� 1~3 ����, ����, ����
	
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

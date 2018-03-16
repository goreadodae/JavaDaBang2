package dabang.client.model;

public class Tea extends MenuDrink{
	private String hotAndIce;//Hot/Ice
	private int shot; // 샷
	private String milk; //우유 종류 일반,저지방,무지방,두유
	private int base; // 베이스 적게, 보통, 많이
	private int whipAmount;//휘핑의 양 적게, 보통, 많이
	private int drizzleAmount;//드리즐 양 적게, 보통, 많이
	
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

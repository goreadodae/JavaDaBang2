package dabang.client.model;

public class MenuManage {

	private String egmenuename; //�޴������̸�
	private String kormenurname;  //�޴��ѱ��̸�
	private int menuprice; //�޴�����
	private String photoaddr; //�޴������ּ�
	private int kindofmenu; //�޴����� 1��:���������� 2��:����Ǫġ�� 3��:��  4�� :����Ʈ
	
	
	public MenuManage() {}
	public MenuManage(String egmenuename, String kormenurname,int menuprice, String photoaddr,int kindofmenu) {
		this.egmenuename=egmenuename;
		this.kormenurname=kormenurname;
		this.menuprice=menuprice;
		this.photoaddr=photoaddr;
		this.kindofmenu=kindofmenu;
	}
	
	
	public String getEgmenuename() {
		return egmenuename;
	}
	public void setEgmenuename(String egmenuename) {
		this.egmenuename = egmenuename;
	}
	public String getKormenurname() {
		return kormenurname;
	}
	public void setKormenurname(String kormenurname) {
		this.kormenurname = kormenurname;
	}
	public int getMenuprice() {
		return menuprice;
	}
	public void setMenuprice(int menuprice) {
		this.menuprice = menuprice;
	}
	public String getPhotoaddr() {
		return photoaddr;
	}
	public void setPhotoaddr(String photoaddr) {
		this.photoaddr = photoaddr;
	}
	public int getKindofmenu() {
		return kindofmenu;
	}
	public void setKindofmenu(int kindofmenu) {
		this.kindofmenu = kindofmenu;
	}
	
	public String toString () {
		return this.egmenuename + "\t" + this.kormenurname + "\t" + this.menuprice + "\t" + this.photoaddr + "\t" +this.kindofmenu + "\n" ;
	}
	
	
	
	
}

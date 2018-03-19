package dabang.client.model;

public class MenuManage {

	private String egmenuename; //메뉴영어이름
	private String kormenurname;  //메뉴한글이름
	private int menuprice; //메뉴가격
	private String photoaddr; //메뉴사진주소
	private int kindofmenu; //메뉴종류 1번:에스프레소 2번:프라푸치노 3번:차  4번 :디저트
	
	
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

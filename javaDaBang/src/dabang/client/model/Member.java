package dabang.client.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1425457L;
	private String id;        //���̵�
	private String passWord;  //��й�ȣ
	private String nickName;  //���� 
	private String name;      //�̸�
	private int sclc;//1���, 2����
	private int ageY;
	private int ageM;
	private int ageD;
	private char gender;
	private String phoneNumber;  //����
	private String grade;     //ȸ�����
	private double point;     //����Ʈ
	private int visitCount; //�湮Ƚ��
	private ArrayList<ArrayList<Menu>> list = new ArrayList<ArrayList<Menu>>();//�ֹ� ����

	public ArrayList<ArrayList<Menu>> getList() {
		return list;
	}

	public void setList(ArrayList<ArrayList<Menu>> list) {
		this.list = list;
	}

	public Member() {}
	
	public Member(String id, String passWord, String name) {
		this.id = id;
		this.passWord = passWord;
		this.name = name;
	}
	
	public Member(String id,String passWord,String nickName,
			String name,int sclc,int ageY,int ageM,int ageD,char gender,String phoneNumber,int visitCount, String grade,double point) {
		super();
		this.id = id;
		this.passWord = passWord;
		this.nickName = nickName;
		this.name = name;
		this.sclc = sclc;
		this.ageY = ageY;
		this.ageM = ageM;
		this.ageD = ageD;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.visitCount = visitCount;
		this.grade = grade;
		this.point = point;
	}
	



		// TODO Auto-generated constructor stub
	

	public Member(String id, String nickName, String name, int sclc, int ageY, int ageM, int ageD, char gender, String phoneNumber,
			String grade, int point) {
		
		this.id = id;
		this.nickName = nickName;
		this.name = name;
		this.sclc = sclc;
		this.ageY = ageY;
		this.ageM = ageM;
		this.ageD = ageD;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.grade = grade;
		this.point = point;
	}
	
	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	//������
	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getSclc() {
		return sclc;
	}

	public void setSclc(int sclc) {
		this.sclc = sclc;
	}
	public int getAgeY() {
		return ageY;
	}
	public void setAgeY(int ageY) {
		this.ageY = ageY;
	}
	public int getAgeM() {
		return ageM;
	}
	public void setAgeM(int ageM) {
		this.ageM = ageM;
	}
	public int getAgeD() {
		return ageD;
	}
	public void setAgeD(int ageD) {
		this.ageD = ageD;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGrade() {
		if(0 <= visitCount && visitCount < 2)
		{
			return "welcome";
		}
		else if (2 <= visitCount &&	visitCount <4)
		{
			return "green";
		}
		else if(4 <= visitCount)
		{
			return "gold";
		}
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString()
	{
		return  
				this.id           +
				this.nickName     +
				this.name         +
				this.sclc         +
				this.ageY         +
				this.ageM         +
				this.ageD         +
				this.gender       +
				this.phoneNumber  +
				this.grade        +
				this.visitCount   +
				this.point;
	}

}
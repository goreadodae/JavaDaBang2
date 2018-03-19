package dabang.client.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.JLabel;

import dabang.client.model.MenuManage;

public class MenuManageControl {

	HashMap <String,MenuManage> adminmenu = new HashMap<String,MenuManage>();
	ArrayList<String> menuname = new ArrayList<String>();
	ArrayList<String> menuprice = new ArrayList<String>();
	
	private Properties props = new Properties();
	
	String str  =  null;
	String s[] = null;

	public boolean menuPlus(MenuManage menuInsert) { //메뉴추가
		if(props.containsKey(menuInsert.getEgmenuename())) {
			return false;
		}else {
			props.put(menuInsert.getEgmenuename(),menuInsert.toString());
			//adminmenu.put(menuInsert.getKormenurname(),menuInsert);
			return true;
		}
		
	}


	public boolean menumodify(MenuManage modifymenu) { //메뉴수정
		if(adminmenu.containsKey(modifymenu.getKormenurname())){
			adminmenu.put(modifymenu.getKormenurname(), modifymenu);
			return true;			
		}
		else{return false;}
	}

	public boolean menuDelete(String deletemenuname) { //메뉴삭제
		if(adminmenu.containsKey(deletemenuname)) {
			adminmenu.remove(deletemenuname);
			return true;
		}
		else{return false;}
	}


	public  ArrayList<String> arraytmenuname()   {  //메뉴명출력
		
		Enumeration<Object> enumm = props.keys();

		
		while (enumm.hasMoreElements()) {
			String key = (String) enumm.nextElement(); 
			//enumm.nextElement();
			try {
				str = new String(((String) props.get(key)).getBytes("ISO-8859-1"), "UTF-8");
				s = str.split("/");

				menuname.add(s[0]);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return menuname;
	}

	public  ArrayList<String> arraytmenuprice()   {  //가격출력
		
		Enumeration<Object> enumm = props.keys();

		
		while (enumm.hasMoreElements()) {
			String key = (String) enumm.nextElement(); 
			try {
				str = new String(((String) props.get(key)).getBytes("ISO-8859-1"), "UTF-8");
				s = str.split("/"); 

				menuprice.add(s[3]);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return menuprice;
	}
	
	public void filestart () {

		try(BufferedInputStream bfs = new BufferedInputStream(new FileInputStream("menu.properties"))) {
			props.load(bfs);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void filesave() //파일 저장
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("menu.properties")))
		{
			oos.writeObject(props);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public MenuManageControl () {

		 filestart();
	}




}

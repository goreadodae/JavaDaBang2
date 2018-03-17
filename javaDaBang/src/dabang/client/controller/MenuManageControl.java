package dabang.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JLabel;

import dabang.client.model.MenuManage;

public class MenuManageControl {

	HashMap <String,MenuManage> adminmenu = new HashMap<String,MenuManage>();
	ArrayList<String> menuname = new ArrayList<String>();
	ArrayList<String> menuprice = new ArrayList<String>();


	public boolean menuPlus(MenuManage menuInsert) { //메뉴추가
		if(adminmenu.containsKey(menuInsert.getMenuname())) {
			return false;
		}else {
			adminmenu.put(menuInsert.getMenuname(),menuInsert);
			return true;
		}
	}


	public boolean menumodify(MenuManage modifymenu) { //메뉴수정
		if(adminmenu.containsKey(modifymenu.getMenuname())){
			adminmenu.put(modifymenu.getMenuname(), modifymenu);
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

	
/*	public  ArrayList<String> selectAll()   {  //출력
	      Iterator<String> iter = adminmenu.keySet().iterator();
	      while(iter.hasNext()) 
	      {
	    	  menuAllLabel.add(adminmenu.get(iter.next()).toString());
	      }
	      
	      return menuAllLabel;
	   }*/
	
	public  ArrayList<String> arraytmenuname()   {  //메뉴명출력
	      Iterator<String> iter = adminmenu.keySet().iterator();
	      while(iter.hasNext()) 
	      {
	    	  menuname.add(adminmenu.get(iter.next()).getMenuname());
	      }
	      
	      return menuname;
	   }
	
	public  ArrayList<String> arraytmenuprice()   {  //가격출력
	      Iterator<String> iter = adminmenu.keySet().iterator();
	      while(iter.hasNext()) 
	      {
	    	  menuprice.add(Integer.toString(adminmenu.get(iter.next()).getMenuprice()));
	      }
	      
	      return menuprice;
	   }



}

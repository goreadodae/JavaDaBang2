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


	public boolean menuPlus(MenuManage menuInsert) { //�޴��߰�
		if(adminmenu.containsKey(menuInsert.getMenuname())) {
			return false;
		}else {
			adminmenu.put(menuInsert.getMenuname(),menuInsert);
			return true;
		}
	}


	public boolean menumodify(MenuManage modifymenu) { //�޴�����
		if(adminmenu.containsKey(modifymenu.getMenuname())){
			adminmenu.put(modifymenu.getMenuname(), modifymenu);
			return true;			
		}
		else{return false;}
	}

	public boolean menuDelete(String deletemenuname) { //�޴�����
		if(adminmenu.containsKey(deletemenuname)) {
			adminmenu.remove(deletemenuname);
			return true;
		}
		else{return false;}
	}

	
/*	public  ArrayList<String> selectAll()   {  //���
	      Iterator<String> iter = adminmenu.keySet().iterator();
	      while(iter.hasNext()) 
	      {
	    	  menuAllLabel.add(adminmenu.get(iter.next()).toString());
	      }
	      
	      return menuAllLabel;
	   }*/
	
	public  ArrayList<String> arraytmenuname()   {  //�޴������
	      Iterator<String> iter = adminmenu.keySet().iterator();
	      while(iter.hasNext()) 
	      {
	    	  menuname.add(adminmenu.get(iter.next()).getMenuname());
	      }
	      
	      return menuname;
	   }
	
	public  ArrayList<String> arraytmenuprice()   {  //�������
	      Iterator<String> iter = adminmenu.keySet().iterator();
	      while(iter.hasNext()) 
	      {
	    	  menuprice.add(Integer.toString(adminmenu.get(iter.next()).getMenuprice()));
	      }
	      
	      return menuprice;
	   }



}

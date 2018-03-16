package dabang.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JLabel;

import dabang.client.model.MenuManage;

//
public class MenuManageControl {

	//ArrayList<MenuManage> al = new ArrayList<MenuManage>();
	HashMap <String,MenuManage> adminmenu = new HashMap<String,MenuManage>();
	ArrayList<String> menuAllLabel = new ArrayList<String>();


	public boolean menuPlus(MenuManage m) { //메뉴추가
		if(adminmenu.containsKey(m.getMenuname())) {
			return false;
		}else {
			adminmenu.put(m.getMenuname(),m);
			return true;
		}
	}

	/*public int searchIndex(String name) {

		for(int i=0;i<al.size();i++) {
			if(al.get(i).getMenuname().equals(name)) {
				return i;
			}
		}
		return -1;
	}*/

	public boolean menuUpdate(MenuManage m) { //메뉴수정
		if(adminmenu.containsKey(m.getMenuname())){
			adminmenu.put(m.getMenuname(), m);
			return true;			
		}
		else{return false;}
	}

	public boolean menuDelete(String modifymenuname) { //메뉴삭제
		if(adminmenu.containsKey(modifymenuname)) {
			adminmenu.remove(modifymenuname);
			return true;
		}
		else{return false;}
	}

	/*public ArrayList<MenuManage> selectAll() { //메뉴전체출력
		return al;
	}*/
	
	public  ArrayList<String> selectAll()   {  //출력
	      Iterator<String> iter = adminmenu.keySet().iterator();
	      while(iter.hasNext()) 
	      {
	    	  menuAllLabel.add(adminmenu.get(iter.next()).toString());
	      }
	      
	      return menuAllLabel;
	   }

	/*public MenuManage selectOne(int index) { //메뉴하나만보기
		return al.get(index);
	}*/


}

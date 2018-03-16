package dabang.client.controller;

import java.util.ArrayList;

import dabang.admin.model.MenuManage;

public class MenuManageControl {

	ArrayList<MenuManage> al = new ArrayList<MenuManage>();
	
	public boolean menuPlus(MenuManage me) {
		return al.add(me);
	}

	public int searchIndex(String name) {

		for(int i=0;i<al.size();i++) {
			if(al.get(i).getMenuname().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public void menuUpdate(MenuManage m, int index) {
		al.set(index, m);
	}

	public void menuDelete(int index) {
		al.remove(index);
	}
	
	public ArrayList<MenuManage> selectAll() {
		return al;
	}

	public MenuManage selectOne(int index) {
		return al.get(index);
	}


}

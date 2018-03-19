package dabang.client.controller;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import dabang.client.model.Member;
import dabang.client.model.Menu;

public class OrderCon {
	private HashMap<String, ArrayList> orderList = new HashMap<String, ArrayList>();
	private ArrayList<Menu> al = new ArrayList<Menu>();
	public void addOrder(Member accessMember, ArrayList <Menu> ol) {
		if(orderList.isEmpty()) {
			for(int i=0;i<ol.size();i++) {
				al.add(ol.get(i));
			}
		}else {
			if(orderList.containsKey(accessMember.getId())) {
				for(int i=0;i<orderList.get(accessMember.getId()).size();i++) {
					al.add((Menu)orderList.get(accessMember.getId()).get(i));
				}
				for(int i=0;i<ol.size();i++) {
					al.add(ol.get(i));
				}
			}else {
				for(int i=0;i<ol.size();i++) {
					al.add(ol.get(i));
				}
			}
		}
		orderList.put(accessMember.getId(), al);
	}
	public ArrayList selectOrder(String id) {
		return orderList.get(id);
	}
	public HashMap<String, ArrayList> selectAll() {
		return orderList;
	}
	public void saveOrder() {
        // TODO Auto-generated method stub
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("order.txt"))){
            oos.writeObject(orderList);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
 
    public void loadOrder() {
        // TODO Auto-generated method stub
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("order.txt"))){
        	orderList = (HashMap<String, ArrayList>) ois.readObject();
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

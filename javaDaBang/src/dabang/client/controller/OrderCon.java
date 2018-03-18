package dabang.client.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import dabang.client.model.Member;
import dabang.client.model.OrderList;

public class OrderCon {
	private HashMap<String, ArrayList> orderList = new HashMap<String, ArrayList>();
	private ArrayList al = new ArrayList();
	public void addOrder(Member accessMember, ArrayList <OrderList> ol) {
		al.add(ol);
		orderList.put(accessMember.getId(), al);
	}
	public ArrayList selectOrder(String id) {
		return orderList.get(id);
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
        	Iterator<String> it = orderList.keySet().iterator();
    		while(it.hasNext()) {
    			al.add(orderList.get(it.next()));
    		}
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

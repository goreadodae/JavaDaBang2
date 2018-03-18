package dabang.client.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import dabang.client.model.Espresso;
import dabang.client.model.Frappuccino;
import dabang.client.model.Member;
import dabang.client.model.Menu;
import dabang.client.model.MenuOrder;
import dabang.client.model.Tea;
import dabang.client.view.Login;

public class OrderCon {

	private ArrayList<Menu> mn = new ArrayList<Menu>();
	
	
	
	//	private HashMap <String, Member> member = new HashMap<String, Member>();
//	private HashMap <String, MenuDrink> orderDrink= new HashMap <String, MenuDrink>();
//	private HashMap <String, MenuDessert> orderDessert = new HashMap <String, MenuDessert>();
//	private HashSet<String> memberOrder = new HashSet<String>();
	
	
	//CREATE
	public boolean orderMenu(Menu m, String kinOfDrink) { // 주문메뉴  에스프레소, 프라푸치노, 티, 디저트
		
		switch(kinOfDrink) {
		case "에스프레소" : mn.add((Espresso)m);
		case "프라푸치노" : mn.add((Frappuccino)m);
		case "티" : mn.add((Tea)m);
		case "디저트" : mn.add(m);
		}
		return mn.add(m);
	}
	
	//READ
	public void printAll() {
		
//		for(int i = 0; i < mn.size(); i++)
//		{
//			mn.get(i);
//		}
		
		
		Iterator<Menu> iter = mn.iterator();
		
		while(iter.hasNext())
		{
			iter.next();
		}
	}
		
		
		
//		Collections.sort(mn);
//		return mn;
//		Iterator<Menu> iter = mn.iterator();
//		while(iter.hasNext())
//		{
//			Menu str = (Menu)iter.next();
//			
//		}
	
	//UPDATE 주문 갱신
	public boolean orderModify(Menu modifyOrder) {
	}
	
	
	//DELETE 주문삭제
	public boolean orderDelete() {
		MenuOrder Mo = new MenuOrder();
		for(Iterator<Menu> iter = mn.iterator();iter.hasNext();)
		{
			if(mn.contains(Mo.getMenu())) {
				iter.remove();
			}
		}
		return true;
	}
	
	public void saveOrder() { //주문 저장 (기존 + 새로추가)
	
		
		
		
		
		
		
		try {
			String str = mn.toString();
			BufferedWriter bw = new BufferedWriter(new FileWriter("Order.txt"));
			bw.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
//		FileReader fr = null;
//		BufferedReader br = null;
//		int count = 0;
//	
//		try {
//			
//			fr = new FileReader("Order.txt");
//			br = new BufferedReader(fr);
//			String s = null;
//			
//			while((s=br.readLine())!=null) {
//				count++;
//			}
//			
//			for(i = count; i < count+orderCount; i++)
//			{ 
//				
//				
//			
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
		
//		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Order.txt"))){
//			oos.writeObject(Menu);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
	public void loadOrder() { //주문 불러오기
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Order.txt")))
        {
            mn = (ArrayList<Menu>)(ois.readObject());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
		
		
		
		
		
		
		
		
//		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Order.txt"))){
//			try {
//				memberOrder = (HashSet<String>) ois.readObject();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
}

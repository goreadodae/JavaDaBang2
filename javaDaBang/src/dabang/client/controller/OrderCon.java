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
	public boolean orderMenu(Menu m, String kinOfDrink) { // �ֹ��޴�  ����������, ����Ǫġ��, Ƽ, ����Ʈ
		
		switch(kinOfDrink) {
		case "����������" : mn.add((Espresso)m);
		case "����Ǫġ��" : mn.add((Frappuccino)m);
		case "Ƽ" : mn.add((Tea)m);
		case "����Ʈ" : mn.add(m);
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
	
	//UPDATE �ֹ� ����
	public boolean orderModify(Menu modifyOrder) {
	}
	
	
	//DELETE �ֹ�����
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
	
	public void saveOrder() { //�ֹ� ���� (���� + �����߰�)
	
		
		
		
		
		
		
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
	
	
	public void loadOrder() { //�ֹ� �ҷ�����
		
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

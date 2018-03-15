package dabang.admin.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import dabang.admin.model.Stock;

public class StockController {
	private ArrayList<Stock> al = new ArrayList<Stock>();

	public StockController() {}

	public boolean addstock(Stock s) ///�� ����??
	{
		return al.add(s);
	}



	public ArrayList<Stock> viewAll() // ���� �˻��ؼ� 
	{
		Collections.sort(al);
		return al;
	}


	public int searchStock(String name)
	{
		for(int i=0; i<al.size();i++)
		{
			if(al.get(i).getIngredientName().equals(name))
			{
				return i;//�˻��� ����̸��� ã�� �� �ε��� ��ȣ ����
			}

		}
		return -1; //����̸� ã�� ���� �� -1 ����

	}

	public ArrayList<Stock> viewOne()
	{
		return al;

	}


	public void deleteIngredient(int index)
	{
		al.remove(index);
	}

	public void reviseIngredient(Stock s, int index)
	{
		al.set(index, s);
	}


	public void saveIngredient()
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StockMgrData.txt")))
		{
			oos.writeObject(al);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void loadIngredient()
	{
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StockMgrData.txt")))
		{
			al=(ArrayList<Stock>)ois.readObject();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	








}

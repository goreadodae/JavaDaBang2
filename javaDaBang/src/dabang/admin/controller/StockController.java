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

	public boolean addstock(Stock s) ///참 거짓??
	{
		return al.add(s);
	}



	public ArrayList<Stock> viewAll() // 재료명 검색해서 
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
				return i;//검색한 재료이름을 찾을 시 인덱스 번호 리턴
			}

		}
		return -1; //재료이름 찾지 못할 시 -1 리턴

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
			System.out.println("저장이 완료되었습니다.");

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

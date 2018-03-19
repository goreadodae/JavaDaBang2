package dabang.client.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

import dabang.client.model.Stock;

public class StockController {

	private HashMap<Integer,Stock> ingredient = new HashMap<Integer,Stock>();

	private ArrayList<Integer> arrSerialNumber = new ArrayList<Integer>();
	private ArrayList<String> arrIngreName = new ArrayList<String>();
	private ArrayList<Integer> arrIngreUnit = new ArrayList<Integer>();
	private ArrayList<Calendar> arrExpiryDate = new ArrayList<Calendar>();

	private Stock s = new Stock();

	public StockController() {}

	public HashMap<Integer,Stock> selectAll(){
		return ingredient;
	}
	
	public boolean addstock(Stock s) ///�� ����??
	{
		if(ingredient.containsKey(s.getSerialNumber()))
		{
			return false; //�ø����ȣ �ߺ�
		}
		else 
		{
			ingredient.put(s.getSerialNumber(), s);
			return true;
		}
		//ingredient.put(s.getSerialNumber(), s);
		//return true;
	}


	public ArrayList<Integer> transferArrNumber() //�ؽ��ʿ� �ִ� �ø����ȣ�� �迭�� ����
	{
		Iterator<Integer> iter = ingredient.keySet().iterator();
		while(iter.hasNext())
		{
			arrSerialNumber.add(ingredient.get(iter.next()).getSerialNumber());

		}
		return arrSerialNumber;

	}

	public ArrayList<String>  transferArrName() //�ؽ��ʿ� �ִ� ������ �迭�� ����
	{
		Iterator<Integer> iter = ingredient.keySet().iterator();
		while(iter.hasNext())
		{
			arrIngreName.add(ingredient.get(iter.next()).getIngredientName());
		}
		return arrIngreName;

	}

	public ArrayList<Integer> transferArrUnit() //�ؽ��ʿ� �ִ� ��� ���� �迭�� ����
	{
		Iterator<Integer> iter  = ingredient.keySet().iterator();
		while(iter.hasNext())
		{
			arrIngreUnit.add(ingredient.get(iter.next()).getQuantity());
		}
		return arrIngreUnit;

	}

	public ArrayList<Calendar> transferArrExpiryDate() //�ؽ��ʿ� �ִ� ��������� �迭�� ����
	{
		Iterator<Integer> iter = ingredient.keySet().iterator();
		while(iter.hasNext())
		{
			arrExpiryDate.add(ingredient.get(iter.next()).getExpiryDate());
		}
		return arrExpiryDate;
	}

	public void viewAll() //��� 
	{
		Iterator<Integer> iter = ingredient.keySet().iterator();
		while(iter.hasNext()) 
		{
			System.out.println(ingredient.get(iter.next()).toString());
		}
	}


	public boolean searchStock(int serialNumber) //�ø����ߺ�Ȯ��
	{
		//loadIngredient();
		return ingredient.containsKey(serialNumber);



	}

	public boolean deleteIngredient(int serialNumber) //������ ���
	{
		if(ingredient.containsKey(serialNumber))
		{
			ingredient.remove(serialNumber);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean reviseIngredient(Stock s) //��� ����
	{
		if(ingredient.containsKey(s.getSerialNumber()))
		{
			ingredient.put(s.getSerialNumber(), s);
			return true;
		}
		else {
			return false;
		}
	}


	public void saveIngredient() //���� ����
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StockMgrData.txt")))
		{
			oos.writeObject(ingredient);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void loadIngredient() //�ҷ�����
	{
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StockMgrData.txt")))
		{
			ingredient=(HashMap<Integer,Stock>)ois.readObject();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public Calendar insertExpiryDate(int year, int month, int day)
	{
		Calendar expiryDate = Calendar.getInstance();
		expiryDate.set(year, month, day);
		return expiryDate;

	}


	//���� ����
	/*public int expriyDateCheck(Stock s)//������
	{

		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy�� MM�� dd��");
		Calendar c = Calendar.getInstance();
		Calendar cToday = c;

		System.out.println("���� ��¥: "+ft.format(date));

		c.set(s.getExpiryDate().)
		long gap = (cToday.getTimeInMillis()- c.getTimeInMillis())/ (60*60*24*1000);
		System.out.println(gap);

		return 0;
		/*Calendar currentDate = Calendar.getInstance();
		currentDate.set(Calendar.YEAR,Calendar.MONTH,Calendar.DATE);
		System.out.println(currentDate);
		System.out.println(s.getExpiryDate().getTimeInMillis()/1000);
	 */
	//long result = currentDate.getTimeInMillis()/1000 - s.getExpiryDate().getTimeInMillis()/1000;
	/*int date = (int)(result/(1*60*60*24));

		if(date<0)
		{
			return 1; //��������� �������� 1����
		}
		else if(date>0)
		{
			return -1;//��������� ��������
		}
		return 0; //��������� ���ó�¥�϶�*/

}
//public 

//public void print() {

//for(int i=0;i<();i) {
//int check = expriyDateCheck(al.get(i));
//}


//}


































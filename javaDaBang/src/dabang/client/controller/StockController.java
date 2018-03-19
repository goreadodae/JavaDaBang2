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
	
	public boolean addstock(Stock s) ///참 거짓??
	{
		if(ingredient.containsKey(s.getSerialNumber()))
		{
			return false; //시리얼번호 중복
		}
		else 
		{
			ingredient.put(s.getSerialNumber(), s);
			return true;
		}
		//ingredient.put(s.getSerialNumber(), s);
		//return true;
	}


	public ArrayList<Integer> transferArrNumber() //해쉬맵에 있는 시리얼번호를 배열에 저장
	{
		Iterator<Integer> iter = ingredient.keySet().iterator();
		while(iter.hasNext())
		{
			arrSerialNumber.add(ingredient.get(iter.next()).getSerialNumber());

		}
		return arrSerialNumber;

	}

	public ArrayList<String>  transferArrName() //해쉬맵에 있는 재료명을 배열로 저장
	{
		Iterator<Integer> iter = ingredient.keySet().iterator();
		while(iter.hasNext())
		{
			arrIngreName.add(ingredient.get(iter.next()).getIngredientName());
		}
		return arrIngreName;

	}

	public ArrayList<Integer> transferArrUnit() //해쉬맵에 있는 재료 수를 배열로 저장
	{
		Iterator<Integer> iter  = ingredient.keySet().iterator();
		while(iter.hasNext())
		{
			arrIngreUnit.add(ingredient.get(iter.next()).getQuantity());
		}
		return arrIngreUnit;

	}

	public ArrayList<Calendar> transferArrExpiryDate() //해쉬맵에 있는 유통기한을 배열로 저장
	{
		Iterator<Integer> iter = ingredient.keySet().iterator();
		while(iter.hasNext())
		{
			arrExpiryDate.add(ingredient.get(iter.next()).getExpiryDate());
		}
		return arrExpiryDate;
	}

	public void viewAll() //출력 
	{
		Iterator<Integer> iter = ingredient.keySet().iterator();
		while(iter.hasNext()) 
		{
			System.out.println(ingredient.get(iter.next()).toString());
		}
	}


	public boolean searchStock(int serialNumber) //시리얼중복확인
	{
		//loadIngredient();
		return ingredient.containsKey(serialNumber);



	}

	public boolean deleteIngredient(int serialNumber) //재료삭제 기능
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

	public boolean reviseIngredient(Stock s) //재료 수정
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


	public void saveIngredient() //파일 저장
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StockMgrData.txt")))
		{
			oos.writeObject(ingredient);
			System.out.println("저장이 완료되었습니다.");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void loadIngredient() //불러오기
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


	//수정 수정
	/*public int expriyDateCheck(Stock s)//수정중
	{

		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy년 MM월 dd일");
		Calendar c = Calendar.getInstance();
		Calendar cToday = c;

		System.out.println("오늘 날짜: "+ft.format(date));

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
			return 1; //유통기한이 남았을때 1리턴
		}
		else if(date>0)
		{
			return -1;//유통기한이 지났을때
		}
		return 0; //유통기한이 오늘날짜일때*/

}
//public 

//public void print() {

//for(int i=0;i<();i) {
//int check = expriyDateCheck(al.get(i));
//}


//}


































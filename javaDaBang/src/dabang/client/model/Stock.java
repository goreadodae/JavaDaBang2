package dabang.client.model;

import java.io.Serializable;
import java.util.Calendar;

public class Stock implements Comparable<Object>,Serializable{

	private static final long serialVersionUID = 100200L;

	private int serialNumber; //바코드
	private String ingredientName;  //재료(디저트,원두)의 이름 
	private int  quantity; //수량
	private Calendar expiryDate = null;
	
	


	public Stock() {}

	public Stock(int serialNumber, String ingredientName, int quantity, Calendar expiryDate)
	{	
		this.serialNumber= serialNumber;
		this.ingredientName = ingredientName;
		this.quantity = quantity;
		this.expiryDate = expiryDate;
		
	}

	public String getIngredientName() 
	{
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) 
	{
		this.ingredientName = ingredientName;
	}

	public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	
	public void setExpiryDate(Calendar expiryDate)
	{
		this.expiryDate = expiryDate;
	}
	
	public Calendar getExpiryDate()
	{
		return this.expiryDate;
	}
	
	
	public int getSerialNumber() 
	{
		return serialNumber;
	}
	
	public void setSerialNumber(int serialNumber) 
	{
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() 
	{	
		return  serialNumber +"\t\t\t"+
				ingredientName +"\t\t\t" 
				+ quantity + "개\t\t\t" +  
				expiryDate.get(Calendar.YEAR)+"년"+ 
				expiryDate.get(Calendar.MONTH )+"월"+	
				expiryDate.get(Calendar.DATE) +"일"+"\t\t\t" ;
	}

	@Override
	public int compareTo(Object o) 
	{	
		return this.ingredientName.charAt(0) - ((Stock)o).getIngredientName().charAt(0);
		//이름정렬 (가,나,다 순)
	}









}

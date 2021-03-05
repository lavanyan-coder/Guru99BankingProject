package com.guru99banking.util;

import java.util.ArrayList;

import com.guru99banking.base.*;
import com.guru99banking.base.com.Base;;

public class GetExcelData extends Base {

	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try 
		{
		reader = new Xls_Reader("C:\\Users\\DELL\\eclipse-workspace\\"
				+ "Guru99BankingProject\\src\\test\\java\\com\\guru99banking\\data\\Login_Credentials.xlsx");
		
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		for(int rowNum = 2; rowNum<reader.getRowCount("Sheet1");rowNum++)
		{
			String userName = reader.getCellData("Sheet1", "username", rowNum);
			String passWord = reader.getCellData("Sheet1", "password", rowNum);
			
			Object [] ob = {userName,passWord};
			myData.add(ob) ;
		}
		
	return myData;
	}
	
}

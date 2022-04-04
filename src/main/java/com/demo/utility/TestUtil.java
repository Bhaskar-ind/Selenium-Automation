package com.demo.utility;

import java.util.ArrayList;

import com.demo.excel.utility.Xls_Reader;

public class TestUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		ArrayList<Object[]> myData = new ArrayList<>();
		try {
		reader = new Xls_Reader(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx");
		} catch(Exception e){
			e.printStackTrace();
		}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("LoginData");rowNum++) {
			
			String username = reader.getCellData("LoginData", "Username", rowNum);
			String password = reader.getCellData("LoginData", "Password", rowNum);
			
			Object ob[]= {username,password};
			myData.add(ob);
		}
			
		return myData;
	}

	
	
	public static ArrayList<Object[]> getCredDataFromExcel(){
		ArrayList<Object[]> myCredData = new ArrayList<>();
		try {
		reader = new Xls_Reader(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx");
		} catch(Exception e){
			e.printStackTrace();
		}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("Credentials");rowNum++) {
			
			String firstname = reader.getCellData("Credentials", "firstname", rowNum);
			String lastname = reader.getCellData("Credentials", "lastname", rowNum);
			String postalcode = reader.getCellData("Credentials", "postalcode", rowNum);
			
			Object obb[]= {firstname,lastname,postalcode};
			myCredData.add(obb);
		}
			
		return myCredData;
	}

}

package com.demo.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.demo.utility.TestUtil;



public class DataProviders {
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestCredData(){
		ArrayList<Object[]> testCredData = TestUtil.getCredDataFromExcel();
		return testCredData.iterator();
		
	}
	

}

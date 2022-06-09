package dataprovider;

import org.testng.annotations.DataProvider;

import testdata.Excelsheet;

public class Dataproviderclass {

	@DataProvider
	public Object[][] Details(){
	Object result [][]=Excelsheet.readdata("Create Account");
	return result;
	}
	@DataProvider
	public Object[][] Details1(){
	Object result [][]=Excelsheet.readdata("Login");
	return result;
	}
	
	@DataProvider
	public Object[][] Details2(){
		Object result[][]= Excelsheet.readdata("Your Address");
		return result;
	}
	@DataProvider
	public Object[][] Details3(){
		return new Object[][] {{"adidas"},{"adidas shoes"},{"B07RHZSW8Y"},{"shoes"},{"adid"},{"shoe"}};
	}
}

package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseamazonclass.BaseClass;
import pompackage.LoginPOM;
import pompackage.YourAccountPOM;

public class YourAccountTest extends BaseClass{
LoginPOM pom;
YourAccountPOM log;
	public YourAccountTest() {
		super();
	}
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		BaseClass.initiation();
		BaseClass.login();
		pom= new LoginPOM();
		log = new YourAccountPOM();
	}
	@Test(priority=1)
	public void Yaccount() {
		pom.loggedin();
		log.mousehover();
	
	}
	@Test(priority=2)
	public void account() {
		pom.loggedin();
		log.click();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}

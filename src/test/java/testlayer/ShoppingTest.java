package testlayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseamazonclass.BaseClass;
import pompackage.SearchPOM;
import pompackage.ShoppingPOM;

public class ShoppingTest extends BaseClass {
	ShoppingPOM pom;
	public ShoppingTest() {
		super();
	}
	
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		BaseClass.initiation();
		BaseClass.login();
	pom= new ShoppingPOM();
}
	@Test(priority=1)
	public void search() {
		pom.search("alchemist");
		pom.alclick();
		pom.add();
		pom.clickc();
		pom.clickk();
	}
	@Test(priority=2)
	public void  cart() throws Exception {
		pom.clickc();
		pom.clickk();
		pom.quantity();
		pom.search("rado");
		pom.clickr();
		pom.add();
		pom.clickc();
		pom.verify();
		pom.deleterado();
		pom.deleteall();
	

	}
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
	}

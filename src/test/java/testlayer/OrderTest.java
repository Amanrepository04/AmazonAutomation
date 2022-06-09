package testlayer;


	import org.openqa.selenium.By;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

import baseamazonclass.BaseClass;
import pompackage.OrderPOM;



	public class OrderTest  extends BaseClass {
		OrderPOM pom;
		public OrderTest() {
		super();
		}

		@BeforeMethod
		public void openbrowser() throws InterruptedException {
			BaseClass.initiation();
			BaseClass.login();
			pom= new OrderPOM();
			pom.Obutton();
	}
		
		@Test(priority=1)
		public void order() throws InterruptedException {
		pom.History1();
		pom.History2();
		pom.History3();
		}
		
		@Test(priority=2)
		public void order1() throws InterruptedException {
			pom.BuyaOrders();
			pom.NYSOrders();
			pom.CancelledO();
		}
		
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
		
		
	}


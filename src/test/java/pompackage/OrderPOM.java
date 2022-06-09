package pompackage;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;

import baseamazonclass.BaseClass;

	

	public class OrderPOM  extends BaseClass {
		
		@FindBy(xpath="//span[contains(text(),'Your Orders')]") WebElement Orderbtn;
		@FindBy(name="orderFilter") WebElement Orderdd;
		@FindBy(xpath="//span[@id='a-autoid-1-announce']//span")WebElement History;
		@FindBy(xpath="//div[@class='a-section a-spacing-top-medium a-text-center']") WebElement order;
		@FindBy(linkText="Buy Again") WebElement BuyAgain;
		@FindBy(linkText="Not Yet Shipped") WebElement Notyetshipped;
		@FindBy(linkText="Cancelled Orders") WebElement Cancelled;
		@FindBy (xpath="//div[@class='a-section a-spacing-none a-spacing-top-small a-padding-base a-text-center']") WebElement Buy;
		////div[@class='a-section a-spacing-none a-spacing-top-small a-padding-base a-text-center']
		@FindBy(xpath="//div[@class='a-section a-spacing-top-medium a-text-center']") WebElement shipped;
		
		public OrderPOM() {
			PageFactory.initElements(driver, this);
		}
		public void Obutton() {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath(prop.getProperty("Hello")))).build().perform();
			Orderbtn.click();
		}
		public void History1() throws InterruptedException{
			Select obj=new Select(Orderdd);
			obj.selectByVisibleText("the past 30 days");
			String actualresult = History.getText();
			System.out.println(actualresult);
			String expectedresult = "the past 30 days";
			Assert.assertEquals(actualresult, expectedresult);
			
			Thread.sleep(2000);		
			String actual= order.getText();
			if(actual.contains("ORDER PLACED")) {
			Assert.assertTrue(actual.contains("ORDER PLACED"));
			System.out.println(actual);
			}
			else {
				String orders=order.getText();
				System.out.println(orders);
			}

			
		}
		
		public void History2() throws InterruptedException{
			Select obj=new Select(Orderdd);
			obj.selectByVisibleText("past 3 months");
			String actualresult1=History.getText();
			System.out.println(actualresult1);
			String expectedresult1 = "past 3 months";
			Assert.assertEquals(actualresult1, expectedresult1);
			Thread.sleep(2000);	
			String actual= order.getText();
			if(actual.contains("ORDER PLACED")) {
			Assert.assertTrue(actual.contains("ORDER PLACED"));
			System.out.println(actual);
			}
			else {
				String orders=order.getText();
				System.out.println(orders);
			}
		}
		
		public void History3() throws InterruptedException{
			Select obj=new Select(Orderdd);
			obj.selectByVisibleText("2022");
			String actualresult2=History.getText();
			System.out.println(actualresult2);
			String expectedresult2="2022";
			Assert.assertEquals(actualresult2, expectedresult2);
			Thread.sleep(2000);
			String actual= order.getText();
			if(actual.contains("ORDER PLACED")) {
			Assert.assertTrue(actual.contains("ORDER PLACED"));
			System.out.println(actual);
			}
			else {
				String orders=order.getText();
				System.out.println(orders);
			}}
		
			public void BuyaOrders() throws InterruptedException {
				Thread.sleep(5000);
				boolean verifybutton= BuyAgain.isDisplayed();
				String abc= BuyAgain.getText();
				System.out.println(abc);
				BuyAgain.click();	
				Thread.sleep(2000);
				String actual= Buy.getText();
				if(actual.contains("Buy it again")) {
				Assert.assertTrue(actual.contains("Buy it again"));
				System.out.println(actual);
				}
				else {
					System.out.println(actual);
				}}
			public void NYSOrders() throws InterruptedException {
				boolean verifybutton= Notyetshipped.isDisplayed();
				String abc= Notyetshipped.getText();
				System.out.println(abc);
				Notyetshipped.click();	
				Thread.sleep(2000);
				String actual= shipped.getText();
				if(actual.contains("Arriving")) {
				Assert.assertTrue(actual.contains("Arriving"));
				System.out.println(actual);
				}
				else {
					System.out.println(actual);
				}}

			
			public void CancelledO() throws InterruptedException {
				boolean verifybutton= Cancelled.isDisplayed();
				String abc= Cancelled.getText();
				System.out.println(abc);
				Cancelled.click();	
				Thread.sleep(2000);
				String actual= shipped.getText();
				if(actual.contains("Cancelled")) {
				Assert.assertTrue(actual.contains("Cancelled"));
				System.out.println(actual);
				}
				else {
					System.out.println(actual);
				}}

			

	}


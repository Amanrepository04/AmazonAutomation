package testlayer;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseamazonclass.BaseClass;
import pompackage.Login_Security;
import pompackage.YourPaymentPOM;

public class SecurityTest extends BaseClass {
	YourPaymentPOM pom;
	Login_Security log;
	public SecurityTest() {
		super();
	}
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		BaseClass.initiation();
		BaseClass.login();
		pom= new YourPaymentPOM();
		pom.Click1();
	log= new Login_Security();
	log.loginn();
}
@Test(priority=3)
public void name() {
	log.updatename();
	log.typename("Kitty");
	log.Clickb();
	
}
@Test(priority=2)
public void phone() throws InterruptedException {
	log.addphone();
	log.Typephone("6473321010");
	log.Clickbutton();
	Thread.sleep(2000);
	//driver.switchTo().frame(0);
	//driver.switchTo().frame(driver.findElement(By.id("a-popover-content-1")));
	Thread.sleep(5000);
	log.framep();
}	

	@Test(priority=1)
	public void delete() throws InterruptedException {
	log.deletemobile();
	log.deletebutton();
	Thread.sleep(5000);
	log.confirmdelete();
	log.verify();
}
	
@AfterMethod
public void closebrowser() {
	driver.close();
}
}



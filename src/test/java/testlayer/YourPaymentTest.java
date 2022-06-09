package testlayer;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseamazonclass.BaseClass;
import pompackage.YourPaymentPOM;
import utilities.TimeUtils;

public class YourPaymentTest extends BaseClass {
YourPaymentPOM pom;
	public YourPaymentTest() {
		super();
	}
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		BaseClass.initiation();
		BaseClass.login();
		pom= new YourPaymentPOM();
		pom.Click1();
}
@Test(priority=1)
public void verifybutton() {
	pom.assert_();
	pom.Addpayment1();
	pom.asserturl();
}

@Test(priority=2)
public void addcard() throws InterruptedException {
	pom.Addpayment1();
	pom.Addpayment2();
	pom.Addpayment3();
	Thread.sleep(2000);
	driver.switchTo().frame(0);
	pom.Typecardno(prop.getProperty("cardno"));
	pom.Typename(prop.getProperty("name"));
	pom.date();
	pom.Year();
	pom.acard();
	//pom.typeaddress(prop.getProperty("address"));
	//pom.typecity(prop.getProperty("city"));
	//pom.typeprovince(prop.getProperty("province"));
	//pom.typepostal(prop.getProperty("postal"));
	//pom.typephone(prop.getProperty("phone"));
	pom.uaddress();
	//pom.suggest();
	
	pom.SEvent();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	pom.Assert1();
	pom.Assert2();
	
}
@Test(priority=3)
public void Default() throws InterruptedException {
	pom.Addpayment1();
	pom.settings();
	pom.preference();
	pom.change();
	Thread.sleep(5000);
	pom.radiobutton();
	pom.continuebutton();
	Thread.sleep(2000);
	pom.wallet();
	pom.Assert3();
}
@AfterMethod
public void close() {
	driver.close();
}

}

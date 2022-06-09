package testlayer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseamazonclass.BaseClass;
import pompackage.PaymentPOM;

public class PaymentTest extends BaseClass {
	PaymentPOM pom;
public PaymentTest() {
	super();
}
@BeforeMethod
public void initiatem() throws InterruptedException {
	BaseClass.initiation();
	BaseClass.login();
pom= new PaymentPOM();
}

@Test(priority=1)
public void search() throws InterruptedException {
	pom.search("alchemist");
	pom.al();
	pom.add();
	pom.check();
	pom.assert1();
	pom.ship();
	pom.shipfee();	
}

@Test(priority=2)
public void Search2() throws InterruptedException {
pom.search("alexa");	
pom.Rado();
pom.add();
pom.check();
pom.shipfree();
pom.clickc();
pom.use();
Thread.sleep(5000);
pom.verifyerror();
}


}


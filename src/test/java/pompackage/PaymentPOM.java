package pompackage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseamazonclass.BaseClass;

public class PaymentPOM extends BaseClass {
	
	@FindBy(id="twotabsearchtextbox") WebElement Search;
	@FindBy(id="nav-search-submit-button") WebElement submit; // Optional
	@FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='The Alchemist']") WebElement Alchemist;
	@FindBy(name="submit.add-to-cart") WebElement addtocart;
	@FindBy(id="nav-cart") WebElement cart;
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'Echo Dot (3rd gen) - Smart speaker with Alexa - Ch')]") WebElement rado;
	@FindBy(name="proceedToRetailCheckout") WebElement checkout; // click
	//Place Your Order - Amazon.ca Checkout
	@FindBy (id="payment-information") WebElement paymentc;

	// document.querySelector("input[title='FREE Shipping']") JS
	@FindBy (linkText="How are shipping costs calculated?") WebElement How;
	// handle window
	@FindBy(linkText="Order with Free Shipping by Amazon") WebElement info;
	@FindBy (xpath="//span[contains(text(),' Order of $35 or more of eligible items qualify for FREE Shipping.')]") WebElement gettext;
	// go to default window
	@FindBy(xpath="//td[normalize-space()='$4.98']") WebElement shippingcharge;
	// Another test, add alchemist
	@FindBy (xpath="//body/div[@id='checkoutDisplayPage']/div[@id='spc-desktop']/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]") WebElement shippingfree;
	@FindBy (xpath="//body/div[@id='checkoutDisplayPage']/div[@id='spc-desktop']/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]") WebElement Change;
	@FindBy (xpath="/html[1]/body[1]/div[8]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[5]/span[2]/span[1]/a[1]") WebElement useaddress;
	@FindBy (xpath="//p[contains(text(),'The Alchemist cannot be shipped to the selected ad')]") WebElement error;
	@FindBy (name="addressID.destinationType.destinationId.destinationOwnerId.1-1") WebElement selection;
	//Test, 8590 Airport Road Suite 1, Brampton
	@FindBy (name="continue-bottom") WebElement Continue;
	@FindBy (xpath="//body/div[@id='checkoutDisplayPage']/div[@id='spc-desktop']/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/fieldset[1]/div[2]/input[1]") WebElement radio;


	
public PaymentPOM() {
	PageFactory.initElements(driver, this);
}

	public void search(String name) {
		Search.sendKeys(name);
		submit.click();	
	}
		public void al() {
		Alchemist.click();
	}
	public void add() {
		addtocart.click();
		cart.click();
	}
public void check() {
	checkout.click();
	String actual=driver.getTitle();
	Assert.assertEquals(actual, "Place Your Order - Amazon.ca Checkout");
	System.out.println(actual);
}
public void assert1() {
	String actual=paymentc.getText();
	Assert.assertEquals(actual, "ending in 8769");
	System.out.println(actual);
}
public void ship() throws InterruptedException {
	How.click();
	String parentHandle = driver.getWindowHandle();//It will return current window handles in string
	System.out.println("parent window - "+parentHandle);
	//Open new window
	Set<String> handles = driver.getWindowHandles();// It will return both the window handles in set of string(unique values only)
	for(String handle : handles) {
	System.out.println(handle);
	Thread.sleep(5000);
	if(!handle.equals(parentHandle)) {
		driver.switchTo().window(handle);
	info.click();
	String actual = gettext.getText();
	Assert.assertEquals(actual, "Order of $35 or more of eligible items qualify for FREE Shipping.");
	System.out.println(actual);
	driver.close();
	}
	}
	driver.switchTo().window(parentHandle);
	//--------------------go to default window--------------------
// parent window - CDwindow-704BDE9A74C18129966269B004ED9E46
	//CDwindow-704BDE9A74C18129966269B004ED9E46
	}

public void shipfee() {
	String actual = shippingcharge.getText();
	Assert.assertEquals(actual, "$4.98");
	System.out.println(actual);
}
public void Rado() {
	rado.click();
}
public void shipfree() {
	radio.click();
	String actual = shippingfree.getText();
	System.out.println(actual);
}
public void clickc() {
	Change.click();
}
public void use() {
	useaddress.click();
}
public void verifyerror() {
	String actual =error.getText();
	Assert.assertEquals(actual, "The Alchemist cannot be shipped to the selected address.");
	System.out.println(actual);
}


}


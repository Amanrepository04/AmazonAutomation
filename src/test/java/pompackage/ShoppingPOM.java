package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseamazonclass.BaseClass;

public class ShoppingPOM extends BaseClass{

	
	//@FindBy(linkText="Women's Stainless Steel Swiss Quartz Dress Watch with Ceramic Strap, Multicolor, 18 (Model: R30934712)") WebElement Rado;
	
	//alchemist
	@FindBy(id="twotabsearchtextbox") WebElement Search;
	@FindBy(id="nav-search-submit-button") WebElement submit; 
	@FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='The Alchemist']") WebElement Alchemist;
@FindBy(name="submit.add-to-cart") WebElement addtocart;


// Amazon.ca Shopping Cart 
@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']") WebElement added; // gettext
@FindBy(id="nav-cart") WebElement cart;
@FindBy(xpath="//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-mini sc-info-block']") WebElement info; // isdisplayed
@FindBy (name="quantity") WebElement selectbox;
@FindBy (xpath="//div[@class='a-row a-spacing-mini sc-subtotal sc-subtotal-activecart sc-java-remote-feature']") WebElement gettext; 
// do twice
// gettext for selectbox
// search adidas
@FindBy (xpath="//span[@class='a-truncate-cut'][normalize-space()='The Alchemist']") WebElement gettext2;
@FindBy(xpath="//span[normalize-space()='Golden Horse Swiss Automatic Watch with Stainless Steel Strap, Silver, 21 (Model: R33930313)']") WebElement rado;
@FindBy(xpath="//body/div[@id='a-page']/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]") WebElement display2;
@FindBy(xpath="//input[@value='Delete'and@aria-label='Delete Rado Golden Horse Swiss Automatic Watch with Stainless Steel Strap, Silver, 21 (Model: R33930313)']") WebElement delete;
// gettext
// delete
@FindBy(xpath="//input[@value='Delete'and@aria-label='Delete The Alchemist']") WebElement delete1;
@FindBy(xpath="//h1[@class='a-spacing-mini a-spacing-top-base']") WebElement cartempty; // gettext
// gettext

public ShoppingPOM() {
	PageFactory.initElements(driver, this);
}

public void search(String name) {
	Search.sendKeys(name);
	submit.click();	;
}

public void alclick() {
	Alchemist.click();
}

public void add() {
	addtocart.click();
	String actual=driver.getTitle();
	Assert.assertEquals(actual, "Amazon.ca Shopping Cart");
	System.out.println(actual);
	 String Actualtext = added.getText();
	  Assert.assertEquals(Actualtext, "Added to Cart");
	  System.out.println(Actualtext);
}
public void clickc() {
	cart.click();
}
////// another test
// repeat clickc
public void clickk() {
	String actual = gettext2.getText();
	Assert.assertTrue(actual.contains("The Alchemist"));
	System.out.println(actual);
}
public void quantity() throws InterruptedException {
Select obj=new Select(selectbox);
obj.selectByVisibleText("2");
Thread.sleep(5000);
String actual= gettext.getText();
Assert.assertTrue(actual.contains("Subtotal (2 items): $41.58"));
System.out.println(actual);
}
// repeart search rado
public void clickr() {
	rado.click();
	// repeat click and addc
}
public void verify() {
	String actual = gettext.getText();
	Assert.assertTrue(actual.contains("Subtotal (3 items): $2,341.58"));
	System.out.println(actual);
}
public void deleterado() {
	delete.click();
	String actual= gettext.getText();
	Assert.assertTrue(actual.contains("Subtotal (2 items): $41.58"));
	System.out.println(actual);
}
public void deleteall() {
	delete1.click();
	String actual= gettext.getText();
	Assert.assertTrue(actual.contains("Subtotal (0 items):"));
	System.out.println(actual);
	boolean result = cartempty.isDisplayed();
	System.out.println(cartempty.getText());
	
}
}

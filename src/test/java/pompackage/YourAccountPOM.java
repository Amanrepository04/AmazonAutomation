package pompackage;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseamazonclass.BaseClass;


public class YourAccountPOM extends BaseClass{

	@FindBy(id="nav-link-accountList") WebElement Hellooreo;
	@FindBy(xpath="//span[contains(text(),'Your Account')]") WebElement Youraccount;
	@FindBy(xpath="//h1[contains(text(),'Your Account')]") WebElement Account;

	
	public YourAccountPOM() {
		PageFactory.initElements(driver, this);
	}
	
	public void mousehover() {
		Actions action= new Actions(driver);
		action.moveToElement(Hellooreo).build().perform();
		Youraccount.click();
		String actual=Account.getText();
		String expected = "Your Account";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	}
	public void click() {
		Hellooreo.click();
		String actual=Account.getText();
		String expected = "Your Account";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
}

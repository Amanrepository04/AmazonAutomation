package pompackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseamazonclass.BaseClass;

public class Login_Security extends BaseClass {


	@FindBy (xpath="//h2[contains(text(),'Login & security')]") WebElement Login; // is displayed
	@FindBy(xpath="//div[normalize-space()='Oreo']")  WebElement oreo;
	//@FindBy(xpath="//div[@class='a-fixed-right-grid']//div[@class='a-row'and@xpath='1']") WebElement oreo;
	@FindBy (xpath="//input[@id='auth-cnep-edit-name-button']") WebElement Edit;
	@FindBy (name ="customerName") WebElement namebox; // clear // send keys
	@FindBy (xpath="//input[@id='cnep_1C_submit_button']") WebElement button;
	@FindBy (xpath ="//span[contains(text(),'You successfully changed your account!')]") WebElement Success;
	@FindBy (xpath="//div[contains(text(),'Kitty')]") WebElement text;
	@FindBy (xpath="//input[@id='auth-cnep-edit-phone-button']") WebElement button2;
	@FindBy (name="newMobilePhoneNumber") WebElement add; // send keyys
	@FindBy (xpath="//input[@id='auth-continue']") WebElement button3;
	//Frame document.querySelector("#auth-verification-ok-announce")
	@FindBy (css="#auth-verification-ok-announce") WebElement Button4;
	@FindBy (xpath="//h4[contains(text(),'Mobile number already in use')]") WebElement Error;
	@FindBy (xpath="//a[@id='auth-account-conflict-continue-verify-url']") WebElement Yes;
	//@FindBy (xpath="//h1[contains(text(),'Verify mobile number')]") WebElement Verify;// GetText
	// Title Amazon Phone Verification
	//Update
	@FindBy (xpath="//input[@id='auth-cnep-edit-phone-button']") WebElement button5;
	@FindBy (xpath="//button[contains(text(),'Delete')]") WebElement delete;
	@FindBy (name="deleteMobilePhone") WebElement yesdelete;
	@FindBy (xpath="//a[@id='phoneModalLink']") WebElement text2;


public Login_Security() {
	PageFactory.initElements(driver, this);
}


public void loginn() {
	boolean result =Login.isDisplayed();
	System.out.println(result);
	Login.click();
}
public void updatename() {
	//oreo.getText();
	Edit.click();
}

public void typename(String name) {
	namebox.clear();
	namebox.sendKeys(name);
}
public void Clickb() {
	button.click();
	
	String actual= Success.getText();
	String expected= "You successfully changed your account!";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
	String result= text.getText();
	Assert.assertEquals(result, "Kitty");
	System.out.println(result);
}
public void addphone() {
	button2.click();
}
public void Typephone(String number) {
	add.sendKeys(number);
}
public void Clickbutton() {
	button3.click();

}
public void framep() throws InterruptedException {
	Button4.click();
	

		String actual1=driver.getTitle();
		String expected1= "Amazon Phone Verification";
		Assert.assertEquals(actual1, expected1);
		System.out.println(actual1);
	
}
public void deletemobile() throws InterruptedException {
	Thread.sleep(5000);
	button5.click();	
}
public void deletebutton() {
	delete.click();
}

public void confirmdelete() {
	yesdelete.clear();
}
public void verify() {
	Login.click();
	boolean stringg = button2.isDisplayed();
	System.out.println(stringg);
}
}

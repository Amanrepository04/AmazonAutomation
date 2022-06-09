package pompackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseamazonclass.BaseClass;

public class YourPaymentPOM extends BaseClass {

	@FindBy(id="nav-link-accountList") WebElement Hellooreo;
@FindBy(xpath="//h2[contains(text(),'Your Payments')]") WebElement Ypayment;
@FindBy(linkText="Add a payment method") WebElement APMethod; // add payment method
@FindBy(id="apx-add-credit-card-action-test-id") WebElement ACCard; //add credit or debit card
@FindBy(xpath="//input[@type='tel'and@class='a-input-text a-form-normal pmts-account-Number'and@name='addCreditCardNumber']") WebElement CNumber; // card number
@FindBy(xpath="//input[@type='text'and@class='a-input-text a-form-normal apx-add-credit-card-account-holder-name-input'and@name='ppw-accountHolderName']") WebElement Name; // name
@FindBy(name="ppw-expirationDate_month") WebElement DDropdown;
@FindBy(name="ppw-expirationDate_year") WebElement YDropdown;
@FindBy(xpath="//input[@name='ppw-widgetEvent:AddCreditCardEvent']") WebElement ACCEvent;
//5123456789012346 //05,24
////*[@id="pp-be6VhU-15"]
@FindBy(id="pp-5i2VPI-19") WebElement Address;
@FindBy(id="pp-5i2VPI-21") WebElement City;
@FindBy(id="pp-5i2VPI-22") WebElement Province;
@FindBy(id="pp-5i2VPI-23") WebElement Postal;
@FindBy(id="pp-5i2VPI-26") WebElement Phone;
@FindBy(name="ppw-widgetEvent:SelectAddressEvent") WebElement Usethisaddress;
@FindBy(xpath="//input[@name='ppw-widgetEvent:UseSuggestedAddressEvent']") WebElement USAEvent;
@FindBy(name="ppw-widgetEvent:SavePaymentMethodDetailsEvent") WebElement SPMDEvent;
@FindBy(xpath="//span[contains(text(),'Payment method added')]") WebElement Success;
@FindBy(xpath="//body[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[2]/span[1]") WebElement Gettext; //////////get text
@FindBy(xpath="//a[contains(text(),'Settings')]") WebElement Settings;
@FindBy(xpath="//a[contains(text(),'Change Preference')]") WebElement Preference;
@FindBy(xpath="//body/div[@id='a-page']/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/span[2]/input[1]") WebElement Change;
@FindBy(name="ppw-instrumentRowSelection") WebElement radio;
//   document.getElementById('pp-XIqrKT-61')

@FindBy(xpath="//input[@name='ppw-widgetEvent:PreferencePaymentOptionSelectionEvent']") WebElement POption;
@FindBy(xpath="//a[contains(text(),'Wallet')]") WebElement Wallet;
////a[contains(text(),'Wallet')]
@FindBy(xpath="//div[contains(text(),'Default')]") WebElement Card; // gettext
// //body/div[@id='a-page']/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]



public YourPaymentPOM() {
	PageFactory.initElements(driver, this);
}


public void Click1() {
	Hellooreo.click();
}

public void assert_() {
	String actual= Ypayment.getText();
	String expected = "Your Payments";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);	
}
public void Addpayment1() {
	Ypayment.click();
}
public void asserturl() {
	String actual= driver.getCurrentUrl();
	String expected ="https://www.amazon.ca/cpe/yourpayments/wallet?ref_=ya_d_c_pmt_mpo";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);	
}
public void Addpayment2() {
	APMethod.click();
}
public void Addpayment3() {
	ACCard.click();	
}
public void Typecardno(String number) {
	CNumber.click();
	CNumber.sendKeys(number);
}
public void Typename(String name) {
	Name.sendKeys(name);
}
public void date() {
	Select obj=new Select(DDropdown);
	obj.selectByVisibleText("05");
}
public void Year() {
	Select obj1=new Select(YDropdown);
	obj1.selectByVisibleText("2024");
}
public void acard() {
	ACCEvent.click();
}
public void typeaddress(String address) {
	Address.sendKeys(address);
}
public void typecity(String city) {
	City.sendKeys(city);
}
public void typeprovince(String province) {
	Province.sendKeys(province);
}
public void typepostal(String postal) {
	Postal.sendKeys(postal);
}
public void typephone(String phone) {
	Phone.sendKeys(phone);
}

public void uaddress() {
	Usethisaddress.click();
}
public void suggest() {
	USAEvent.click();
}
public void SEvent() {
	SPMDEvent.click();
}
public void Assert1() {
	String actual =Success.getText();
	String expected= "Payment method added";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
}
public void Assert2() {
	String actual= Gettext.getText();
	String expected ="Credit card ending in •••• 2346";
	Assert.assertEquals(actual, expected);
	System.out.println("Mastercard Credit card ending in •••• 2346 successfully added");
}
public void settings() {
	Settings.click();
}
public void preference() {
	Preference.click();
}
public void change() {
	Change.click();
}
public void radiobutton() {
	//JavascriptExecutor js= (JavascriptExecutor) driver;
	//js.executeScript("document.getElementsByName('ppw-widgetEvent:PreferencePaymentOptionSelectionEvent').click()");
	//document.getElementsByName("ppw-widgetEvent:PreferencePaymentOptionSelectionEvent")
	radio.click();
}
public void continuebutton() {
	POption.click();
}
public void wallet() {
	Wallet.click();
}
public void Assert3() {
	String actual = Card.getText();
	Assert.assertEquals(actual, "Default");
	System.out.println(actual);
}
}
package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseamazonclass.BaseClass;

public class GuestPOM extends BaseClass {

	@FindBy(id="twotabsearchtextbox") WebElement Search;
	@FindBy(id="nav-search-submit-button") WebElement submit; // Optional
	@FindBy(xpath="//span[contains(text(),'adidas')]") WebElement assertelement;
	@FindBy(xpath="//img[@alt='adidas Originals Womens Forum Bold Shoes Sneaker']") WebElement image1;
	@FindBy(xpath="//span[contains(text(),'Womens Forum Bold Shoes Sneaker')]") WebElement productname; // click
    @FindBy(xpath="//span[contains(text(),'3.5 out of 5 stars')]") WebElement rating;
    @FindBy(xpath="//span[@class='a-price']//span[contains(text(),'$130.00')]") WebElement price;
	@FindBy(xpath="//div[@id=\"averageCustomerReviews\"]//span[@id=\"acrCustomerReviewText\"]") WebElement review;
	@FindBy(linkText="Next") WebElement next;
	@FindBy(linkText="Previous") WebElement previous;
	 @FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected'and@aria-label='Current page, page 2']") WebElement page2;
	 @FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected'and@aria-label='Current page, page 1']") WebElement page1;
	
	 
	 
	 public GuestPOM () {
		PageFactory.initElements(driver, this);
	}
	public void assert1() {
		String actual= assertelement.getText();
		Assert.assertTrue(actual.contains("adidas"));
		System.out.println(actual);
	}
	public void search(String name) {
		Search.sendKeys(name);
		submit.click();	;
	}
	public boolean verifyimage() {
		boolean result=image1.isDisplayed();
		return result;
		
	}
	public boolean verifyname() {
		boolean result=productname.isDisplayed();
		return result;
		
	}
	public boolean verifyrating() {
		boolean result = rating.isDisplayed();
		return result;
	}
	public boolean verifyprice() {
		boolean result= price.isDisplayed();
		return result;
	}
	public boolean verifyreview() {
		productname.click();
		boolean result=review.isDisplayed();
		return result;
	}
	public boolean navigatenext() throws InterruptedException {
		next.click();
		Thread.sleep(5000);
		boolean result=page2.isDisplayed();
	return result;
	}
	public boolean navigateprev() throws InterruptedException {
		previous.click();
		Thread.sleep(5000);
		boolean result=page1.isDisplayed();
		return result;

	}
}

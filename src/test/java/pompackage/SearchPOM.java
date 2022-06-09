package pompackage;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseamazonclass.BaseClass;

public class SearchPOM extends BaseClass{

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
	@FindBy(xpath="//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']//span[@class='a-offscreen']") WebElement sorting;
	 
	 
	 public SearchPOM () {
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
public void items() {
	int pageitems= driver.findElements(By.xpath("//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']")).size();
	Assert.assertEquals(pageitems, 60);
	System.out.println(pageitems);
}
public void pagination() throws InterruptedException {
	 List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
	WebElement Nextbutton= driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
	List<String> Totalitems= new ArrayList<String>();
	 for( WebElement item:list) {	 
	 Totalitems.add(item.getText());	 
	 System.out.println(item.getText());
	 }
System.out.println("------------------>");
while(true) {
	        Thread.sleep(3000);
	        Nextbutton.click();
	        Thread.sleep(5000);
	        //base.Baseclass_amazon.Javaexecutor(2000);
	        list = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
	       
	        for( WebElement item:list) {
	       
	        String Actual= item.getText();
	            Totalitems.add(Actual);
	  	   
	    //System.out.println(Totalitems.size());
	   
	    if(!(Actual.equals("Womens Sneaker Sneaker"))) {
	    System.out.println(Actual);
	    continue;
	    }
	    else {
	   
	    Assert.assertNotSame(Actual, "Womens Sneaker Sneaker", "Items can not be repeated");
	   
	    } }

	        System.out.println("------------->");
	        try {
	        Nextbutton= driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
	       
	        }
	        catch(Exception e) {
	        System.out.println("No more product left");
	        break;
	}

}}

public void sortingLTH() throws InterruptedException {

		
		List<WebElement> beforeFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<Double> beforefilterprice =new ArrayList<>();
		
		for(WebElement p: beforeFilter) {
		beforefilterprice.add(Double.valueOf(p.getText().replace("$", "")));
		System.out.println(beforefilterprice);
		}
		Select obj=new Select(driver.findElement(By.id("s-result-sort-select")));
		obj.selectByVisibleText("Price: Low to High");
		List<WebElement> afterFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<Double> afterfilterprice =new ArrayList<>();
		for(WebElement q: afterFilter) {
		Thread.sleep(5000);
		
		afterfilterprice.add(Double.valueOf(q.getText().replace("$", ""))) ;
		System.out.println("Before"+ afterfilterprice);
		}
		
		Collections.sort(afterfilterprice,Collections.reverseOrder());
		System.out.println("After" + afterfilterprice);
	Assert.assertNotEquals(afterfilterprice, beforefilterprice);
		
	}

	
	public void sortingHTL() throws InterruptedException {
		
		List<WebElement> beforeFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<Double> beforefilterprice =new ArrayList<>();
		
		for(WebElement p: beforeFilter) {
		beforefilterprice.add(Double.valueOf(p.getText().replace("$", "")));
		System.out.println(beforefilterprice);
		}
		Select obj=new Select(driver.findElement(By.id("s-result-sort-select")));
		obj.selectByVisibleText("Price: High to Low");
		List<WebElement> afterFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<Double> afterfilterprice =new ArrayList<>();
		for(WebElement q: afterFilter) {
		Thread.sleep(5000);
		
		afterfilterprice.add(Double.valueOf(q.getText().replace("$", ""))) ;
		System.out.println("Before"+ afterfilterprice);
		}
		
		Collections.sort(afterfilterprice,Collections.reverseOrder());
		System.out.println("After" + afterfilterprice);
	Assert.assertNotEquals(afterfilterprice, beforefilterprice);
		
	}
	
}
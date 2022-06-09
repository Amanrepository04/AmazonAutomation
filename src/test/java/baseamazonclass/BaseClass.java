package baseamazonclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import utilities.TimeUtils;



public class BaseClass {
	public static Properties prop=new Properties(); // to use method from Config.prpertoes
	public static WebDriver driver;

	//Step 1: Create constructor
	public BaseClass() {
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\Varun Salgotra\\eclipse-workspace\\Amazon_Project1\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
		catch(IOException a) {
			a.printStackTrace();
		}
	}
		//Step 2 Create  method under which we will store all common commands which all child classes will be using
		
		public static void initiation() throws InterruptedException {
		//driver path WebDriver.chrome.driver, if we don't want to depend our code dependent on any b
			//Browser we can use if statement
			//if browser=chrome webdriver.chrome.driver
			//else if(browser=firefox){
			//webdriver.gecko.driver
			//maximize, pageload,implicit, getting url
		String browsername=prop.getProperty("Browser");
		if(browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
			driver=new FirefoxDriver();
		}
			else if(browsername.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TimeUtils.Timeunit,TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(TimeUtils.Timeunit,TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
}
		
public static void login() throws InterruptedException {
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath(prop.getProperty("Hello")))).build().perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("Signin"))).click();
	driver.findElement(By.id(prop.getProperty("Email"))).sendKeys(prop.getProperty("Username"));
	driver.findElement(By.id(prop.getProperty("Button"))).click();
	driver.findElement(By.id(prop.getProperty("password"))).sendKeys(prop.getProperty("Password"));
	driver.findElement(By.id(prop.getProperty("submit"))).click();
	Thread.sleep(5000);
}

}

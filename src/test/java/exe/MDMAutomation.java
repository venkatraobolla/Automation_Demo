/* 
Author: Artha Data Solutions Testing Team
Date: 10/23/2017
Description: MDM Test Automation
 */

//Package Statement
package exe;

// Import statement
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Class Defination
public class MDMAutomation {



	//Global variable declaration
	WebDriver driver;
	Select select;
	WebDriverWait wait;
	/*@BeforeMethod
	public void global() throws InterruptedException {
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		//Actions Act=new Actions(driver);
	}*/
	//Test Script for Login functionality
	@Test(priority=0)
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\10064\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\10064\\Downloads\\geckodriver-v0.19.0-win32\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://192.168.1.144:6150/talendmdm/ui");
		Reporter.log("Navigated to MDM Login Page");
		Thread.sleep(1000);

		driver.findElement(By.name("j_username")).sendKeys("administrator");
		Thread.sleep(1000);
		driver.findElement(By.name("j_password")).sendKeys("administrator");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
		Reporter.log("User successfully logged in");
		Thread.sleep(2000);
	}

	//Test Script for Domain Configuration functionality
	@Test(priority=1)
	public void domainConfiguration() throws InterruptedException {

		driver.findElement(By.id("general-x-auto-19")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='general-x-auto-18']/div[1]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath(".//*[@id='general-x-auto-23']/tbody/tr[2]/td[2]/em/button")).click();
		Thread.sleep(2000);
	}
	//Test Script for Entity Selection functionality
	@Test(priority=2)
	public void entitySelection() throws InterruptedException {

		driver.findElement(By.xpath(".//*[@id='menu-browserecords']/span/span")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("x-auto-12")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='x-auto-11']/div[4]")).click();
		Thread.sleep(2000);
	}

	//Test Script for Create new record 
	@Test(priority=3,enabled=false)
	public void createEntity() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.findElement(By.xpath(".//*[@id='BrowseRecords_Create']/tbody/tr[2]/td[2]/em/button")).click();
		Thread.sleep(1000);

		//Passing CustomerId value
		driver.findElement(By.name("mdmPerson/FirstName")).sendKeys("Venkat");
		Thread.sleep(1000);
		driver.findElement(By.name("mdmPerson/LastName")).sendKeys("Bolla");
		Thread.sleep(1000);
		driver.findElement(By.name("mdmPerson/MiddleName")).sendKeys("rao");
		Thread.sleep(1000);
		driver.findElement(By.name("mdmPerson/SSN")).sendKeys("123456789");
		Thread.sleep(1000);
		//Click on save
		driver.findElement(By.xpath(".//*[@id='saveButton']/tbody/tr[2]/td[2]/em/button")).click();
		Thread.sleep(2000);
		

		/*	//wait for alert
		Alert a=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("before alert");
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        System.out.println("after alert");
        // Capturing alert message.    
        String alertMessage = "";
        Thread.sleep(3000);
        alertMessage= driver.switchTo().alert().getText();
     	Thread.sleep(1000);
		System.out.println(alertMessage);
		Thread.sleep(1000);
		//Verify alert
		if(alertMessage.equals("Validation failed on field 'FirstName'"))
		{
		System.out.println("First Name Empty! alert displayed");
		driver.switchTo().alert().dismiss();
		//alert.dismiss();
		}
		Thread.sleep(1000);
		//Passing First Name value
		driver.findElement(By.xpath(".//*[@id='x-auto-248-input']")).sendKeys("Dan");
		Thread.sleep(1000);
		//Click on save */
		//driver.findElement(By.xpath(".//*[@id='saveButton']/tbody/tr[2]/td[2]/em/button")).click(); */

	}
	
	//Test Script for Web Table 
	@Test(priority=4)
	public void webTable() throws InterruptedException {

		List <WebElement> col = driver.findElements(By.xpath("//*[@id='x-auto-87']/tbody/tr/td"));
		System.out.println("No of cols are : " +col.size()); 
		//No.of rows 
		List <WebElement> rows = driver.findElements(By.xpath("//*[@id='x-auto-74']/div[1]/div[1]/div[2]/div"));
		System.out.println("No of rows are : " + rows.size());

		
	}
}
package SeleniumActivities;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ApplyLeave_Activity8 {
	
	WebDriver driver;
	
	
	  @BeforeMethod
	    public void OpenOrangeHRMBrowser() {
	       
	        driver = new ChromeDriver();
	        
	        //Open browser
	        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	        String url = driver.getCurrentUrl();
			  System.out.println("Login URL is :" + url);
			  
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  
			  driver.findElement(By.id("frmLogin"));
			  driver.findElement(By.id("txtUsername")).sendKeys("orange");
			  driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
			  driver.findElement(By.name("Submit")).click();
			  
			 		  
			  Assert.assertEquals(driver.getCurrentUrl(), "http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard");
			  
			  String loginurl = driver.getCurrentUrl();
			  System.out.println("Login URL is :" + loginurl);
			  
			  
	       
	    }
	  
	  @Test
	  
	  public void ApplyLeave() throws InterruptedException
	  {
		  
		  driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"menu_leave_applyLeave\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"applyleave_txtLeaveType\"]")).click();
		  
		  Actions leave = new Actions(driver);
		  leave.sendKeys(Keys.chord(Keys.DOWN)).perform();
		  leave.click();
		  
		 
		  driver.findElement(By.xpath("//*[@id=\"applyleave_txtFromDate\"]")).clear();
		  driver.findElement(By.xpath("//*[@id=\"applyleave_txtFromDate\"]")).sendKeys("2020-07-16");
		  
		  driver.findElement(By.xpath("//*[@id=\"applyleave_txtToDate\"]")).clear();
		  driver.findElement(By.xpath("//*[@id=\"applyleave_txtToDate\"]")).sendKeys("2020-07-27");
		  
		//  driver.findElement(By.xpath("//*[@id=\"applyleave_txtToDate\"]")).sendKeys("Enter");
		 
		  
		//  driver.findElement(By.xpath("//*[@id=\"applyleave_partialDays\"]")).click();
		  
		  Actions days = new Actions(driver);
	      days.sendKeys(Keys.chord(Keys.DOWN)).perform();
		  days.click();
		  		
		  driver.findElement(By.xpath("//*[@id=\"applyBtn\"]")).click();
		  
		  Thread.sleep(20);
		  
		  driver.findElement(By.xpath("//*[@id=\"menu_leave_viewMyLeaveList\"]")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"calFromDate\"]")).clear();
		  driver.findElement(By.xpath("//*[@id=\"calFromDate\"]")).sendKeys("2020-07-16");
		  
		  driver.findElement(By.xpath("//*[@id=\"calToDate\"]")).clear();
		  driver.findElement(By.xpath("//*[@id=\"calToDate\"]")).sendKeys("2020-07-27");  
		
		  driver.findElement(By.id("btnSearch")).click();
	  		
		  
	  }
	  
	  @AfterMethod
		 
		 public void CloseDirectoryMenuPage() throws InterruptedException
		 {
		  	 Thread.sleep(20);
			 driver.quit();
		 }	  

}

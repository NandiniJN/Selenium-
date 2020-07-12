package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DirectoryMenu_Activity6 {

	 WebDriver driver;
		
		
	  @BeforeMethod
	    public void OpenOrangeHRMBrowser() {
	        //Create a new instance of the Chrome driver
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
	  public void DirectoryMenu() {
		  
		  driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/directory/viewDirectory/reset/1");
		  
		  driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")).isDisplayed();
		  
		  WebElement click1 = driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]"));
		  if (click1.isDisplayed() && click1.isEnabled())
		  {
			  click1.click();
		  }
		  
		  
		  Assert.assertEquals("Search Directory", "Search Directory");
		  
		
	  }
	  
		 @AfterMethod
		 
		 public void CloseDirectoryMenuPage()
		 {
			 driver.quit();
		 }
	  
		  
	  }
		  


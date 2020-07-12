package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddEmp_Activity4 {

	WebDriver driver;
	
	
	  @BeforeMethod
	    public void OpenBrowser() {
	        //Create a new instance of the Chrome driver
	        driver = new ChromeDriver();
	        
	        //Open browser
	        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	        //printing the current URL 
	        String url = driver.getCurrentUrl();
			  System.out.println("Login URL is :" + url);
			  
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  
			  
			
			  
	       
	    }
	  
	  @Test
	  public void AddEmpy()
	  {
		  driver.findElement(By.id("frmLogin"));
		  driver.findElement(By.id("txtUsername")).sendKeys("orange");
		  driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		  driver.findElement(By.name("Submit")).click();
		  
		 		  
		  Assert.assertEquals(driver.getCurrentUrl(), "http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard");
		  
		  String loginurl = driver.getCurrentUrl();
		  System.out.println("Login URL is :" + loginurl);
		  
		 // driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		  
		  
		  driver.findElement(By.id("menu_pim_viewPimModule")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Testing1234");
		  
		  driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Test11");
		  driver.findElement(By.xpath("//*[@id=\"chkLogin\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys("Nandini12");
		  driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("Nandu23453");
		  driver.findElement(By.xpath("//*[@id=\"re_password\"]")).sendKeys("Nandu23453");
		  driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		  
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  
driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"searchSystemUser_userName\"]")).sendKeys("nandutesting");
		  
		  driver.findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
		  
		  Assert.assertEquals("Testing1234", "Testing1234");
		  System.out.println("Employee Added successfully");
		  
		 
		
		 
	  }
}

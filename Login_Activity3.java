package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Activity3 {
	
	 WebDriver driver;
		
		
	  @BeforeMethod
	    public void OpenBrowser() {
	        //Create a new instance of the Chrome driver
	        driver = new ChromeDriver();
	        
	        //Open browser
	        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	        String url = driver.getCurrentUrl();
			  System.out.println("Login URL is :" + url);
	       
	    }
	  
	  @Test
	  public void Login() {
		  
		  driver.findElement(By.id("frmLogin"));
		  driver.findElement(By.id("txtUsername")).sendKeys("orange");
		  driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		  driver.findElement(By.name("Submit")).click();
		  
		 		  
		  Assert.assertEquals(driver.getCurrentUrl(), "http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard");
		  
		  String loginurl = driver.getCurrentUrl();
		  System.out.println("Login URL is :" + loginurl);
		  
		 
	  }
	  
	  @AfterMethod
	  public void CloseBrowserHome()
	  {
		  driver.quit();
	  }
	 

}

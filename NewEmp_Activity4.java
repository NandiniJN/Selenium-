package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewEmp_Activity4 {

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
		  driver.manage().window().maximize();
		  
		  
		  driver.findElement(By.id("menu_pim_viewPimModule")).click();
		//  driver.findElement(By.id("menu_pim_addEmployee")).click();
		  driver.findElement(By.id("btnAdd")).click();
		 // driver.findElement(By.id("user_name")).click();
		  
		  driver.findElement(By.id("firstName")).sendKeys("Nandini");
		  driver.findElement(By.id("lastName")).click();
		  driver.findElement(By.id("lastName")).sendKeys("J N");
		 
		  driver.findElement(By.id("chkLogin")).click();
		  driver.findElement(By.id("user_name")).sendKeys("Nandu");
		  driver.findElement(By.id("user_password")).sendKeys("Nandu1234");
		  driver.findElement(By.id("re_password")).sendKeys("Nandu123");
		  driver.findElement(By.id("btnSave")).click();
		  
		  driver.navigate().back();
		  driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		  
		
		  
		   driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Nandini");
		   driver.findElement(By.id("seacrhBtn")).click();
		   driver.findElement(By.className("left")).click();
		   
		   Assert.assertEquals("Nandini", "Nandini");
		    
		  
		  
		  
		  
		  
	  }
	  
	
}

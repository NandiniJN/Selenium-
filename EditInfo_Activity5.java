package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditInfo_Activity5 {

	
	
	 WebDriver driver;
		
		
	  @BeforeMethod
	    public void OpenBrowser() {
	        //Create a new instance of the Chrome driver
	        driver = new ChromeDriver();
	        
	        //Open browser
	        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	        String url = driver.getCurrentUrl();
			  System.out.println("Login URL is :" + url);
			  
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  
			  
			  
	       
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
		  
		  
		  driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]")).clear();
		  
		  driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]")).sendKeys("nandutesting");
		  
		  driver.findElement(By.xpath("//*[@id=\"personal_optGender_2\"]")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"personal_cmbNation\"]")).sendKeys("Indian");
		  
		  driver.findElement(By.xpath("//*[@id=\"personal_DOB\"]")).clear();
		  
		  driver.findElement(By.xpath("//*[@id=\"personal_DOB\"]")).sendKeys("1993-03-25");
		  
		  driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		  
		  //to verify/confirm data is properly updated
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		    
		  
	  
}
	  @AfterMethod
	  public void closeLoginPage()
	  {
		  driver.quit();
	  }
	  
}
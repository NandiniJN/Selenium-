package SeleniumActivities;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderImage_Activity2 {

	
	 WebDriver driver;
	
	
	  @BeforeMethod
	    public void OpenBrowser() {
	        //Create a new instance of the Chrome driver
	        driver = new ChromeDriver();
	        
	        //Open browser
	        driver.get("http://alchemy.hguy.co/orangehrm");
	        driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			          
	       
	    }
	
	@Test
	public void HeaderImage()
	
	{
		
		driver.findElement(By.id("divLogo"));
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/img"));
		String image = driver.getCurrentUrl();
	 
				System.out.println("Image Header URL is " + image);
		
		
	}
	
	@AfterMethod
	public void CloseBroswer()
	{
		driver.quit();
		
	}
	
	
}

package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebsiteTitle_Activity1 {
	
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
	    public void verifytitlepage() {
	        // Check the title of the page
	        String title = driver.getTitle();
	            
	        //Print the title of the page
	        System.out.println("Page title is: " + title);
	            
	    
	        //Find the clickable link on the page and click it
	        driver.findElement(By.id("divLogo")).click();
	        
	       	        
	        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	    }

	  @AfterMethod
	    public void CloseBroswer()
	    {
	    	driver.quit();
	    }
	    
	    
	    
	    
	    }



package SeleniumActivities;

import java.awt.Dimension;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RetrieveEmergency_Activity9 {
	
	WebDriver driver;
	private By mytable;
	
	
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
	  public void RetrieveEmergencyContact() throws InterruptedException
	  {
		  driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/pim/viewMyDetails");
		  
		  driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
		  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
					
		  driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[3]/a")).click();
		  
		  
		  WebElement mytable = driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]/tbody"));
		  
		  List < WebElement > rows_table = mytable.findElements(By.xpath("//*[@id=\"emgcontact_list\"]/tbody"));
		  
		  int rows_count = rows_table.size();
		  
		  for (int row = 0; row < rows_count; row++) {
			  
			  List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			  
			  int columns_count = Columns_row.size();
			  
			  System.out.println("Number of cells In Row " + row + " are " + columns_count);
			  
			  for (int column = 0; column < columns_count; column++) {
				  String celtext = Columns_row.get(column).getText();
				  System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
				  
				  
			  }
			  
			  System.out.println("-------------------------------------------------- ");
		  }
		  
		  Thread.sleep(20);
	  
	  }

	  @AfterMethod 
	  public void CloseEmployeeBrowser() throws InterruptedException
	  {
		  Thread.sleep(20);
		  driver.quit();
	  }
	  
}


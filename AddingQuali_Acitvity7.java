package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddingQuali_Acitvity7 {

	
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
	public void Myinfo()
	
	{
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
				
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				
		
		driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[9]/a")).click();
		
		driver.findElement(By.id("addWorkExperience")).click();
		
		driver.findElement(By.xpath("//*[@id=\"experience_employer\"]")).sendKeys("IBM India PVT LTD");
		
		driver.findElement(By.xpath("//*[@id=\"experience_jobtitle\"]")).sendKeys("Test Specialist");
		
		driver.findElement(By.xpath("//*[@id=\"experience_from_date\"]")).clear();
		
		driver.findElement(By.xpath("//*[@id=\"experience_from_date\"]")).sendKeys("2016-04-19");
		
		driver.findElement(By.xpath("//*[@id=\"experience_to_date\"]")).clear();
		
		driver.findElement(By.xpath("//*[@id=\"experience_to_date\"]")).sendKeys("2020-07-08");
		
		driver.findElement(By.xpath("//*[@id=\"experience_comments\"]")).sendKeys("ATT CLIENT");
		
		driver.findElement(By.xpath("//*[@id=\"btnWorkExpSave\"]")).click();
		
		
		
		
	}
	
	 @AfterMethod
	 
	 public void CloseDirectoryMenuPage() throws InterruptedException
	 {
		 Thread.sleep(20);
		 driver.quit();
	 }
  
}

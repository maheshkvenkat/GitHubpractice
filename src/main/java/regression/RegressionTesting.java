package regression;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegressionTesting {
	
	String basicUrl="https://www.hyrtutorials.com/p/basic-controls.html";
    String alertUrl="https://www.hyrtutorials.com/p/alertsdemo.html";
    String windowUrl="https://www.hyrtutorials.com/p/window-handles-practice.html";
    String actionsurl="https://www.flipkart.com/";
    String framesurl="https://www.hyrtutorials.com/p/frames-practice.html";
    WebDriver driver;
    
    @Test
    public void getAlerts()
    {
    	try {
    		System.setProperty("webdriver.chrome.driver", "C:\\Project5\\PracticeProject\\Resources\\chromedriver.exe");
        	driver=new ChromeDriver();
        	driver.get(alertUrl);
        	driver.manage().window().maximize();
        	driver.findElement(By.id("alertBox")).click();
        	driver.switchTo().alert().accept();
        	Thread.sleep(3000);
        
        	driver.findElement(By.id("confirmBox")).click();
        	driver.switchTo().alert().dismiss();
        	Thread.sleep(3000);
        	
        	driver.findElement(By.id("promptBox")).click();
        	driver.switchTo().alert().sendKeys("Mahesh");
        	Thread.sleep(3000);
        	driver.switchTo().alert().accept();
        	Thread.sleep(3000);
    		
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    		
    	}
    	
    	finally {
    		driver.quit();
    	}
    	  	
    	
    }
      	
   
    @Test
    public void handlewindows()
     {
 	
 	   try {
 		   System.setProperty("webdriver.chrome.driver", "C:\\Project5\\PracticeProject\\Resources\\chromedriver.exe");
 			driver=new ChromeDriver();
 			driver.get(windowUrl);
 			driver.manage().window().maximize();
 			Thread.sleep(3000);
 			driver.findElement(By.id("newWindowBtn")).click();
 			Thread.sleep(3000);
 			driver.findElement(By.id("newTabBtn")).click();
 			Thread.sleep(3000);
 		    Set<String> wins=driver.getWindowHandles();
 		    for(String win:wins)
 		    {
 		    	System.out.println("Current window name is "+win);
 		    	if(driver.switchTo().window(win).getTitle().contains("AlertsDemo"))
 		    	{
 		    		driver.findElement(By.id("alertBox")).click();
 		    		Thread.sleep(3000);
 		    		driver.switchTo().alert().accept();
 		    	}
 		    }
 		   
 	   }
 	   catch(Exception e)
 	   {
 		   System.out.println(e.getMessage());
 	   }
 	   finally
 	   {
 		   driver.quit();
 	   }
 	
 	
 	
     }
    
    @Test
    public void handleframes()
    {
 	   try {
 		   System.setProperty("webdriver.chrome.driver", "C:\\Project5\\PracticeProject\\Resources\\chromedriver.exe");
 			driver=new ChromeDriver();
 			driver.get(framesurl);
 			driver.manage().window().maximize();
 			Thread.sleep(3000);
 			driver.findElement(By.id("name")).sendKeys("text1");
 			
 			driver.switchTo().frame("frm1");
 			Select sel=new Select(driver.findElement(By.id("course")));
 			sel.selectByIndex(2);
 			Thread.sleep(3000);
 			
 			driver.switchTo().defaultContent();
 			Thread.sleep(3000);
 			driver.findElement(By.id("name")).sendKeys("frm1");
 			
 			
 			driver.switchTo().frame("frm3");
 			driver.findElement(By.id("name")).sendKeys("Mahesh");
 			Thread.sleep(3000);
 			driver.switchTo().frame("frm1");
 			Select sel1=new Select(driver.findElement(By.id("course")));
 			sel1.selectByIndex(1);
 			Thread.sleep(3000);
 			driver.switchTo().parentFrame();
 			Thread.sleep(3000);
 			
 			driver.switchTo().defaultContent();
 			Thread.sleep(3000);
 			driver.findElement(By.id("name")).sendKeys("frm3");
 			
 			
 			
 			
 	   }
 	   catch(Exception e){
 		   System.out.println(e.getMessage());
 		   
 	   }
 	   finally {
 		   driver.quit();
 		   
 	   }
 	   
    }
   
   @Test
   public void handleActions()
   {
	   try
	   {
		   System.setProperty("webdriver.chrome.driver", "C:\\Project5\\PracticeProject\\Resources\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(actionsurl);
			driver.manage().window().maximize();
			Thread.sleep(20000);
			WebElement mainmenu=driver.findElement(By.xpath("//span[text()='Electronics']"));
			Actions action=new Actions(driver);
			action.moveToElement(mainmenu).perform();
			Thread.sleep(4000);
			WebElement submenu=driver.findElement(By.xpath("//a[text()='Electronics GST Store']"));
			action.moveToElement(submenu).click().build().perform();
			Thread.sleep(4000);
			
			WebElement loginbutton=driver.findElement(By.xpath("//a[text()='Login']")); 
			action.moveToElement(loginbutton).contextClick().build().perform();
			Thread.sleep(4000);

	   }	
	   catch(Exception e)
	   {
		   System.out.println(e.getMessage());
		   
	   }
	   
	   finally 
	   {
		   driver.quit();
		   
	   }
   }
   
   @Test(dataProvider="getData")
   public void registration(String fname,String lname,String email,String pwd) throws InterruptedException, IOException
   {
   	System.setProperty("webdriver.chrome.driver", "C:\\Project5\\PracticeProject\\Resources\\chromedriver.exe");
   	driver=new ChromeDriver();
   	driver.get(basicUrl);
   	driver.manage().window().maximize();
   	driver.findElement(By.id("firstName")).sendKeys(fname);
   	driver.findElement(By.id("lastName")).sendKeys(lname);
   	driver.findElement(By.id("hindichbx")).click();
   	driver.findElement(By.id("email")).sendKeys(email);
   	driver.findElement(By.id("password")).sendKeys(pwd);
   	Thread.sleep(4000);
   	driver.findElement(By.id("registerbtn")).click();
   	Thread.sleep(4000);
   	TakesScreenshot takeSS=(TakesScreenshot)driver;
   	File srcfile=takeSS.getScreenshotAs(OutputType.FILE);
   	File destfile=new File("C:\\Project5\\PracticeProject\\Resources\\Result.png");
   	FileUtils.copyFile(srcfile, destfile);
   	driver.quit();
   	
   }
   
   @DataProvider
   public Object[][] getData() throws InvalidFormatException, IOException
   {
   	File fileobj=new File("C:\\Project5\\PracticeProject\\Resources\\testdata.xlsx");
   	XSSFWorkbook wbook=new XSSFWorkbook(fileobj);
   	XSSFSheet sheet=wbook.getSheet("Registration");
   	String fName=sheet.getRow(1).getCell(0).toString();
   	String lName=sheet.getRow(1).getCell(1).toString();
   	String email=sheet.getRow(1).getCell(2).toString();
   	String pwd=sheet.getRow(1).getCell(3).toString();
   	Object[][] obj=new Object[][] {
   		{fName,lName,email,pwd}
   	                              };
   	
   	
   	return obj;
   	
  }
   
   
}
	


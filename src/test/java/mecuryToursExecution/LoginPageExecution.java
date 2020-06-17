package mecuryToursExecution;

import org.testng.annotations.Test;

import excelUtils.Constant;
import excelUtils.ExcelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory_POM.LogIn_POM;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;

public class LoginPageExecution {
	 WebDriver driver;
	 
	 // EXECUTE THE TESTCASE
	 @Test
	  public void Login() throws Exception {
		  
		  driver.manage().window().maximize();
		  driver.get("http://newtours.demoaut.com/mercuryreservation.php");
		  LogIn_POM loginObj = new LogIn_POM(driver);
		  
		  int intTotalRow = ExcelUtils.getNumberRows();

			for (int i = 1; i <= intTotalRow; i++) {
				
				//loginObj.clickLoginTab();
				loginObj.setUsername(ExcelUtils.getCellData(i, 10));
				loginObj.setPassword(ExcelUtils.getCellData(i, 11));
				loginObj.clickSignin();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				loginObj.clickLogout();
			}
	  }
	 
	 // SETUP THE ENVIRONMENT
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	  ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.Sheet_Name);
		/*
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
		 * //WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  WebDriverManager.chromedriver().setup();
	      driver = new ChromeDriver();
	      WebDriverManager.operadriver().setup();
		 WebDriverManager.iedriver().setup();
		 */
	   // System.setProperty("webdriver.opera.driver", "C:\\Users\\Tonic\\Sellenium-workspace\\SeleniumWebdrivers\\operadriver.exe\\");
	    WebDriverManager.operadriver().setup();
	    driver = new OperaDriver();
  }
  
 // CLOSE THE ENVRONMENT
  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }
       //System.setProperty("webdriver.chrome.driver", "C:\\Selenium_workspace\\Gecko_drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
	    //System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tonic\\Sellenium-workspace\\SeleniumWebdrivers\\geckodriver.exe");
	    //WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();
		//WebDriverManager.chromedriver().setup();
	    //driver = new ChromeDriver();
	    // WebDriverManager.operadriver().setup();
		// WebDriverManager.iedriver().setup(); 
        // jenkins password: 12d6bb0c879b4b4bb5d0a040ebf93e65
}

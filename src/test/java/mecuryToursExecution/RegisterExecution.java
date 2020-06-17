package mecuryToursExecution;

import org.testng.annotations.Test;
import excelUtils.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory_POM.*;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class RegisterExecution {
	WebDriver driver;
	
  @Test
  public void f() throws Exception {
	  
	    driver.manage().window().maximize();
	    driver.get("http://newtours.demoaut.com/mercuryreservation.php");
		Register_POM registerObj = new Register_POM(driver);
		
		int intTotalRow = ExcelUtils.getNumberRows();
		
		for (int i = 1; i <= intTotalRow; i++) {
			
			registerObj.clickRegister();
			registerObj.setFirstName(ExcelUtils.getCellData(i, 1));
			registerObj.setLastName(ExcelUtils.getCellData(i, 2));
			registerObj.setEmailId(ExcelUtils.getCellData(i, 3));
			registerObj.setPhoneNo(ExcelUtils.getCellData(i, 4));
			registerObj.setAddress(ExcelUtils.getCellData(i, 5));
			registerObj.setCity(ExcelUtils.getCellData(i, 6));
			registerObj.setProvince(ExcelUtils.getCellData(i, 7));
			registerObj.setPostalCode(ExcelUtils.getCellData(i, 8));
			registerObj.setcountry(ExcelUtils.getCellData(i, 9));
			registerObj.setUserName(ExcelUtils.getCellData(i, 10));
			registerObj.setPassword(ExcelUtils.getCellData(i, 11));
			registerObj.setConfirmPassword(ExcelUtils.getCellData(i, 12));
			registerObj.clickSubmit();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			registerObj.clickRegister();
		}
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	  ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.Sheet_Name);
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() throws Exception {
	  driver.quit();
  }

}

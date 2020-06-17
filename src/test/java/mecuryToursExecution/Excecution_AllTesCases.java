package mecuryToursExecution;

import org.testng.annotations.Test;
import excelUtils.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory_POM.BookAFlight_POM;
import pageFactory_POM.FlightFinder_POM;
import pageFactory_POM.LogIn_POM;
import pageFactory_POM.Register_POM;
import pageFactory_POM.SelectFlight_POM;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Excecution_AllTesCases {
	
	WebDriver driver;
	
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
  @Test(priority = 0)
  public void Registration() throws Exception {
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
  @Test(priority = 1)
  public void BookFlight() throws Exception {
	  
	    driver.manage().window().maximize();
	    driver.get("http://newtours.demoaut.com/mercuryreservation.php");
		FlightFinder_POM findObj = new FlightFinder_POM(driver);
		LogIn_POM login = new LogIn_POM(driver);
		SelectFlight_POM selectFlightObj = new SelectFlight_POM(driver);
		BookAFlight_POM BookObj = new BookAFlight_POM(driver);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		login.clickLoginTab();
		login.setUsername("Tonic");
		login.setPassword("12345");
		login.clickSignin();
		
		int intTotalRow = ExcelUtils.getNumberRows();
		
		for (int i = 1; i <= intTotalRow; i++) {
			
			
			//Find Flights
			String tripType= ExcelUtils.getCellData(i, 13);
			if(tripType.equalsIgnoreCase("roundtrip")) 
			{
				findObj.SelectTrip_Type1();	
			}
			else {
				findObj.SelectTrip_Type2();
			}
			findObj.Select_NoPassengers(ExcelUtils.getCellData(i, 14));
			findObj.Select_DepartingFrom(ExcelUtils.getCellData(i, 15));
			findObj.Select_On_Month(ExcelUtils.getCellData(i, 16));
			findObj.Select_On_Date(ExcelUtils.getCellData(i, 17));
			findObj.selectArrival_In(ExcelUtils.getCellData(i, 18));
			findObj.selectToMoth(ExcelUtils.getCellData(i, 19));
			findObj.selectToDate(ExcelUtils.getCellData(i, 20));
			
			String FlightClass =(ExcelUtils.getCellData(i, 21));
			if(FlightClass.equalsIgnoreCase("Coach"))
			{
				findObj.selectServiceClass1();
			}
			else if(FlightClass.equalsIgnoreCase("Business"))
			{
				findObj.selectServiceClass2();
			}
			else
			{
				findObj.selectServiceClass3();
			}
			findObj.selectAirline(ExcelUtils.getCellData(i, 22));
			//Thread.sleep(1000);
			findObj.clickContinue();
			
			//Select Flight
		    String Departure = ExcelUtils.getCellData(i, 23);
			
			if( Departure.equalsIgnoreCase("Blue Skies Airlines$360$270$5:03" ))
			{
				selectFlightObj.selectDepatureFlight1();
			}
			else if ( Departure.equalsIgnoreCase("Blue Skies Airlines$361$271$7:10"))
			{
				selectFlightObj.selectDepatureFlight2();
			}
			else if ( Departure.equalsIgnoreCase("Pangea Airlines$362$274$9:17"))
			{
				selectFlightObj.selectDepatureFlight3();
			}else 
			{
				selectFlightObj.selectReturnFlight4();
			}
			
			String Return =ExcelUtils.getCellData(i, 24); 
			
			if( Return.equalsIgnoreCase("Blue Skies Airlines$630$270$12:23"))
			{
				selectFlightObj.selectReturnFlight1();
			}
			else if ( Return.equalsIgnoreCase("Blue Skies Airlines$631$273$14:30"))
			{
				selectFlightObj.selectReturnFlight2();
			}
			else if ( Return.equalsIgnoreCase("Pangea Airlines$632$282$16:37"))
			{
				selectFlightObj.selectReturnFlight3();
			}else 
			{
				selectFlightObj.selectReturnFlight4();
			}
			
			selectFlightObj.clickContinue();
			BookObj.setBillFirstName(ExcelUtils.getCellData(i, 1));
			BookObj.setBillLastName(ExcelUtils.getCellData(i, 2));
			BookObj.selectMeal(ExcelUtils.getCellData(i, 27));
			BookObj.selectCardType();
			BookObj.setCardNumber();
			BookObj.setExpiryMonth(ExcelUtils.getCellData(i, 25));
			BookObj.setExpiryYear(ExcelUtils.getCellData(i, 26));
			BookObj.setCardFirstName(ExcelUtils.getCellData(i, 1));
			BookObj.setCardLastName(ExcelUtils.getCellData(i, 2));
			BookObj.setBillAddress(ExcelUtils.getCellData(i, 5));
			BookObj.setCity(ExcelUtils.getCellData(i, 6));
			BookObj.setProvince(ExcelUtils.getCellData(i, 7));
			BookObj.setZipCode(ExcelUtils.getCellData(i, 8));
			BookObj.selectCountry(ExcelUtils.getCellData(i, 9));
			BookObj.clickSame();
			BookObj.clickSecurePurchase();
			BookObj.clickFlights();
			
			
		}
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.Sheet_Name);
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
	    }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  //driver.close();
  }

}

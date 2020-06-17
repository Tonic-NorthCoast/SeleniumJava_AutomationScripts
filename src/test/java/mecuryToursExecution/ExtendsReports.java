package mecuryToursExecution;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import excelUtils.Constant;
import excelUtils.ExcelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory_POM.BookAFlight_POM;
import pageFactory_POM.FlightFinder_POM;
import pageFactory_POM.LogIn_POM;
import pageFactory_POM.Register_POM;
import pageFactory_POM.SelectFlight_POM;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class ExtendsReports {
	
	 WebDriver driver;
	 ExtentReports extent;
	 //helps to generate the logs in test report.
	 ExtentTest test;
	 ExtentHtmlReporter htmlReporter;
	
	  // Execute Login TestCases.....This will Execute Firstly because Priority is not set
	  @Test
	  public void Login() throws Exception {
		  test = extent.createTest("TEST CASE 1 : LOGIN PAGE", "LOGIN PAGE EXECUTION");
		  driver.manage().window().maximize();
		  driver.get("http://newtours.demoaut.com/mercuryreservation.php");
		  LogIn_POM loginObj = new LogIn_POM(driver);
		  int intTotalRow = ExcelUtils.getNumberRows();

			for (int i = 1; i <= intTotalRow; i++) {
				
				loginObj.setUsername(ExcelUtils.getCellData(i, 10));
				loginObj.setPassword(ExcelUtils.getCellData(i, 11));
				loginObj.clickSignin();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				loginObj.clickLogout();
			}
			 Assert.assertTrue(true);
	  }
	  
	  //*****  Execute Login TestCases.....This will Execute Secondly because Priority is set to 0  ******
	  @Test(priority = 0)
	  public void Registration() throws Exception {
		    test = extent.createTest("TEST CASE 1 : REGISTER PAGE", "REGISTER PAGE EXECUTION");
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
			 Assert.assertTrue(true);
	  }
	  
	  //  Execute Book_flight TestCases.....
	 // This will Execute after Register TestCase because Priority is set to 1
	  @Test(priority = 1)
	  public void BookFlight() throws Exception {
		    test = extent.createTest("TEST CASE 3 : BOOKFLIGHT PAGE", "BOOK FLIGHT PAGE EXECUTION");
		    driver.manage().window().maximize();
		    driver.get("http://newtours.demoaut.com/mercuryreservation.php");
			FlightFinder_POM findObj = new FlightFinder_POM(driver);
			LogIn_POM login = new LogIn_POM(driver);
			SelectFlight_POM selectFlightObj = new SelectFlight_POM(driver);
			BookAFlight_POM BookObj = new BookAFlight_POM(driver);
			
			//implicit wait
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
			 Assert.assertTrue(true);
	  }
	  
	  // SetUp the Environment for Execution
	  // We use DriverManger instead of webDriver.
	  @Parameters({ "OS", "browser" })
	  @BeforeTest
	  public void beforeTest(String OS, String browser) throws Exception {
		  
		  ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.Sheet_Name);
		  
			// initialize the HtmlReporter
	        htmlReporter = new ExtentHtmlReporter("TestNGReport.html");
	        
	        //initialize ExtentReports and attach the HtmlReporter
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	         
	        //To add system or environment info by using the setSystemInfo method.
	        extent.setSystemInfo("OS", OS);
	        extent.setSystemInfo("Browser", browser);
	        
	        //configuration items to change the look and feel
	        //add content, manage tests etc
	        htmlReporter.config().setDocumentTitle("MECURY TOURS APPLICATION TEST CASES");
	        htmlReporter.config().setReportName("TEST REPORTS FOR MECURY TOURS APPLICATION");
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		  
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		  
		    }
	    @AfterMethod
	    public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }
	  
      //After Execution close the Environment/Browser
	  @AfterTest
	  public void afterTest() {
		  driver.quit();
		  extent.flush();
		  //driver.close();
	  }


}

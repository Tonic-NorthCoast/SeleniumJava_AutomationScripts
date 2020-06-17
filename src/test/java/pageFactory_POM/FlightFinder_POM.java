package pageFactory_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightFinder_POM {

	WebDriver driver;
	By Roundtrip  = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]");
	By Oneway = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]");
	By Trip_Type = By.name("tripType");
	
	By Passengers = By.name("passCount");
	By Departing_From = By.name("fromPort");
	By On_Month = By.name("fromMonth");
	By On_Date = By.name("fromDay");
	By Arrival_In = By.name("toPort");
	By Returning_Date = By.name("toMonth");
	By Returning_Month = By.name("toDay");
	By ServiceClass = By.name("servClass");
	By Economy = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input");
	By Business = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]");
	By First = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]");
	
	By Airline = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select");
	By btnContinue = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td");
	

	

	public FlightFinder_POM(WebDriver driver) {

		this.driver = driver;
	}
	public void SelectTrip_Type1() {

		driver.findElement(Roundtrip).click();
	}
	public void SelectTrip_Type2() {

		driver.findElement(Oneway).click();
	}

	public void Select_NoPassengers(String strNoOfPassengers) {

		new Select(driver.findElement(Passengers)).selectByValue(strNoOfPassengers);

	}

	public void Select_DepartingFrom(String strDeparture) {

		new Select(driver.findElement(Departing_From)).selectByValue(strDeparture);

	}

	public void Select_On_Month(String strOnDate) {

		new Select(driver.findElement(On_Date)).selectByValue(strOnDate);

	}

	public void Select_On_Date(String strOnMonth) {

		new Select(driver.findElement(On_Month)).selectByValue(strOnMonth);

	}

	public void selectArrival_In(String strArrival) {
		new Select(driver.findElement(Arrival_In)).selectByValue(strArrival);

	}
	public void selectToDate(String strToDate) {
		new Select(driver.findElement(Returning_Date)).selectByValue(strToDate);

	}
	public void selectToMoth(String strToMonth) {
		new Select(driver.findElement(Returning_Month)).selectByValue(strToMonth);

	}
	public void selectServiceClass1() {
		driver.findElement(Economy).click();

	}
	public void selectServiceClass2() {
		driver.findElement(Business).click();

	}
	public void selectServiceClass3() {
		driver.findElement(First).click();

	}
	public void selectAirline(String strAirline) {
		new Select(driver.findElement(Airline)).selectByVisibleText(strAirline);

	}
	public void clickContinue() {

		driver.findElement(btnContinue).click();
	}
	
	

}

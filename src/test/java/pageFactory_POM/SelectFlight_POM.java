package pageFactory_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectFlight_POM {
	
	WebDriver driver;
	
	By  BluekiesAirlines360 =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[3]/td[1]/input");
	By  BlueSkiesAirlines361  =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]");
	By  PangaeaAirlines362 =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[1]");
	By  UnifiedAirlines363 =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[9]/td[1]");
	By  BlueSkiesAirlines630 =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[3]/td[1]");
	By  BlueSkiesAirlines631=By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input");
	By  PangeaAirlines632 =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[1]");
	By  UnifiedAirlines633 =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[1]");
	
	By DEPART =By.name("outFlight");
	By RETURN =By.name("inFlight");
	By btnContinue = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input");
	
	public SelectFlight_POM(WebDriver driver) {

		this.driver = driver;
	}
public void selectDepatureFlight1() {
		
		driver.findElement(BluekiesAirlines360).click();
	}
public void selectDepatureFlight2() {
	
	driver.findElement(BlueSkiesAirlines361).click();
}
public void selectDepatureFlight3() {
	
	driver.findElement(PangaeaAirlines362).click();
}
public void selectDepatureFlight4() {
	
	driver.findElement(UnifiedAirlines363).click();
}
public void selectReturnFlight1() {
	
	driver.findElement(BlueSkiesAirlines630).click();
}
public void selectReturnFlight2() {
	
	driver.findElement(BlueSkiesAirlines631).click();
}
public void selectReturnFlight3() {
	
	driver.findElement(PangeaAirlines632).click();
}
public void selectReturnFlight4() {
	
	driver.findElement(UnifiedAirlines633).click();
}
public void clickContinue() {

	driver.findElement(btnContinue).click();
}

	
	
}

package pageFactory_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class BookAFlight_POM {
	WebDriver driver;
	
	By FirstName = By.name("passFirst0");
	By LastName = By.name("passLast0");
	By Meal = By.name("pass.0.meal");
	By CreditCard = By.name("creditCard");
	By CardNo = By.name("creditnumber");
	By ExpiryMonth = By.name("cc_exp_dt_mn");
	By ExpiryYear = By.name("cc_exp_dt_yr");
	By  CardFirstName= By.name("cc_frst_name");
	By  CardMiddleName= By.name("cc_mid_name");
	By  CardLastName= By.name("cc_last_name");
	By billAdress1 = By.name("billAddress1");
	By billAdress2 = By.name("billAddress2");
	By billZipCode = By.name("billZip");
	By billCity = By.name("billCity");
	By billProvince = By.name("billState");
	By billCountry = By.name("billCountry");
	By same = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input");
	By  btnPurchase = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[23]/td/input");
	By  btnHome = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[2]/a/img");
	By btnBackToFlights  = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[1]/a/img");
	By CardNumber = By.name("creditnumber");		
	
	public BookAFlight_POM(WebDriver driver) {

		this.driver = driver;
	}
	public void setBillFirstName(String strFirstName)
	{
		driver.findElement(FirstName).sendKeys(strFirstName);
	}
	public void setBillLastName(String strLastName)
	{
		driver.findElement(LastName).sendKeys(strLastName);
	}
	public void selectMeal(String strMeal)
	{
		new Select(driver.findElement(Meal)).selectByValue(strMeal);
	}
	public void selectCardType()
	{
		new Select(driver.findElement(CreditCard)).selectByValue("IK");
	}
	public void setCardNo(String strCardNo)
	{
		driver.findElement(CardNo).sendKeys(strCardNo);
	}
	public void setExpiryMonth(String strMonth)
	{
		driver.findElement(ExpiryMonth).sendKeys(strMonth);
	}
	public void setExpiryYear(String strYear)
	{
		driver.findElement(ExpiryYear).sendKeys(strYear);
	}
	public void setCardFirstName(String strCardFirstName)
	{
		driver.findElement(CardFirstName).sendKeys(strCardFirstName);
	}
	public void setCardMiddleName(String strCardMiddleName)
	{
		driver.findElement(CardMiddleName).sendKeys(strCardMiddleName);
	}
	public void setCardNumber()
	{
		driver.findElement(CardNumber).sendKeys("16943965199");
	}

	public void setCardLastName(String strCardLastName)
	{
		driver.findElement(CardLastName).sendKeys(strCardLastName);
	}
	public void setBillAddress(String strAddress1)
	{
		driver.findElement(billAdress1).sendKeys(strAddress1);
	}
	public void setZipCode(String strZipCode)
	{
		driver.findElement(billZipCode).sendKeys(strZipCode);
	}
	public void setCity(String strCity)
	{
		driver.findElement(billCity).sendKeys(strCity);
	}
	public void setProvince(String strProvince)
	{
		driver.findElement(billProvince).sendKeys(strProvince);
	}
	public void selectCountry(String strCountry)
	{
		new Select(driver.findElement(billCountry)).selectByValue(strCountry);
	}
	public void clickSame()
	{
		driver.findElement(same).click();
	}
	public void clickSecurePurchase()
	{
		driver.findElement(btnPurchase).click();
	}
	public void clickHome()
	{
		driver.findElement(btnHome).click();
	}
	public void clickFlights()
	{
		driver.findElement(btnBackToFlights).click();
	}


}


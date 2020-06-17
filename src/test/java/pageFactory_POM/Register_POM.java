package pageFactory_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Register_POM {
	WebDriver driver;
	By tabRegister = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]");
	By First_Name = By.name("firstName");
	By Last_Name = By.name("lastName");
	By Phone_No = By.name("phone");
	By Email_Id = By.name("userName");
	By Address = By.name("address1");
	By City = By.name("city");
	By Province = By.name("state");
	By PostalCode = By.name("postalCode");
	By Country = By.name("country");
	By UserName = By.name("email");
	By Password = By.name("password");
	By Re_Password = By.name("confirmPassword");
	By btnSubmit = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[18]/td/input");
    By linkSign_In = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a[1]");
    By UserName1=By.name("userName");
    By Password1 = By.name("password");
    By btnLogin = By.name("login");
    By SigOff = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]");
	public Register_POM(WebDriver driver) {

		this.driver = driver;
	}

	public void setFirstName(String strFirstname) {
		driver.findElement(First_Name).sendKeys(strFirstname);
	}

	public void setLastName(String strLastName) {
		driver.findElement(Last_Name).sendKeys(strLastName);
	}

	public void setPhoneNo(String strPhoneNo) {
		driver.findElement(Phone_No).sendKeys(strPhoneNo);
	}

	public void setEmailId(String strEmail) {
		driver.findElement(Email_Id).sendKeys(strEmail);
	}

	public void setAddress(String strAddress) {
		driver.findElement(Address).sendKeys(strAddress);
	}

	public void setCity(String strCity) {
		driver.findElement(City).sendKeys(strCity);
	}

	public void setProvince(String strProvince) {
		driver.findElement(Province).sendKeys(strProvince);
	}

	public void setPostalCode(String strZipCode) {
		driver.findElement(PostalCode).sendKeys(strZipCode);
	}

	public void setUserName(String strUserName) {
		driver.findElement(UserName).sendKeys(strUserName);
	}

	public void setcountry(String strCountry) {
		
		new Select(driver.findElement(Country)).selectByValue(strCountry);
	}

	public void setPassword(String strPassword) {
		driver.findElement(Password).sendKeys(strPassword);
	}

	public void setConfirmPassword(String strRe_Password) {
		driver.findElement(Re_Password).sendKeys(strRe_Password);
	}
	public void clickRegister() {
		driver.findElement(tabRegister).click();
	}


	public void clickSubmit() {
		driver.findElement(btnSubmit).click();
	}
	public void clickSign_InLink() {
		driver.findElement(linkSign_In).click();
	}
	public void setUserName1(String strUserName1) {
		driver.findElement(UserName1).sendKeys(strUserName1);
	}
	public void setPassword2(String strPassword1) {
		driver.findElement(Password1).sendKeys(strPassword1);
	}
	
	public void clickLogin() {
		driver.findElement(btnLogin).click();
	}
	public void clickLogout() {
		driver.findElement(SigOff).click();
	}
}

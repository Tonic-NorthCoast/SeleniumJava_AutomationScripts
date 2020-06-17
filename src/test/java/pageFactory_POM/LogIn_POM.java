package pageFactory_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn_POM {

	WebDriver driver;
	By Password  = By.name("password");
	By button_SignIn = By.name("login");
	By UserName1=By.name("userName");
    By SigOff = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]");
    By SignIn = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a");

	public LogIn_POM(WebDriver driver) {

		this.driver = driver;
	}
	public void setUsername(String strUsername) {
		driver.findElement(UserName1).sendKeys(strUsername);
	}

	public void setPassword(String strPassword) {
		driver.findElement(Password).sendKeys(strPassword);
	}

	public void clickSignin() {
		driver.findElement(button_SignIn).click();
	}
	public void clickLogout() {
		driver.findElement(SigOff).click();
	}
	public void clickLoginTab() {
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")).click();
	}
}

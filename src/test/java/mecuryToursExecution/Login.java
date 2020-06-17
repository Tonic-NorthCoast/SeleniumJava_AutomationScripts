package mecuryToursExecution;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {
	
	// USING KATOLN STUDIO FOR RECORDING EXECUTION
	
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get("http://newtours.demoaut.com/");
    driver.findElement(By.name("userName")).click();
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("Geraldo");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.xpath("(//input[@name='tripType'])[2]")).click();
    driver.findElement(By.name("fromPort")).click();
    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("New York");
    driver.findElement(By.name("fromPort")).click();
    driver.findElement(By.name("fromMonth")).click();
    driver.findElement(By.name("fromDay")).click();
    new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("19");
    driver.findElement(By.name("fromDay")).click();
    driver.findElement(By.name("toPort")).click();
    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("San Francisco");
    driver.findElement(By.name("toPort")).click();
    driver.findElement(By.name("toDay")).click();
    new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("20");
    driver.findElement(By.name("toDay")).click();
    driver.findElement(By.xpath("(//input[@name='servClass'])[3]")).click();
    driver.findElement(By.name("airline")).click();
    new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Blue Skies Airlines");
    driver.findElement(By.name("airline")).click();
    driver.findElement(By.name("findFlights")).click();
    driver.findElement(By.xpath("(//input[@name='inFlight'])[2]")).click();
    driver.findElement(By.xpath("(//input[@name='outFlight'])[3]")).click();
    driver.findElement(By.name("reserveFlights")).click();
    driver.findElement(By.name("passFirst0")).click();
    driver.findElement(By.name("passFirst0")).clear();
    driver.findElement(By.name("passFirst0")).sendKeys("james");
    driver.findElement(By.name("passLast0")).clear();
    driver.findElement(By.name("passLast0")).sendKeys("Spear");
    driver.findElement(By.name("creditnumber")).click();
    driver.findElement(By.name("creditnumber")).clear();
    driver.findElement(By.name("creditnumber")).sendKeys("12334567");
    driver.findElement(By.name("cc_exp_dt_mn")).click();
    new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByVisibleText("10");
    driver.findElement(By.name("cc_exp_dt_mn")).click();
    driver.findElement(By.name("cc_exp_dt_yr")).click();
    new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByVisibleText("2010");
    driver.findElement(By.name("cc_exp_dt_yr")).click();
    driver.findElement(By.name("cc_frst_name")).click();
    driver.findElement(By.name("cc_frst_name")).clear();
    driver.findElement(By.name("cc_frst_name")).sendKeys("Tonic");
    driver.findElement(By.name("cc_mid_name")).click();
    driver.findElement(By.name("cc_mid_name")).clear();
    driver.findElement(By.name("cc_mid_name")).sendKeys("Mokolo");
    driver.findElement(By.name("cc_last_name")).click();
    driver.findElement(By.name("cc_last_name")).clear();
    driver.findElement(By.name("cc_last_name")).sendKeys("Maoweledi");
    driver.findElement(By.name("ticketLess")).click();
    driver.findElement(By.xpath("(//input[@name='ticketLess'])[2]")).click();
    driver.findElement(By.name("buyFlights")).click();
    driver.findElement(By.xpath("//td[2]/a/img")).click();
    driver.close();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

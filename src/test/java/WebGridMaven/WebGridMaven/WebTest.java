package WebGridMaven.WebGridMaven;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;


public class WebTest {

    //private static final String ACCESS_KEY = System.getenv("access_key");
	private static final String ACCESS_KEY = "eyJ4cC51IjoxMjcsInhwLnAiOjIsInhwLm0iOiJNVFV5TXpnM01qRTVNRFl3TnciLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4NDcwNzcyMDAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.QTZ3Ws3p_LaQ7_GM0xcnfKT7iMqSXG9Cw6V-vubq6ew";
    private WebDriver driver;
    private URL url;
    private DesiredCapabilities dc = new DesiredCapabilities();

    @Parameters({"browser_name"})
    @BeforeMethod
    public void setUp() throws Exception {
    	String browser_name = "chrome";
        url = new URL("https://sales.experitest.com:443/wd/hub");
        dc.setCapability(CapabilityType.BROWSER_NAME, browser_name);
        dc.setCapability(CapabilityType.VERSION, "Any");
        dc.setCapability(CapabilityType.PLATFORM, Platform.ANY);
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("testName", "Grid Demo - Web - " + browser_name);
        driver = new RemoteWebDriver(url, dc);
    }


    @Test
    public void testExperitest() {
        driver.get("https://github.com/login");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("login_field")));
        WebElement username_field = driver.findElement(By.id("login_field"));
        WebElement password_field = driver.findElement(By.id("password"));
        WebElement login_button = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]"));
        username_field.click();
        username_field.sendKeys("Experitest");
        password_field.click();
        password_field.sendKeys("Experitest");
        login_button.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
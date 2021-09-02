package pro.sberlising.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void beforeSuite() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    protected void createBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
    }


}

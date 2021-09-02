package pro.sberlising.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pro.sberlising.base.TestBase;

public class GooglePage extends TestBase {
    public WebDriver driver;
    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchInput = By.cssSelector("[title='Поиск']");

    @Step("openGooglePage")
    public void openGooglePage(){
        driver.get("https://www.google.ru/");
        Helper.waitUntilVisible(driver, searchInput, 3);
    }

    @Step("setTextInGoogleSearch")
    public void setTextInGoogleSearch(String text){
        driver.findElement(searchInput).sendKeys(text);
    }

    @Step("clickSearch")
    public void clickSearch(){
        By searchButton = By.xpath("//*[@value='Поиск в Google']");
        Helper.click(driver, searchButton);
    }

    @Step("openSberLeasingSite")
    public void openSberLeasingSite(){
        By site = By.xpath("//*[text()='https://www.sberleasing.ru/']");
        Helper.waitUntilVisibleAndClick(driver, site, 5);
    }
}

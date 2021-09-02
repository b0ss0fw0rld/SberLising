package pro.sberlising.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

public class SberLisingPage {
    public WebDriver driver;
    public SberLisingPage(WebDriver driver){
        this.driver = driver;
    }

    protected By title = By.xpath("//*[text()='Подобрать авто по параметрам']");

    @Step("openAutoInStock")
    public void openAutoInStock(){
        By autoInStock = By.xpath("//li[@class='header-menu__item']//*[text()='Авто в наличии']");
        Helper.waitUntilVisibleAndClick(driver, autoInStock, 5);
        Helper.waitUntilVisible(driver, title, 4);
    }

    @Step("setCity")
    public void setCity(String city){
        By input = By.xpath("(//input[@class='horizontal-filter-block__search-string'])[1]");
        By checkbox = By.xpath("//label[contains(text(),'" + city + "')]");
        Helper.scrollToElement(driver, title);
        Helper.click(driver, input);
        driver.findElement(input).sendKeys(city);
        Helper.waitUntilVisibleAndClick(driver, checkbox, 2);
    }

    @Step("setBrand")
    public void setBrand(String brand){
        By input = By.xpath("(//input[@class='horizontal-filter-block__search-string'])[2]");
        By checkbox = By.xpath("//label[contains(text(),'" + brand + "')]");
        Helper.click(driver, input);
        driver.findElement(input).sendKeys(brand);
        Helper.waitUntilVisibleAndClick(driver, checkbox, 2);
    }

    @Step("setModel")
    public void setModel(String model){
        By input = By.xpath("(//input[@class='horizontal-filter-block__search-string'])[3]");
        By checkbox = By.xpath("//label[contains(text(),'" + model + "')]");
        Helper.click(driver, input);
        driver.findElement(input).sendKeys(model);
        Helper.waitUntilVisibleAndClick(driver, checkbox, 2);
    }

    @Step("setPriceCar")
    public void setPriceCar(String price){
        closeCommercials();
        By input = By.cssSelector("div.range-slider-values__right input");
        Helper.click(driver, input);
        driver.findElement(input).sendKeys(Keys.BACK_SPACE);
        driver.findElement(input).sendKeys(Keys.BACK_SPACE);
        driver.findElement(input).sendKeys(Keys.BACK_SPACE);
        driver.findElement(input).sendKeys(Keys.BACK_SPACE);
        driver.findElement(input).sendKeys(Keys.BACK_SPACE);
        driver.findElement(input).sendKeys(Keys.DELETE);
        driver.findElement(input).sendKeys(Keys.DELETE);
        driver.findElement(input).sendKeys(price);
    }

    @Step("setTypeDrive")
    public void setTypeDrive(String typeDrive){
        By checkbox = By.xpath("//label[contains(text(),'" + typeDrive + "')]");
        Helper.click(driver, checkbox);
    }

    @Step("setTransmission")
    public void setTransmission(String transmission){
        By checkbox = By.xpath("//label[contains(text(),'" + transmission + "')]");
        Helper.click(driver, checkbox);
    }

    @Step("setBodyType")
    public void setBodyType(String bodyType){
        By checkbox = By.cssSelector("[title='" + bodyType + "']");
        Helper.click(driver, checkbox);
    }

    @Step("setFuelType")
    public void setFuelType(String fuelType){
        By checkbox = By.xpath("//label[contains(text(),'" + fuelType + "')]");
        Helper.scrollToElement(driver, checkbox);
        Helper.click(driver, checkbox);
    }

    @Step("setColor")
    public void setColor(String color){
        By input = By.xpath("(//input[@class='horizontal-filter-block__search-string'])[4]");
        By checkbox = By.xpath("//label[contains(text(),'" + color + "')]");
        Helper.click(driver, input);
        driver.findElement(input).sendKeys(color);
        Helper.waitUntilClickable(driver, checkbox, 5);
        Helper.click(driver, checkbox);
    }

    @Step("clickShowAllOffers")
    public void clickShowAllOffers(){
        By button = By.cssSelector("a.horizontal-filter-block__find-button");
        Helper.scrollToElement(driver, button);
        Helper.click(driver, button);
    }

    public void closeCommercials(){
        By closeCommersial = By.cssSelector("div.modal-present__close");
        By callModalWindow = By.cssSelector("div.comagic-call-generator__close-btn");
        Helper.waitUntilVisibleAndClick(driver, closeCommersial, 10);
    }

    @Step("getCarModelFromListOffer")
    public String getCarModelFromListOffer(){
        By carModel = By.cssSelector("div.font-weight-bold");
        Helper.waitUntilVisible(driver, carModel, 5);
        return driver.findElement(carModel).getText();
    }

    @Step("openOffer")
    public void openOffer(){
        By seeOfferBtn = By.xpath("//*[contains(text(), 'Смотреть предложения')]");
        Helper.waitUntilVisibleAndClick(driver, seeOfferBtn, 3);
    }

    @Step("getCarModelFromOffer")
    public String getCarModelFromOffer(){
        By carModel = By.cssSelector("h1.h2");
        Helper.waitUntilVisible(driver, carModel, 5);
        return driver.findElement(carModel).getText();
    }

    public void waitUntilInVisibleLoadCircular(){
        Helper.waitUntilUnVisible(driver, By.cssSelector("svg.circular"), 5);
    }


}

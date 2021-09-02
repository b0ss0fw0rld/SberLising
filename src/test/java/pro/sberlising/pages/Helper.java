package pro.sberlising.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper {

    public static boolean waitUntilUnVisible(WebDriver driver, By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitUntilClickable(WebDriver driver, By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitUntilVisible(WebDriver driver, By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitUntilVisibleAndClick(WebDriver driver, By locator, int time) {
        Assert.assertTrue(Helper.waitUntilVisible(driver, locator, time), "Элемент " + locator + " не найден");
        Assert.assertTrue(Helper.waitUntilClickable(driver, locator, time), "Элемент " + locator + " не кликабелен");
        Helper.click(driver, locator);
    }

    public static void click(WebDriver driver, By locator) {
        int retryCount = 10;
        for (int i = 0; i < retryCount; i++) {
            waitUntilClickable(driver, locator, 5);
            if (i == 9) {
                driver.findElement(locator).click();
                return;
            }
            try {
                driver.findElement(locator).click();
                return;
            } catch (WebDriverException e) {
                // System.out.print("WebDriverException: " + e.getMessage().);
            }
        }
    }

    public static void scrollToElement(WebDriver driver, By locator) {
        waitUntilVisible(driver, locator, 2);
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}

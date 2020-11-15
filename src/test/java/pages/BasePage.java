package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver _driver;
    protected WebDriverWait _wait;

    protected void sleep(Integer seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void scrollToElement(WebElement element) throws Throwable {
        ((JavascriptExecutor) _driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

    protected void scrollByPixels(Integer pixCount) throws Throwable {
        ((JavascriptExecutor) _driver).executeScript(
            "window.scrollBy(0," + pixCount + ")");
    }

    protected void scrollToBottom() throws Throwable {
        ((JavascriptExecutor) _driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // Value can be positive (scroll down) or negative (scroll up)
    protected void scrollToCoordinate(Integer value) throws Throwable {
        String scrollByStr = "window.scrollBy(0," + value + ")";
        ((JavascriptExecutor) _driver).executeScript(scrollByStr);
    }

    protected WebElement waitForElementVisibility(By locator, Integer timeoutInSeconds) throws Throwable {
        WebDriverWait wait = new WebDriverWait(_driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementToBeClickable(By locator, Integer timeoutInSeconds) throws Throwable {
        WebDriverWait wait = new WebDriverWait(_driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement fluentWaitForElement(By locator, Integer timeoutInSeconds, Integer pollingTimeInSeconds) throws Throwable {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
                .withTimeout(timeoutInSeconds * 1000, TimeUnit.SECONDS)
                .pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(driver -> driver.findElement(locator));
    }
}

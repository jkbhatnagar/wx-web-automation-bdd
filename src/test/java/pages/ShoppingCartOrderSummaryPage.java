package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

import static utils.UtilConstants.WEBDRIVERFLUENTWAIT;

public class ShoppingCartOrderSummaryPage extends BasePage {

    public ShoppingCartOrderSummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
        _wait = new WebDriverWait(_driver, WEBDRIVERFLUENTWAIT);
    }

    String pageTitle = "My Store";

    @FindBy(how = How.CSS, using = "h1.page-heading")
    private WebElement shoppingCartOrderSummaryPageHeading;

    @FindBy(how = How.CSS, using = "#cart_navigation > button[type=\"submit\"]")
    private WebElement confirmOrderButton;

    public Boolean checkPageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean checkPageHeadingText() {
        _wait.until(ExpectedConditions.textMatches(By.cssSelector("h1.page-heading"), Pattern.compile("ORDER SUMMARY")));
        return shoppingCartOrderSummaryPageHeading.getText().contains("ORDER SUMMARY");
    }

    public void chooseConfirmOrderButton() throws Throwable {
        scrollByPixels(600);
        confirmOrderButton.isDisplayed();
        confirmOrderButton.click();
    }

}

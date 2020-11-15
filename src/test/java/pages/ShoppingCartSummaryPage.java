package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

import static utils.UtilConstants.WEBDRIVERFLUENTWAIT;

public class ShoppingCartSummaryPage extends BasePage {

    public ShoppingCartSummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
        _wait = new WebDriverWait(_driver, WEBDRIVERFLUENTWAIT);
    }

    String pageTitle = "Order - My Store";

    @FindBy(how = How.CSS, using = "h1.page-heading")
    private WebElement shoppingCartSummaryPageHeading;

    @FindBy(how = How.CSS, using = "span#summary_products_quantity")
    private WebElement productQuantityLabel;

    @FindBy(how = How.CSS, using = "p.cart_navigation > a[title=\"Proceed to checkout\"]")
    private WebElement proceedToCheckoutButton;

    public Boolean checkPageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean checkPageHeadingText() {
        _wait.until(ExpectedConditions.textMatches(By.cssSelector("h1.page-heading"), Pattern.compile("SHOPPING-CART SUMMARY")));
        return shoppingCartSummaryPageHeading.getText().contains("SHOPPING-CART SUMMARY");
    }

    public Boolean checkPageContent() {
        return productQuantityLabel.getText().matches("\\d+ Products");
    }

    public void chooseProceedToCheckout() throws Throwable {
        scrollByPixels(600);
        proceedToCheckoutButton.isDisplayed();
        proceedToCheckoutButton.click();
    }

}

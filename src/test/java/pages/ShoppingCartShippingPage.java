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

public class ShoppingCartShippingPage extends BasePage {

    public ShoppingCartShippingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
        _wait = new WebDriverWait(_driver, WEBDRIVERFLUENTWAIT);
    }

    String pageTitle = "Order - My Store";

    @FindBy(how = How.CSS, using = "h1.page-heading")
    private WebElement shoppingCartShippingPageHeading;

    @FindBy(how = How.CSS, using = "div.delivery_options_address > p.carrier_title")
    private WebElement carrierTitle;

    @FindBy(how = How.CSS, using = "input#cgv")
    private WebElement agreeCheckbox;

    @FindBy(how = How.CSS, using = "p.cart_navigation > button[type=\"submit\"]")
    private WebElement proceedToCheckoutButton;

    public Boolean checkPageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean checkPageHeadingText() {
        _wait.until(ExpectedConditions.textMatches(By.cssSelector("h1.page-heading"), Pattern.compile("SHIPPING")));
        return shoppingCartShippingPageHeading.getText().contains("SHIPPING");
    }

    public Boolean checkPageContent() {
        return carrierTitle.getText().contains("Choose a shipping option for this address: Home");
    }

    public Boolean acceptTermsAndConditions() throws Throwable {
        scrollByPixels(600);
        agreeCheckbox.isDisplayed();
        agreeCheckbox.click();
        return agreeCheckbox.isSelected();
    }

    public void chooseProceedToCheckout() throws Throwable {
        proceedToCheckoutButton.isDisplayed();
        proceedToCheckoutButton.click();
    }

}

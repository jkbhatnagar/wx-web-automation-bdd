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

public class ShoppingCartAddressPage extends BasePage {

    public ShoppingCartAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
        _wait = new WebDriverWait(_driver, WEBDRIVERFLUENTWAIT);
    }

    String pageTitle = "Order - My Store";

    @FindBy(how = How.CSS, using = "h1.page-heading")
    private WebElement shoppingCartAddressPageHeading;

    @FindBy(how = How.CSS, using = "ul#address_delivery > li:nth-child(1)")
    private WebElement deliveryAddressTitle;

    @FindBy(how = How.CSS, using = "p.cart_navigation > button[type=\"submit\"]")
    private WebElement proceedToCheckoutButton;

    public Boolean checkPageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean checkPageHeadingText() {
        _wait.until(ExpectedConditions.textMatches(By.cssSelector("h1.page-heading"), Pattern.compile("ADDRESSES")));
        return shoppingCartAddressPageHeading.getText().contains("ADDRESSES");
    }

    public Boolean checkPageContent() {
        return deliveryAddressTitle.getText().contains("YOUR DELIVERY ADDRESS");
    }

    public void chooseProceedToCheckout() throws Throwable {
        scrollByPixels(600);
        proceedToCheckoutButton.isDisplayed();
        proceedToCheckoutButton.click();
    }

}

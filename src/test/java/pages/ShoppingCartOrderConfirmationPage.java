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

public class ShoppingCartOrderConfirmationPage extends BasePage {

    public ShoppingCartOrderConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
        _wait = new WebDriverWait(_driver, WEBDRIVERFLUENTWAIT);
    }

    String pageTitle = "Order confirmation - My Store";

    @FindBy(how = How.CSS, using = "h1.page-heading")
    private WebElement shoppingCartOrderConfirmationPageHeading;

    @FindBy(how = How.CSS, using = "#cart_navigation > button[type=\"submit\"]")
    private WebElement confirmOrderButton;

    @FindBy(how = How.CSS, using = "div.box > p > strong.dark")
    private WebElement confirmOrderText;


    public Boolean checkPageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean checkPageHeadingText() {
        _wait.until(ExpectedConditions.textMatches(By.cssSelector("h1.page-heading"), Pattern.compile("ORDER CONFIRMATION")));
        return shoppingCartOrderConfirmationPageHeading.getText().contains("ORDER CONFIRMATION");
    }

    public Boolean checkShoppingCartConfirmationPageContent() throws Throwable {
        sleep(10);
        return confirmOrderText.getText().contains("Your order on My Store is complete.");
        //This line is just to show the final screen bit longer for the demo. Avoid sleep statements in real test runs.
    }
}

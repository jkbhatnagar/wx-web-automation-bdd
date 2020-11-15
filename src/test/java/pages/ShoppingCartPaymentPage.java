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

public class ShoppingCartPaymentPage extends BasePage {

    public ShoppingCartPaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
        _wait = new WebDriverWait(_driver, WEBDRIVERFLUENTWAIT);
    }

    String pageTitle = "Order - My Store";

    @FindBy(how = How.CSS, using = "h1.page-heading")
    private WebElement shoppingCartPaymentPageHeading;

    @FindBy(how = How.CSS, using = "a.bankwire")
    private WebElement bankwireButton;

    public Boolean checkPageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean checkPageHeadingText() {
        _wait.until(ExpectedConditions.textMatches(By.cssSelector("h1.page-heading"), Pattern.compile("PLEASE CHOOSE YOUR PAYMENT METHOD")));
        return shoppingCartPaymentPageHeading.getText().contains("PLEASE CHOOSE YOUR PAYMENT METHOD");
    }

    public void chooseBankwire() throws Throwable {
        scrollByPixels(600);
        bankwireButton.isDisplayed();
        bankwireButton.click();
    }

}

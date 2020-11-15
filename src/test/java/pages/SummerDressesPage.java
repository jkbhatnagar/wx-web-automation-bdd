package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class SummerDressesPage extends BasePage {

    public SummerDressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
        _wait = new WebDriverWait(_driver, WEBDRIVERFLUENTWAIT);
    }

    String pageTitle = "Summer Dresses - My Store";

    @FindBy(how = How.CSS, using = "h1.page-heading")
    private WebElement summerDressesPageHeading;

    @FindBy(how = How.CSS, using = "ul.product_list > li:nth-child(1)")
    private WebElement summerDress1;

    @FindBy(how = How.CSS, using = "ul.product_list > li:nth-child(1) a.ajax_add_to_cart_button")
    private WebElement summerDress1AddToCart;

    @FindBy(how = How.CSS, using = "ul.product_list > li:nth-child(2)")
    private WebElement summerDress2;

    @FindBy(how = How.CSS, using = "ul.product_list > li:nth-child(2) a.ajax_add_to_cart_button")
    private WebElement summerDress2AddToCart;

    @FindBy(how = How.CSS, using = "div.clearfix > div.layer_cart_product > h2")
    private WebElement cartActionMsg;

    @FindBy(how = How.CSS, using = "div.clearfix > div.layer_cart_cart > div.button-container > span.continue")
    private WebElement continueShoppingButton;

    @FindBy(how = How.CSS, using = "div.clearfix > div.layer_cart_cart > div.button-container > a[title=\"Proceed to checkout\"]")
    private WebElement proceedToCheckoutButton;

    public Boolean checkPageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean checkPageHeadingText() {
        _wait.until(ExpectedConditions.textMatches(By.cssSelector("h1.page-heading"), Pattern.compile("SUMMER DRESSES")));
        return summerDressesPageHeading.getText().contains("SUMMER DRESSES");
    }

    public void chooseSummerDress1() throws Throwable {
        scrollByPixels(600);
        Actions actions = new Actions(_driver);
        actions.moveToElement(summerDress1, 50, 50).perform();
        summerDress1AddToCart.isDisplayed();
        summerDress1AddToCart.click();
        actions = null;
    }

    public Boolean checkSummerDress1AddedSuccessfully() {
        _wait.until(ExpectedConditions.visibilityOf(cartActionMsg));

        Boolean check_cartIsDisplayed = cartActionMsg.isDisplayed();
        Boolean check_cartActionMsgDisplayed = cartActionMsg.getText().contains("Product successfully added to your shopping cart");
        Boolean check_continueShoppingButtonIsDisplayed = continueShoppingButton.isDisplayed();
        Boolean check_continueShoppingButtonText = continueShoppingButton.getText().contains("Continue shopping");
        return check_cartIsDisplayed & check_cartActionMsgDisplayed & check_continueShoppingButtonIsDisplayed & check_continueShoppingButtonText;
    }

    public void chooseContinueShopping() {
        continueShoppingButton.click();
    }

    public void chooseSummerDress2() {
        Actions actions = new Actions(_driver);
        actions.moveToElement(summerDress2, 50, 50).perform();
        summerDress2AddToCart.isDisplayed();
        summerDress2AddToCart.click();
        actions = null;
    }

    public Boolean checkSummerDress2AddedSuccessfully() {
        _wait.until(ExpectedConditions.visibilityOf(cartActionMsg));

        Boolean check_cartIsDisplayed = cartActionMsg.isDisplayed();
        Boolean check_cartActionMsgDisplayed = cartActionMsg.getText().contains("Product successfully added to your shopping cart");
        Boolean check_proceedToCheckoutButtonIsDisplayed = proceedToCheckoutButton.isDisplayed();
        Boolean check_proceedToCheckoutButtonText = proceedToCheckoutButton.getText().contains("Proceed to checkout");
        return check_cartIsDisplayed & check_cartActionMsgDisplayed & check_proceedToCheckoutButtonIsDisplayed & check_proceedToCheckoutButtonText;
    }

    public void chooseProceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}

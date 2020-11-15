package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.UtilConstants.WEBDRIVERFLUENTWAIT;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
        _wait = new WebDriverWait(_driver, WEBDRIVERFLUENTWAIT);
    }

    String pageTitle = "My account - My Store";

    @FindBy(how = How.CSS, using = "h1.page-heading")
    private WebElement myAccountPageHeading;

    @FindBy(how = How.CSS, using = "div#block_top_menu > ul > li > a[title=\"Dresses\"]")
    private WebElement dressesMenuLabel;

    public Boolean checkPageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean checkPageHeadingText() {
        _wait.until(ExpectedConditions.textToBe(By.cssSelector("h1.page-heading"),"MY ACCOUNT"));
        return myAccountPageHeading.getText().equals("MY ACCOUNT");
    }

    public Boolean checkDressesMenuLabel() { return dressesMenuLabel.isDisplayed(); }
    public void clickDressesMenuLabel() {
        dressesMenuLabel.click();
    }

}

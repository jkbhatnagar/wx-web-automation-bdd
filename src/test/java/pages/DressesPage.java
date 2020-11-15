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

public class DressesPage extends BasePage {

    public DressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
        _wait = new WebDriverWait(_driver, WEBDRIVERFLUENTWAIT);
    }

    String pageTitle = "Dresses - My Store";

    @FindBy(how = How.CSS, using = "h1.page-heading")
    private WebElement pageHeading;

    @FindBy(how = How.CSS, using = "div#subcategories > ul > li:nth-child(3) > div.subcategory-image > a[title=\"Summer Dresses\"]")
    private WebElement summerDressesSubcategory;

    public Boolean checkPageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean checkPageHeadingText() {
        _wait.until(ExpectedConditions.textMatches(By.cssSelector("h1.page-heading"), Pattern.compile("DRESSES")));
        return pageHeading.getText().contains("DRESSES");
    }

    public Boolean checkSummerDressesSubcategory() { return summerDressesSubcategory.isDisplayed(); }

    public void clickSummerDressesSubcategory() throws Throwable {
        scrollByPixels(300);
        summerDressesSubcategory.click();
    }

}

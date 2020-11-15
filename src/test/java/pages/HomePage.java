package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this._driver = driver;
    }

    String pageTitle = "My Store";

    @FindBy(how = How.CSS, using = "div.header_user_info a.login")
    private WebElement signInButton;

    public Boolean checkPageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }
    public Boolean checkSignInButton() {
        return signInButton.isDisplayed();
    }
    public void clickSignInButton() {
        signInButton.click();
    }
}

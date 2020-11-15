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

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
        _wait = new WebDriverWait(_driver, WEBDRIVERFLUENTWAIT);
    }

    String pageTitle = "Login - My Store";

    @FindBy(how = How.CSS, using = "h1.page-heading")
    private WebElement loginPageHeading;

    @FindBy(how = How.CSS, using = "input#email")
    private WebElement emailTextbox;

    @FindBy(how = How.CSS, using = "input#passwd")
    private WebElement passwordTextbox;

    @FindBy(how = How.CSS, using = "button#SubmitLogin")
    private WebElement signInButton;

    public Boolean checkPageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean checkPageHeadingText() {
        _wait.until(ExpectedConditions.textToBe(By.cssSelector("h1.page-heading"),"AUTHENTICATION"));
        return loginPageHeading.getText().equals("AUTHENTICATION");
    }

    public Boolean checkEmailTextbox() { return passwordTextbox.isDisplayed(); }
    public Boolean checkPasswordTextbox() { return passwordTextbox.isDisplayed(); }
    public Boolean checkSignInButton() { return signInButton.isDisplayed(); }

    public void enterEmail(String email) {
        emailTextbox.sendKeys(email);
    }

    public void enterPassword(String pwd) {
        passwordTextbox.sendKeys(pwd);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

}

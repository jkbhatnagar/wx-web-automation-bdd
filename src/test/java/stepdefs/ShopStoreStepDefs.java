package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

import pages.*;
import utils.UtilConstants;

import java.util.concurrent.TimeUnit;

import static utils.UtilConstants.TEST_ENDPOINT;
import static utils.UtilConstants.USERNAME;
import static utils.UtilConstants.PASSWORD;

public class ShopStoreStepDefs {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    DressesPage dressesPage;
    SummerDressesPage summerDressesPage;
    ShoppingCartSummaryPage shoppingCartSummaryPage;
    ShoppingCartAddressPage shoppingCartAddressPage;
    ShoppingCartShippingPage shoppingCartShippingPage;
    ShoppingCartPaymentPage shoppingCartPaymentPage;
    ShoppingCartOrderSummaryPage shoppingCartOrderSummaryPage;
    ShoppingCartOrderConfirmationPage shoppingCartOrderConfirmationPage;
    //    static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

    // region StepsBase
    @Given("I open a browser and launch the application")
    public void open_a_browser_and_launch_the_application() {
        try {
            if(System.getProperty("exemode").equals("remote")) {
                if(System.getProperty("browser").equals("chrome")){
                    System.setProperty("webdriver.chrome.driver", "drivers/linux/chromedriver");
                    DesiredCapabilities dc = DesiredCapabilities.chrome();
                    dc.setBrowserName("chrome");
                    dc.setPlatform(Platform.LINUX);
                    driver = new RemoteWebDriver(new URL(UtilConstants.ENDPOINT_SELENIUM_HUB), dc);
                }
            }
            else{
                String osName = "";
                if(System.getProperty("osname").equals("windows")) {osName = "windows";}
                else if(System.getProperty("osname").equals("mac")) {osName = "mac";}
                else {osName = "linux";}

                if(System.getProperty("browser").equals("chrome")){
                    System.setProperty("webdriver.chrome.driver", "drivers/" + osName + "/chromedriver");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized");
                    options.addArguments("incognito");
                    options.addArguments("disable-infobars");
                    driver = new ChromeDriver(options);
                }
            }

            if(driver!=null){
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
                driver.get(TEST_ENDPOINT);
            }
        }
        catch(Exception e){
            e.printStackTrace();
//            System.exit(1);
        }
    }

    // endregion

    // region HOME PAGE
    @And("I am on Home Page")
    public void homepage_i_am_on_home_page() {
        homePage = new HomePage(driver);
        Assert.assertTrue("HomePage : Page title not as expected", homePage.checkPageTitle());
        Assert.assertTrue("HomePage : Sign in link at top right corner not as expected", homePage.checkSignInButton());
        homePage.clickSignInButton();
    }

    @And("I sign in using username and password")
    public void sign_in() {
        loginPage = new LoginPage(driver);
        Assert.assertTrue("LoginPage : Page title not as expected", loginPage.checkPageTitle());
        Assert.assertTrue("LoginPage : Page label not as expected", loginPage.checkPageHeadingText());
        Assert.assertTrue("LoginPage : Email input not as expected", loginPage.checkEmailTextbox());
        Assert.assertTrue("LoginPage : Password input not as expected", loginPage.checkPasswordTextbox());
        Assert.assertTrue("LoginPage : Sign in button not as expected", loginPage.checkSignInButton());

        loginPage.enterEmail(USERNAME);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickSignInButton();
    }

    @And("I choose Dresses menu")
    public void choose_dresses_menu() throws Exception {
        myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue("MyAccountPage : Page title not as expected", myAccountPage.checkPageTitle());
        Assert.assertTrue("MyAccountPage : Page label not as expected", myAccountPage.checkPageHeadingText());
        Assert.assertTrue("MyAccountPage : Dress top menu not as expected", myAccountPage.checkDressesMenuLabel());

        myAccountPage.clickDressesMenuLabel();
    }

    @When("I choose Summer Dresses subcategory")
    public void choose_summer_dresses_subcategory() throws Throwable {
        dressesPage = new DressesPage(driver);
        Assert.assertTrue("DressesPage : Page title not as expected", dressesPage.checkPageTitle());
        Assert.assertTrue("DressesPage : Page label not as expected", dressesPage.checkPageHeadingText());
        Assert.assertTrue("DressesPage : Summer Dress Subcategory not as expected", dressesPage.checkSummerDressesSubcategory());

        dressesPage.clickSummerDressesSubcategory();
    }

    @When("I am on SUMMER DRESSES screen")
    public void check_summer_dresses_screen() throws Exception {
        summerDressesPage = new SummerDressesPage(driver);
        Assert.assertTrue("SummerDressesPage : Page title not as expected", summerDressesPage.checkPageTitle());
        Assert.assertTrue("SummerDressesPage : Page label not as expected", summerDressesPage.checkPageHeadingText());
    }

    @When("I add first dress to cart")
    public void add_first_dress() throws Throwable {
        summerDressesPage.chooseSummerDress1();
        Assert.assertTrue("SummerDressesPage : Summer dress 1 not added as expected", summerDressesPage.checkSummerDress1AddedSuccessfully());
    }

    @When("I choose to Continue Shopping")
    public void choose_continue_shopping() throws Exception {
        summerDressesPage.chooseContinueShopping();
    }

    @When("I add second dress to cart")
    public void add_second_dress() throws Exception {
        summerDressesPage.chooseSummerDress2();
        Assert.assertTrue("SummerDressesPage : Summer dress 2 not added as expected", summerDressesPage.checkSummerDress2AddedSuccessfully());
    }

    @When("I choose to Proceed to checkout to cart summary")
    public void proceed_to_checkout_to_cart() throws Exception {
        summerDressesPage.chooseProceedToCheckout();
    }

    @When("I am on SHOPPING-CART SUMMARY screen")
    public void check_shopping_cart_summary_screen() throws Exception {
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        Assert.assertTrue("ShoppingCartSummaryPage : Page title not as expected", shoppingCartSummaryPage.checkPageTitle());
        Assert.assertTrue("ShoppingCartSummaryPage : Page label not as expected", shoppingCartSummaryPage.checkPageHeadingText());
        Assert.assertTrue("ShoppingCartSummaryPage : Page content not as expected", shoppingCartSummaryPage.checkPageContent());
    }

    @When("I choose to Proceed to checkout to cart address")
    public void proceed_to_checkout_to_address() throws Throwable {
        shoppingCartSummaryPage.chooseProceedToCheckout();
    }

    @When("I am on ADDRESS screen")
    public void check_shopping_cart_address_screen() throws Exception {
        shoppingCartAddressPage = new ShoppingCartAddressPage(driver);
        Assert.assertTrue("ShoppingCartAddressPage : Page title not as expected", shoppingCartAddressPage.checkPageTitle());
        Assert.assertTrue("ShoppingCartAddressPage : Page label not as expected", shoppingCartAddressPage.checkPageHeadingText());
        Assert.assertTrue("ShoppingCartAddressPage : Page content not as expected", shoppingCartAddressPage.checkPageContent());
    }

    @When("I choose to Proceed to checkout to cart shipping")
    public void proceed_to_checkout_shipping() throws Throwable {
        shoppingCartAddressPage.chooseProceedToCheckout();
    }

    @When("I am on SHIPPING screen")
    public void check_shopping_cart_shipping_screen() throws Throwable {
        shoppingCartShippingPage = new ShoppingCartShippingPage(driver);
        Assert.assertTrue("ShoppingCartShippingPage : Page title not as expected", shoppingCartShippingPage.checkPageTitle());
        Assert.assertTrue("ShoppingCartShippingPage : Page label not as expected", shoppingCartShippingPage.checkPageHeadingText());
        Assert.assertTrue("ShoppingCartShippingPage : Page content not as expected", shoppingCartShippingPage.checkPageContent());
        Assert.assertTrue("ShoppingCartShippingPage : T&C state not as expected", shoppingCartShippingPage.acceptTermsAndConditions());
    }

    @When("I choose to Proceed to checkout to cart payment")
    public void proceed_to_checkout_payment() throws Throwable {
        shoppingCartShippingPage.chooseProceedToCheckout();
    }

    @When("I am on PAYMENT screen")
    public void check_shopping_cart_payment_screen() throws Throwable {
        shoppingCartPaymentPage = new ShoppingCartPaymentPage(driver);
        Assert.assertTrue("ShoppingCartPaymentPage : Page title not as expected", shoppingCartPaymentPage.checkPageTitle());
        Assert.assertTrue("ShoppingCartPaymentPage : Page label not as expected", shoppingCartPaymentPage.checkPageHeadingText());
    }

    @When("I choose to Bankwire payment")
    public void proceed_to_bankwire_payment() throws Throwable {
        shoppingCartPaymentPage.chooseBankwire();
    }

    @When("I am on ORDER SUMMARY screen")
    public void check_order_summary_screen() throws Throwable {
        shoppingCartOrderSummaryPage = new ShoppingCartOrderSummaryPage(driver);
        Assert.assertTrue("ShoppingCartOrderSummaryPage : Page title not as expected", shoppingCartOrderSummaryPage.checkPageTitle());
        Assert.assertTrue("ShoppingCartOrderSummaryPage : Page label not as expected", shoppingCartOrderSummaryPage.checkPageHeadingText());
    }

    @When("I confirm order")
    public void confirm_order() throws Throwable {
        shoppingCartOrderSummaryPage.chooseConfirmOrderButton();
    }

    @Then("I am on ORDER CONFIRMATION screen")
    public void check_order_confirmation_screen() throws Throwable {
        shoppingCartOrderConfirmationPage = new ShoppingCartOrderConfirmationPage(driver);
        Assert.assertTrue("ShoppingCartOrderConfirmationPage : Page title not as expected", shoppingCartOrderConfirmationPage.checkPageTitle());
        Assert.assertTrue("ShoppingCartOrderConfirmationPage : Page label not as expected", shoppingCartOrderConfirmationPage.checkPageHeadingText());
        Assert.assertTrue("ShoppingCartOrderConfirmationPage : Page content not as expected", shoppingCartOrderConfirmationPage.checkShoppingCartConfirmationPageContent());
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}

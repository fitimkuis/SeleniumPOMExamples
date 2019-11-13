package pagefactory;


import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import operation.ReadObject;

public class KatalonLoginPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "#sidebar-wrapper ul.sidebar-nav li:nth-of-type(1) a")
    @CacheLookup
    private WebElement curaHealthcare;

    @FindBy(css = "#login div.container div.row div:nth-of-type(2) form.form-horizontal div:nth-of-type(1) div:nth-of-type(1) div.col-sm-8 div.input-group input.form-control[type='text']")
    @CacheLookup
    private WebElement demoAccount1;

    @FindBy(css = "#login div.container div.row div:nth-of-type(2) form.form-horizontal div:nth-of-type(1) div:nth-of-type(2) div.col-sm-offset-4.col-sm-8 div.input-group input.form-control[type='text']")
    @CacheLookup
    private WebElement demoAccount2;

    @FindBy(css = "#sidebar-wrapper ul.sidebar-nav li:nth-of-type(2) a")
    @CacheLookup
    private WebElement home;

    @FindBy(css = "a[href='mailto:info@katalon.com']")
    @CacheLookup
    private WebElement infokatalonCom;

    @FindBy(css = "a[href='profile.php#login']")
    @CacheLookup
    private WebElement login1;

    @FindBy(id = "btn-login")
    @CacheLookup
    private WebElement login2;

    @FindBy(id = "btn-make-appointment")
    @CacheLookup
    private WebElement makeAppointment;

    private final String pageLoadedText = "Please login to make appointment";

    private final String pageUrl = "/profile.php#login";

    @FindBy(id = "txt-password")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "txt-username")
    @CacheLookup
    private WebElement username;

    public KatalonLoginPage() {
    }

    public KatalonLoginPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public KatalonLoginPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public KatalonLoginPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Cura Healthcare Link.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage clickCuraHealthcareLink() {
        curaHealthcare.click();
        return this;
    }

    /**
     * Click on Home Link.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage clickHomeLink() {
        home.click();
        return this;
    }

    /**
     * Click on Infokatalon.com Link.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage clickInfokatalonComLink() {
        infokatalonCom.click();
        return this;
    }

    /**
     * Click on Login Button.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage clickLogin1Button() {
        login1.click();
        return this;
    }

    /**
     * Click on Login Button.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage clickLogin2Button() {
        login2.click();
        return this;
    }

    /**
     * Click on Make Appointment Link.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage clickMakeAppointmentLink() {
        makeAppointment.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the katalonLoginPage class instance.
     */
    /*public KatalonLoginPage fill() {
        setDemoAccount1TextField();
        setDemoAccount2TextField();
        setUsernameTextField();
        setPasswordPasswordField();
        return this;
    }*/

    public KatalonLoginPage fill() throws IOException {
        ReadObject object = new ReadObject();
        Properties allObjects = object.getObjectRepository();
        setUsernameTextField(allObjects.getProperty("katalonUser"));
        setPasswordPasswordField(allObjects.getProperty("katalonPassword"));
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the katalonLoginPage class instance.
     */
    /*public KatalonLoginPage fillAndSubmit() {
        fill();
        return submit();
    }*/

    /**
     * Set default value to Demo Account Text field.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage setDemoAccount1TextField() {
        return setDemoAccount1TextField(data.get("DEMO_ACCOUNT_1"));
    }

    /**
     * Set value to Demo Account Text field.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage setDemoAccount1TextField(String demoAccount1Value) {
        demoAccount1.sendKeys(demoAccount1Value);
        return this;
    }

    /**
     * Set default value to Demo Account Text field.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage setDemoAccount2TextField() {
        return setDemoAccount2TextField(data.get("DEMO_ACCOUNT_2"));
    }

    /**
     * Set value to Demo Account Text field.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage setDemoAccount2TextField(String demoAccount2Value) {
        demoAccount2.sendKeys(demoAccount2Value);
        return this;
    }

    /**
     * Set default value to Password Password field.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage setPasswordPasswordField() {
        return setPasswordPasswordField(data.get("PASSWORD"));
    }

    /**
     * Set value to Password Password field.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage setPasswordPasswordField(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    /**
     * Set default value to Username Text field.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage setUsernameTextField() {
        return setUsernameTextField(data.get("USERNAME"));
    }

    /**
     * Set value to Username Text field.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage setUsernameTextField(String usernameValue) {
        username.sendKeys(usernameValue);
        return this;
    }

    //Click on login button
    public void clickLoginButton(){
        login2.click();
    }

    /**
     * Submit the form to target page.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage submit() {
        clickLoginButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonLoginPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    //Get the User name from Home Page
    public String getLoginPageContains(){
        return    pageLoadedText.toString();
    }
}

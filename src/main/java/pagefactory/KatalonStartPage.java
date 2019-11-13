package pagefactory;

import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KatalonStartPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "#sidebar-wrapper ul.sidebar-nav li:nth-of-type(1) a")
    @CacheLookup
    private WebElement curaHealthcare;

    @FindBy(css = "#sidebar-wrapper ul.sidebar-nav li:nth-of-type(2) a")
    @CacheLookup
    private WebElement home;

    @FindBy(css = "a[href='mailto:info@katalon.com']")
    @CacheLookup
    private WebElement infokatalonCom;

    @FindBy(css = "a[href='profile.php#login']")
    @CacheLookup
    private WebElement login;

    @FindBy(id = "btn-make-appointment")
    @CacheLookup
    private WebElement makeAppointment;

    private final String pageLoadedText = "Copyright © CURA Healthcare Service 2019";

    private final String pageUrl = "/";

    public KatalonStartPage() {
    }

    public KatalonStartPage(WebDriver driver) {
        this();
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public KatalonStartPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public KatalonStartPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    //Get the title of Login Page
    /*public String getLoginTitle(){
        return pageLoadedText.getText();
    }*/

    /**
     * Click on Cura Healthcare Link.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonStartPage clickCuraHealthcareLink() {
        curaHealthcare.click();
        return this;
    }

    /**
     * Click on Home Link.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonStartPage clickHomeLink() {
        home.click();
        return this;
    }

    /**
     * Click on Infokatalon.com Link.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonStartPage clickInfokatalonComLink() {
        infokatalonCom.click();
        return this;
    }

    /**
     * Click on Login Link.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonStartPage clickLoginLink() {
        login.click();
        return this;
    }

    /**
     * Click on Make Appointment Link.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonStartPage clickMakeAppointmentLink() {
        makeAppointment.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the katalonLoginPage class instance.
     */
    public KatalonStartPage verifyPageLoaded() {
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
    public KatalonStartPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    public String verifyPageTxt(){
        return pageLoadedText;
    }
}


package pagefactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MakeAppointment {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "div.col-xs-12:nth-child(1) > h2:nth-child(1)")
    private WebElement AppointmentConfirmation;

    @FindBy(css = "#appointment > div > div > div > h2")
    private WebElement headerText;

    @FindBy(id = "chk_hospotal_readmission")
    @CacheLookup
    private WebElement applyForHospitalReadmission;

    @FindBy(id = "btn-book-appointment")
    @CacheLookup
    private WebElement bookAppointment;

    @FindBy(id = "txt_comment")
    @CacheLookup
    private WebElement comment;

    @FindBy(css = "#sidebar-wrapper ul.sidebar-nav li:nth-of-type(1) a")
    @CacheLookup
    private WebElement curaHealthcare;

    @FindBy(id = "combo_facility")
    @CacheLookup
    private WebElement facility;

    @FindBy(css = "a[href='history.php#history']")
    @CacheLookup
    private WebElement history;

    @FindBy(css = "#sidebar-wrapper ul.sidebar-nav li:nth-of-type(2) a")
    @CacheLookup
    private WebElement home;

    @FindBy(css = "a[href='mailto:info@katalon.com']")
    @CacheLookup
    private WebElement infokatalonCom;

    @FindBy(css = "a[href='authenticate.php?logout']")
    @CacheLookup
    private WebElement logout;

    @FindBy(id = "btn-make-appointment")
    @CacheLookup
    private WebElement makeAppointment;

    @FindBy(name = "programs")
    @CacheLookup
    private List<WebElement> none1;

    @FindBy(name = "programs")
    @CacheLookup
    private List<WebElement> none2;

    @FindBy(name = "programs")
    @CacheLookup
    private List<WebElement> none3;

    private final String noneValue1 = "Medicare";

    private final String noneValue2 = "Medicaid";

    private final String noneValue3 = "None";

    private final String pageLoadedText = "Copyright © CURA Healthcare Service 2019";

    private final String pageUrl = "/#appointment";

    @FindBy(css = "a[href='profile.php#profile']")
    @CacheLookup
    private WebElement profile;

    @FindBy(id = "txt_visit_date")
    @CacheLookup
    private WebElement visitDateRequired;

    public MakeAppointment() {
    }

    public MakeAppointment(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MakeAppointment(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public MakeAppointment(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Book Appointment Button.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment clickBookAppointmentButton() {
        bookAppointment.click();
        return this;
    }

    /**
     * Click on Cura Healthcare Link.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment clickCuraHealthcareLink() {
        curaHealthcare.click();
        return this;
    }

    /**
     * Click on History Link.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment clickHistoryLink() {
        history.click();
        return this;
    }

    /**
     * Click on Home Link.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment clickHomeLink() {
        home.click();
        return this;
    }

    /**
     * Click on Infokatalon.com Link.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment clickInfokatalonComLink() {
        infokatalonCom.click();
        return this;
    }

    /**
     * Click on Logout Link.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment clickLogoutLink() {
        logout.click();
        return this;
    }

    /**
     * Click on Make Appointment Link.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment clickMakeAppointmentLink() {
        makeAppointment.click();
        return this;
    }

    /**
     * Click on Profile Link.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment clickProfileLink() {
        profile.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment fill() {
        setFacilityDropDownListField("Hongkong CURA Healthcare Center");
        setApplyForHospitalReadmissionCheckboxField();
        setNone1RadioButtonField();
        setNone2RadioButtonField();
        setNone3RadioButtonField();
        setVisitDateRequiredTextField("30/11/2019");
        setCommentTextareaField("Hello Katalon");
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set Apply For Hospital Readmission Checkbox field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment setApplyForHospitalReadmissionCheckboxField() {
        if (!applyForHospitalReadmission.isSelected()) {
            applyForHospitalReadmission.click();
        }
        return this;
    }

    /**
     * Set default value to Comment Textarea field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment setCommentTextareaField() {
        return setCommentTextareaField(data.get("COMMENT"));
    }

    /**
     * Set value to Comment Textarea field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment setCommentTextareaField(String commentValue) {
        comment.sendKeys(commentValue);
        return this;
    }

    /**
     * Set default value to Facility Drop Down List field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment setFacilityDropDownListField() {
        return setFacilityDropDownListField(data.get("FACILITY"));
    }

    /**
     * Set value to Facility Drop Down List field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment setFacilityDropDownListField(String facilityValue) {
        new Select(facility).selectByVisibleText(facilityValue);
        return this;
    }

    public MakeAppointment setFacilityDropDownListFieldByIndex(int index) {
        new Select(facility).selectByIndex(index);
        return this;
    }

    /**
     * Set default value to None Radio Button field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment setNone1RadioButtonField() {
        for (WebElement el : none1) {
            if (el.getAttribute("value").equals(noneValue1)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to None Radio Button field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment setNone2RadioButtonField() {
        for (WebElement el : none2) {
            if (el.getAttribute("value").equals(noneValue2)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to None Radio Button field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment setNone3RadioButtonField() {
        for (WebElement el : none3) {
            if (el.getAttribute("value").equals(noneValue3)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Visit Date Required Text field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment setVisitDateRequiredTextField() {
        return setVisitDateRequiredTextField(data.get("VISIT_DATE_REQUIRED"));
    }

    /**
     * Set value to Visit Date Required Text field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment setVisitDateRequiredTextField(String visitDateRequiredValue) {
        visitDateRequired.sendKeys(visitDateRequiredValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment submit() {
        clickBookAppointmentButton();
        return this;
    }

    /**
     * Unset Apply For Hospital Readmission Checkbox field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment unsetApplyForHospitalReadmissionCheckboxField() {
        if (applyForHospitalReadmission.isSelected()) {
            applyForHospitalReadmission.click();
        }
        return this;
    }

    /**
     * Unset default value from Facility Drop Down List field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment unsetFacilityDropDownListField() {
        return unsetFacilityDropDownListField(data.get("FACILITY"));
    }

    /**
     * Unset value from Facility Drop Down List field.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment unsetFacilityDropDownListField(String facilityValue) {
        new Select(facility).deselectByVisibleText(facilityValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment verifyPageLoaded() {
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
     * @return the MakeAppointment class instance.
     */
    public MakeAppointment verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    //Get the MakeAppointment header text
    public String getMakeAppointmentPageHeaderText(){
        return   headerText.getText();
    }

    //Get the MakeAppointment header text
    public String getAppointmentConfirmationText(){
        return   AppointmentConfirmation.getText();
    }
}

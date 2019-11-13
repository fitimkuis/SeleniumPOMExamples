package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagefactory.MakeAppointment;
import pagefactory.KatalonStartPage;
import pagefactory.KatalonLoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestKatalonLoginWithPageFactory {

    WebDriver driver;
    KatalonStartPage objLogin;
    MakeAppointment objMakeAppointment;
    KatalonLoginPage objLoginPage;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    /**
     * This test go to http://demo.guru99.com/V4/
     * <p>
     * Verify login page title as guru99 bank
     * <p>
     * Login to application
     * <p>
     * Verify the home page using Dashboard message
     */

    @Test(priority = 0)
    public void testKatalonDemoPage() throws IOException {

            //Create Start Page object
            Reporter.log("Create Start Page object");
            objLogin = new KatalonStartPage(driver);

            //Verify start page txt
            Assert.assertEquals(objLogin.verifyPageTxt(),"Copyright © CURA Healthcare Service 2019");

            //select Make Appointment button
            Reporter.log("select Make Appointment button");
            objLogin.clickMakeAppointmentLink();
            //login to application
            //objLogin.loginToGuru99("mgr123", "mgr!23");

            // go the next page
            Reporter.log("go the next page");
            objLoginPage = new KatalonLoginPage(driver);

            //fill login fields in login Page and submit page
            Reporter.log("fill login fields in login Page and submit page");
            objLoginPage.fill()
                    //.setUsernameTextField()
                    //.setPasswordPasswordField()
                    .submit();

            //Verify login page
            Assert.assertTrue(objLoginPage.getLoginPageContains().contains("Please login to make appointment"));

            // go the next page
            objMakeAppointment = new MakeAppointment(driver);
            //verify next page header
            Assert.assertTrue(objMakeAppointment.getMakeAppointmentPageHeaderText().equals("Make Appointment"));

            //objMakeAppointment.setFacilityDropDownListField("Hongkong CURA Healthcare Center");
            objMakeAppointment.setFacilityDropDownListFieldByIndex(2);
            objMakeAppointment.setApplyForHospitalReadmissionCheckboxField();
            objMakeAppointment.setNone2RadioButtonField();
            objMakeAppointment.setVisitDateRequiredTextField("30/11/2019");
            objMakeAppointment.setCommentTextareaField("Hello Katalon");
            objMakeAppointment.submit();

        /*objMakeAppointment.fill()
                .setFacilityDropDownListField()
                .setApplyForHospitalReadmissionCheckboxField()
                .setNone2RadioButtonField()
                .setVisitDateRequiredTextField()
                .setCommentTextareaField()
                .submit();*/

            //get AppointmentConfirmation header text
            String url = objMakeAppointment.getAppointmentConfirmationText();
            Assert.assertEquals(url, "Appointment Confirmation");

            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);;
    }

    @AfterTest
    public void endSession(){
        driver.close();
    }
}

package selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.testng.annotations.Test;
import selenium.pom.ReceiptPage;
import selenium.pom.SignUpPage;

public class SignUpFormTest extends BaseTest {

    @Test(priority = 0)
    public void signUp(){

        //*************PAGE INSTANTIATIONS*************
        SignUpPage signUpPage = new SignUpPage(driver);
        driver.get("http://www.kimschiller.com/page-object-pattern-tutorial/index.html");
        assertTrue(signUpPage.isInitialized());

        signUpPage.enterName("First", "Last");
        signUpPage.enterAddress("123 Street", "12345");

        ReceiptPage receiptPage = signUpPage.submit();
        assertTrue(receiptPage.isInitialized());

        assertEquals("Thank you!", receiptPage.confirmationHeader());
    }
}

package homeoffice.actions;

import homeoffice.PageObject.SauceDemoHome;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import static org.junit.Assert.assertEquals;
public class LoginSteps extends UIInteractionSteps {

    @Step("The user enters their credentials '{0}' '{1}'")
    public void enterCredentials(String strUserName, String strPassword){
        find(SauceDemoHome.USERNAME_TXT).sendKeys(strUserName);
        find(SauceDemoHome.PASSWORD_TXT).sendKeys(strPassword);
        find(SauceDemoHome.LOGIN_BTN).click();
        waitFor(5).seconds();
    }

    @Step("User verifies URL path '{0}'")
    public void verifyURL(String strUrlActual){
        String url = getDriver().getCurrentUrl();
        assertEquals(url,strUrlActual);
    }
    @Step("The user enters wrong credentials and verifies the error message '{0}'")
    public void verifyErrorMsg(String errorMessage) {
        String errorInline = find(SauceDemoHome.CREDENTIALS_ERROR_MSG).getText();
        assertEquals(errorInline,errorMessage);
    }
}

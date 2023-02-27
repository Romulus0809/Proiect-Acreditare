package org.fasttrack.features;

import org.fasttrack.BaseTest.BaseTest;
import org.fasttrack.utils.EnvConstants;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.checkRememberMeBox();
        loginSteps.clickLoginButton();
        loginSteps.checkLogin("romi.pana");
    }

    @Test
    public void loginWithInvalidEmail(){
        loginSteps.setEmail(EnvConstants.USER_INVALID_EMAIL);
        loginSteps.setPassword(EnvConstants.USER_PASS);
        loginSteps.checkRememberMeBox();
        loginSteps.clickLoginButton();
        loginSteps.checkInvalidLogin();

    }

    @Test
    public void loginWithoutCompletingEmailField(){
        loginSteps.setEmail("romi.pana@yahoo.com");
        loginSteps.checkRememberMeBox();
        loginSteps.clickLoginButton();
        loginSteps.checkEmptyPasswordFieldError();

    }

    @Test
    public void logoutTest(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        loginSteps.checkLogin("romi.pana");
        loginSteps.doLogout();
        loginSteps.verifyLogout();
    }

    @Test
    public void resetPasswordTest(){
        loginSteps.setEmail(EnvConstants.USER_EMAIL);
        loginSteps.resetPassword(EnvConstants.USER_EMAIL);
        loginSteps.resetPasswordConfirmation();
    }






}

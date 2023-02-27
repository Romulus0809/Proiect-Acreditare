package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LoginSteps extends BaseSteps{

    @Step
    public void setValidCredentials(String email, String password){
        homePage.clickMyAccountLink();
        myAccountPage.setLoginEmailField(email);
        myAccountPage.setLoginPasswordField(password);
    }

    @Step
    public void setEmail(String email){
        homePage.clickMyAccountLink();
        myAccountPage.setLoginEmailField(email);
    }

    @Step
    public void setPassword(String password){
        myAccountPage.setLoginPasswordField(password);
    }

    @Step
    public void checkRememberMeBox(){
        myAccountPage.checkRememberMe();
    }

    @Step
    public void clickLoginButton(){
        myAccountPage.clickLoginButton();
    }

    @Step
    public void checkLogin(String userEmail){
        myAccountPage.checkRegisterAndLogin(userEmail);
    }

    @Step
    public void checkInvalidLogin(){
        myAccountPage.getLoginErrorMessage();
    }

    @Step
    public void doLogout(){
        myAccountPage.clickLogoutLink();
    }

    @Step
    public void verifyLogout(){
        Assert.assertTrue(homePage.myAccountFormIsDisplayed());
    }

    @Step
    public void checkEmptyPasswordFieldError(){
        myAccountPage.getEmptyPasswordFieldError();
    }

    @Step
    public void resetPassword(String email){
        myAccountPage.clickOnLostPasswordField();
        myAccountPage.setEmailLostPasswordField(email);
        myAccountPage.clickOnResetPasswordButton();
    }

    @Step
    public void resetPasswordConfirmation(){
        myAccountPage.resetPasswordConfirmationMessage();
    }



}

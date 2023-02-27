package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class RegisterSteps extends BaseSteps {


    @Step
    public void setValidCredentials(String registerEmail, String registerPassword){
        homePage.clickMyAccountLink();
        myAccountPage.setRegisterEmail(registerEmail);
        myAccountPage.setRegisterPasswordField(registerPassword);

    }

    @Step
    public void setEmailAddress(String registerEmail){
        homePage.clickMyAccountLink();
        myAccountPage.setRegisterEmail(registerEmail);
    }

    @Step
    public void setPassword(String registerPassword){
        myAccountPage.setRegisterPasswordField(registerPassword);
    }

    @Step
    public void clickRegisterButton(){
        myAccountPage.clickOnRegisterButton();
    }

    @Step
    public void registerConfirmation(String userEmail){
        myAccountPage.checkRegisterAndLogin(userEmail);
    }

    @Step
    public void registerError(){
        myAccountPage.getErrorMessageRegister();
    }

    @Step
    public void invalidEmailErrorIsDisplayed(){
        myAccountPage.invalidEmailError();
    }



}

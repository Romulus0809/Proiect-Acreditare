package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MyAccountPage extends BasePage{

    @FindBy(css = "#reg_email")
    private WebElementFacade registerEmailField;

    @FindBy(css = "#reg_password")
    private WebElementFacade registerPasswordField;

    @FindBy(css = "[name='register']")
    private WebElementFacade registerButton;

    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade registerAndLoginSuccessMessage;

    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade registerErrorMessage;

    @FindBy(css = "#username")
    private WebElementFacade loginEmailField;

    @FindBy(css = "#password")
    private WebElementFacade loginPasswordField;

    @FindBy(css = "[name='login']")
    private WebElementFacade loginButton;

   @FindBy(css = "#rememberme")
   private WebElementFacade rememberMeCheckBox;

   @FindBy(css = ".woocommerce-error li")
   private WebElementFacade loginError;

   @FindBy(css = ".woocommerce-MyAccount-navigation-link--customer-logout")
   private WebElementFacade logoutLink;

   @FindBy(css = ".content-page")
   private WebElementFacade accountPageForm;

   @FindBy(css = ".woocommerce-error li")
   private WebElementFacade emptyPasswordFieldMessage;

   @FindBy(css = ".lost_password a")
   private WebElementFacade lostPasswordLink;

   @FindBy (css = "#user_login")
   private WebElementFacade emailLostPasswordField;

   @FindBy (css = ".woocommerce-Button ")
   private WebElementFacade resetPasswordButton;

   @FindBy (css = ".woocommerce-message")
   private WebElementFacade resetPasswordConfirmation;

   @FindBy (css = " .woocommerce-error li")
   private WebElementFacade invalidEmailErrorText;


    public void setRegisterEmail(String registerEmail){
        waitFor(registerEmailField);
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(registerEmailField);
        typeInto(registerEmailField, registerEmail );
    }

    public void setRegisterPasswordField(String registerPassword){
        waitFor(registerPasswordField);
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(registerPasswordField);
        typeInto(registerPasswordField, registerPassword);
    }

    public void clickOnRegisterButton(){
        waitFor(registerButton);
        withTimeoutOf(Duration.ofSeconds(20)).waitFor(registerButton);
        clickOn(registerButton);
    }

    public void checkRegisterAndLogin(String userEmail){
        registerAndLoginSuccessMessage.shouldContainOnlyText("Hello " +userEmail+ " (not " +userEmail+ "? Log out)" );
    }

    public void getErrorMessageRegister(){
        registerErrorMessage.shouldContainOnlyText("Error: An account is already registered with your email address. Please log in.");
    }

    public void  setLoginEmailField(String username){
        waitFor(loginEmailField);
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(loginEmailField);
        typeInto(loginEmailField, username);
    }

    public void setLoginPasswordField(String password){
        waitFor(loginPasswordField);
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(loginPasswordField);
        typeInto(loginPasswordField, password);
    }

    public void clickLoginButton(){
        waitFor(loginButton);
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(loginButton);
        loginButton.click();
    }

    public void checkRememberMe(){
        rememberMeCheckBox.click();
    }

    public void getLoginErrorMessage(){
        loginError.shouldContainOnlyText("ERROR: Invalid username. Lost your password?");
    }

    public void clickLogoutLink(){
        logoutLink.click();
    }

    public void getEmptyPasswordFieldError(){
        emptyPasswordFieldMessage.shouldContainOnlyText("ERROR: The password field is empty.");
    }

    public void clickOnLostPasswordField(){
        lostPasswordLink.click();
    }

    public void setEmailLostPasswordField(String emailLostPassword){
        typeInto(emailLostPasswordField, emailLostPassword);
    }

    public void clickOnResetPasswordButton(){
        resetPasswordButton.click();
    }

    public void resetPasswordConfirmationMessage(){
        resetPasswordConfirmation.shouldContainOnlyText("Password reset email has been sent.");
    }

    public void invalidEmailError(){
        invalidEmailErrorText.shouldContainOnlyText("Error: An account is already registered with your email address. Please log in.");
    }




}

package org.fasttrack.steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutSteps extends BaseSteps{

    @Step
    public void setNames(String firstName, String lastName, String companyName){
        cartPage.clickProceedToCheckoutButton();
        checkoutPage.setFirstNameBilling(firstName);
        checkoutPage.setLastNameBilling(lastName);
        checkoutPage.setCompanyNameField(companyName);
    }

    @Step
    public void selectCountryFromDropdown(){
        checkoutPage.selectCountryFromDropdown();
    }

    @Step
    public void setAddress(String addressFirst, String addressSecond, String cityName){
        checkoutPage.setAddressFirstField(addressFirst);
        checkoutPage.setAddressSecondField(addressSecond);
        checkoutPage.setCityNameField(cityName);
    }

    @Step
    public void selectCountyFromDropdown(){
        checkoutPage.selectCountyFromDropdown();
    }

    @Step
    public void setPostalCodeAndPhoneNumber(String postalCode, String phoneNumber){
        checkoutPage.setPostalCodeField(postalCode);
        checkoutPage.setPhoneNumberField(phoneNumber);
    }

    @Step
    public void clickPlaceOrderButton(){
        checkoutPage.clickPlaceOrderButton();
    }

    @Step
    public void orderConfirmationMessage(){
        Assert.assertTrue(checkoutPage.orderIsConfirmedMessage());
    }

    @Step
    public void emptyEmailField(){
        checkoutPage.clearEmailField();
    }

    @Step
    public void emailAddressMandatoryAlertMessage(){
       Assert.assertTrue(checkoutPage.emailFieldMandatoryAlert());
    }

    @Step
    public void setEmailField(String email){
        checkoutPage.setEmailField(email);
    }

    @Step
    public void emailAddressWrongMessage(){
        Assert.assertTrue(checkoutPage.emailWrongAlert());
    }
}

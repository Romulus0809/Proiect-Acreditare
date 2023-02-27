package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public class CheckoutPage extends BasePage{

    @FindBy (css = "#billing_first_name")
    private WebElementFacade firstNameBilling;

    @FindBy (css = "#billing_last_name")
    private WebElementFacade lastNameBilling;

    @FindBy (css = "#billing_company")
    private WebElementFacade companyNameField;

    @FindBy (css = "#billing_country")
    private WebElementFacade countryDropdown;

    @FindBy (css = "[Name='billing_address_1']")
    private WebElementFacade addressFirstField;

    @FindBy (css = "[Name='billing_address_2']")
    private WebElementFacade addressSecondField;

    @FindBy (css = "[Name = 'billing_city']")
    private WebElementFacade cityNameField;

    @FindBy (css = "[Name ='billing_state']")
    private WebElementFacade countyDropdown;

    @FindBy (css = ".input-text#billing_postcode")
    private WebElementFacade postalCodeField;

    @FindBy (css = "#billing_phone")
    private WebElementFacade phoneNumberField;

    @FindBy (css = "#billing_email")
    private WebElementFacade emailField;

    @FindBy (css = "#place_order")
    private WebElementFacade placeOrderButton;

    @FindBy (css = ".post-title")
    private WebElementFacade orderConfirmationMessage;

    @FindBy (css = ".woocommerce-error")
    private WebElementFacade mandatoryFieldErrorText;

    @FindBy (css = ".woocommerce-error")
    private WebElementFacade wrongEmailAddressMessage;


    public void setFirstNameBilling(String firstName){
        typeInto(firstNameBilling,firstName);
    }

    public void setLastNameBilling(String lastName){
        typeInto(lastNameBilling,lastName);
    }

    public void setCompanyNameField(String companyName){
        typeInto(companyNameField, companyName);
    }

    public void selectCountryFromDropdown(){
        countryDropdown.selectByValue("RO");
    }

    public void setAddressFirstField(String addressFirst){
        typeInto(addressFirstField, addressFirst);
    }

    public void setAddressSecondField(String addressSecond){
        typeInto(addressSecondField, addressSecond);
    }

    public void setCityNameField(String cityName){
        typeInto(cityNameField, cityName);
    }

    public void selectCountyFromDropdown(){
        countyDropdown.selectByValue("CJ");
    }

    public void setPostalCodeField(String postalCode){
        typeInto(postalCodeField, postalCode);
    }

    public void setPhoneNumberField(String phoneNumber){
        typeInto(phoneNumberField, phoneNumber);
    }

    public void clearEmailField(){
        emailField.clear();
    }

    public void setEmailField(String email){
        typeInto(emailField, email);
    }

    public void clickPlaceOrderButton(){
        waitFor(placeOrderButton);
        withTimeoutOf(Duration.ofSeconds(20)).waitFor(placeOrderButton);
        clickOn(placeOrderButton);
    }

    public boolean orderIsConfirmedMessage() {
        if (orderConfirmationMessage.isPresent()) return true;
        else return false;
    }

    public boolean emailFieldMandatoryAlert(){
        if (mandatoryFieldErrorText.isPresent()) return true;
        else return false;
    }

    public boolean emailWrongAlert(){
        if (wrongEmailAddressMessage.isPresent()) return true;
        else return false;
    }








}

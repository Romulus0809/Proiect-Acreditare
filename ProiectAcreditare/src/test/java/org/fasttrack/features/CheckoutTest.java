package org.fasttrack.features;

import org.fasttrack.BaseTest.BaseTest;
import org.fasttrack.utils.EnvConstants;
import org.junit.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkOutWithValidCredentials() {
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        checkoutSteps.setNames("Pana", "Romulus", "FasttrackIT");
        checkoutSteps.selectCountryFromDropdown();
        checkoutSteps.setAddress("Strada Streilui", "numarul 8", "Hunedoara");
        checkoutSteps.selectCountyFromDropdown();
        checkoutSteps.setPostalCodeAndPhoneNumber("331046", "0749436416");
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.orderConfirmationMessage();
    }

    @Test
    public void checkOutWithoutEmailAddress(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        checkoutSteps.setNames("Pana", "Romulus", "FasttrackIT");
        checkoutSteps.selectCountryFromDropdown();
        checkoutSteps.setAddress("Strada Streiului", "numarul 8", "Hunedoara");
        checkoutSteps.selectCountyFromDropdown();
        checkoutSteps.setPostalCodeAndPhoneNumber("123442", "0273453432");
        checkoutSteps.setEmailField("");
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.emailAddressMandatoryAlertMessage();
    }

    @Test
    public void checkoutWithInvalidEmailAddress() throws InterruptedException {
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        checkoutSteps.setNames("Pana", "Romulus", "FasttrackIT");
        checkoutSteps.selectCountryFromDropdown();
        checkoutSteps.setAddress("Strada Streiului", "numarul 8", "Hunedoara");
        checkoutSteps.selectCountyFromDropdown();
        checkoutSteps.setPostalCodeAndPhoneNumber("123345", "02743455121");
        checkoutSteps.setEmailField(EnvConstants.USER_INVALID_EMAIL);
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.emailAddressWrongMessage();

    }
}

package org.fasttrack.features;

import net.bytebuddy.utility.RandomString;
import org.fasttrack.BaseTest.BaseTest;
import org.fasttrack.utils.EnvConstants;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartTest extends BaseTest {

    WebDriver driver;

    RandomString randomString = new RandomString();
    String randomComment = randomString.nextString();

    @Test
    public void addToCartTest(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
    }

    @Test
    public void removeFromCartTest(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        cartSteps.removeProductFromCart("Album");
        cartSteps.removeProductConfirmation();
    }

    @Test
    public void checkCartTotalSummaryTest() {
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        cartSteps.checkSubtotalPriceIsDisplayedCorrectly();
        cartSteps.checkTotalPriceIsCorrect();
    }

    @Test
    public void changeQuantityOfAProduct(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        cartSteps.changeQuantityInCart("9");
    }

    @Test
    public void reviewAProduct(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.leaveAReview("very"+ randomComment);
        cartSteps.commentIsDisplayed("very" + randomComment);
    }

    @Test
    public void reviewWithSameComment(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.leaveAReview("nice"+randomComment);
        cartSteps.leaveAReview("nice"+randomComment);
        cartSteps.commentIsDoubled();
    }




}

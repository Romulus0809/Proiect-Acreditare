package org.fasttrack.steps;

import io.cucumber.java.bs.A;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartSteps extends BaseSteps{

    WebDriver driver;

    @Step
    public void selectProductFromShop(){
        homePage.clickOnShopLink();
        productPage.selectProduct();
    }

    @Step
    public void selectVariableProductFromShop() {
        homePage.clickOnShopLink();
        productPage.selectVariableProduct();
        productPage.selectColorFromDropdown();
        productPage.selectLogoFromDropdown();
        productPage.clickAddToCartVariable();

    }

    @Step
    public void clickAddToCartButton(){
        productPage.clickAddToCart();
    }

    @Step
    public void productAddedConfirmation(){
        Assert.assertTrue(productPage.productAddedToCartConfirmation());
    }

    @Step
    public void variableProductAddedConfirmation() {
        productPage.variableProductAddedToCartConfirmation();
    }

    @Step
    public void clickOnViewCartButton(){
        productPage.clickOnViewCartButton();
    }

    @Step
    public void removeProductFromCart(String productName){
        Assert.assertTrue(cartPage.removeProduct(productName));
    }

    @Step
    public void removeProductConfirmation(){
        cartPage.productSuccessfullyRemoved();
    }

    @Step
    public void checkSubtotalPriceIsDisplayedCorrectly(){
        Assert.assertTrue("The subtotal price is not correct!",cartPage.isSubtotalPriceCorrect());
    }

    @Step
    public void checkTotalPriceIsCorrect(){
        Assert.assertTrue("Total price not correct", cartPage.isTotalPriceCorrect());
    }

    @Step
    public void clickOnCartLink(){
        homePage.clickOnCartLink();
    }

    @Step
    public void changeQuantityInCart(String value){
        cartPage.clearQuantity();
        cartPage.changeQuantity(value);
        cartPage.clickUpdateCartButton();
        cartPage.cartUpdatedConfirmation();
    }

    @Step
    public void leaveAReview(String comment){
        productPage.clickOnReviewLink();
        productPage.clickFiveStarsReview();
        productPage.setCommentField(comment);
        productPage.clickSubmitButton();
    }

    @Step
    public void commentIsDisplayed(String comment){
        Assert.assertTrue(productPage.commentIsVisible(comment));
    }

    @Step
    public void commentIsDoubled(){
        Assert.assertTrue(productPage.theCommentExists());
    }



}

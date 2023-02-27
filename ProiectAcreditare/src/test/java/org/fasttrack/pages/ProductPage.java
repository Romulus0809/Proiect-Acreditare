package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(css = ".post-34 .full-outer")
    private WebElementFacade productFromShop;

    @FindBy(css = ".post-23 .full-outer")
    private WebElementFacade variableProductFromShop;

    @FindBy(css = "[name='add-to-cart']")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade productAddedToCartMessage;

    @FindBy(css = ".wc-forward")
    private WebElementFacade viewCartButton;

    @FindBy(css = "#tab-title-reviews")
    private WebElementFacade reviewProductLink;

    @FindBy(css = ".star-5")
    private WebElementFacade fiveStarsReview;

    @FindBy(css = "#comment")
    private WebElementFacade commentField;

    @FindBy(css = "#submit")
    private WebElementFacade submitButton;

    @FindBy(css = ".comment-text")
    private List<WebElementFacade> commentList;

    @FindBy(css = "body#error-page p:first-child")
    private WebElementFacade doubledCommentError;

    @FindBy(css = "#pa_color")
    private WebElementFacade colorDropdown;

    @FindBy(css = "#logo")
    private WebElementFacade logoDropdown;

    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade addToCartVariableProductButton;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade variableProductAddedMessage;


    public void selectProduct() {
        clickOn(productFromShop);
    }

    public void selectVariableProduct() {
        clickOn(variableProductFromShop);
    }

    public void clickAddToCart() {
        clickOn(addToCartButton);
    }

    public boolean productAddedToCartConfirmation() {
        if (productAddedToCartMessage.isPresent()) return true;
        else return false;
    }

    public void variableProductAddedToCartConfirmation() {
        waitFor(variableProductAddedMessage);
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(variableProductAddedMessage);
        variableProductAddedMessage.shouldContainOnlyText("“Hoodie” has been added to your cart.");
    }

    public void clickOnViewCartButton(){
        clickOn(viewCartButton);
    }

    public void clickOnReviewLink(){
        clickOn(reviewProductLink);
    }

    public void clickFiveStarsReview(){
        clickOn(fiveStarsReview);
    }

    public void setCommentField(String comment){
        typeInto(commentField, comment);
    }

    public void clickSubmitButton(){
        clickOn(submitButton);
    }

    public boolean commentIsVisible(String comment){
        waitFor(commentList.get(0));
        for (WebElementFacade element : commentList){
            if (element.findElement(By.cssSelector("div.description")).getText().equalsIgnoreCase(comment)){
                return true;
            }
        }
        return false;
    }

    public boolean theCommentExists(){
        if (doubledCommentError.isPresent()) return true;
        else return false;
    }

    public void selectColorFromDropdown(){
        colorDropdown.selectByValue("blue");
    }

    public void selectLogoFromDropdown(){
        logoDropdown.selectByValue("Yes");
    }

    public void clickAddToCartVariable(){
        clickOn(addToCartVariableProductButton);
    }


}

package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage{

    @FindBy (css = ".product-remove a")
    private WebElementFacade removeProductFromCart;

    @FindBy (css = ".woocommerce-message")
    private WebElementFacade productRemovedMessage;

    @FindBy (css = "tr.cart_item")
    private List<WebElementFacade> cartProductsList;

    @FindBy (css = "td.product-subtotal ")
    private List<WebElementFacade> listOfSubtotalPrices;

    @FindBy (css = ".cart-subtotal td")
    private WebElementFacade subtotalText;

    @FindBy (css = ".order-total td")
    private WebElementFacade totalText;

    @FindBy (css = ".input-text.qty.text")
    private WebElementFacade productQuantityField;

    @FindBy (css = "button.button")
    private WebElementFacade updateCartButton;

    @FindBy (css = ".woocommerce-message ")
    private WebElementFacade cartUpdatedMessage;

    @FindBy (css = ".wc-proceed-to-checkout a")
    private WebElementFacade proceedToCheckoutButton;


    public void productSuccessfullyRemoved(){
        productRemovedMessage.shouldContainOnlyText("“Album” removed. Undo?");
    }

    public boolean removeProduct(String name){
        waitFor(cartProductsList.get(0));
        for (WebElementFacade element : cartProductsList){
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(name)){
                element.findElement(By.cssSelector(".product-remove a")).click();
                return true;
            }
        }
        return false;
    }

    public int getSubtotalPricesCalculated() {
        int sum = 0;
        for (WebElementFacade element : listOfSubtotalPrices) {
            sum += getIntFromPrice(element.getText());
        }
        return sum;
    }

    public boolean isSubtotalPriceCorrect() {
        return getSubtotalPricesCalculated() == getIntFromPrice(subtotalText.getText());
    }

    public boolean isTotalPriceCorrect(){
        return getIntFromPrice(subtotalText.getText()) <= getIntFromPrice(totalText.getText());
    }

    public void clearQuantity(){
        waitFor(productQuantityField);
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(productQuantityField);
        productQuantityField.clear();
    }

    public void changeQuantity(String value){
        waitFor(productQuantityField);
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(productQuantityField);
        typeInto(productQuantityField,value);
    }

    public void clickUpdateCartButton(){
        waitFor(updateCartButton);
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(updateCartButton);
        updateCartButton.click();
    }

    public void cartUpdatedConfirmation(){
        waitFor(cartUpdatedMessage);
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(cartUpdatedMessage);
        cartUpdatedMessage.shouldContainOnlyText("Cart updated.");
    }

    public void clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }
}

package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(css = ".type-product")
    private List<WebElementFacade> listOfProducts;

    @FindBy (css = ".orderby")
    private WebElementFacade selectFromDropdown;

    @FindBy (css = ".woocommerce-info")
    private WebElementFacade productNotFoundMessage;

    @FindBy(css = ".price")
    private List<WebElementFacade> listOfProductsPrice;


    public boolean openProduct(String name){
        waitFor(listOfProducts.get(0));
        for (WebElementFacade element : listOfProducts){
            if (element.findElement(By.cssSelector(".collection_title")).getText().equalsIgnoreCase(name)){
                element.findElement(By.cssSelector("h3")).click();
                return true;
            }
        }
        return false;
    }

    public boolean productNotFoundText(){
        if (productNotFoundMessage.isPresent()) return true;
        else return false;
    }

    public void selectDropdownOption(){
        selectFromDropdown.selectByValue("price-desc");
    }

    public boolean isPriceFromHighToLow(){
        return getIntFromPrice(listOfProductsPrice.get(0).getText())
                >getIntFromPrice(listOfProductsPrice.get(listOfProductsPrice.size()-1).getText());

    }




}

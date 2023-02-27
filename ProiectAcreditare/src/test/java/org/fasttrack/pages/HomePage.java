package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


import java.time.Duration;

public class HomePage extends BasePage {
    @FindBy(css = ".menu-item-70")
    private WebElementFacade myAccountLink;

    @FindBy(css =".search-form .search-field")
    private WebElementFacade searchField;

    @FindBy(css = ".search-form .searchsubmit")
    private WebElementFacade searchIcon;

    @FindBy(css = "#post-7")
    private WebElementFacade myAccountForm;

    @FindBy(css = ".menu-item-73")
    private WebElementFacade shopLink;

    @FindBy(css = "#menu-item-72")
    private WebElementFacade cartLink;


    public void clickMyAccountLink(){
        clickOn(myAccountLink);
    }

    public void setSearchField(String productName){
        waitFor(searchField);
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(searchField);
        typeInto(searchField, productName);
    }

    public void clickSearchIcon(){
        clickOn(searchIcon);
    }

    public boolean myAccountFormIsDisplayed(){
       if (myAccountForm.isDisplayed()) return true;
       else return false;
    }

    public void clickOnShopLink(){
        clickOn(shopLink);
    }

    public void clickOnCartLink(){
        clickOn(cartLink);
    }




}

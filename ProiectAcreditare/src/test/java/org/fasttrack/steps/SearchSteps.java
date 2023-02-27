package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchSteps extends BaseSteps{

    @Step
    public void navigateToHomePage(){

        homePage.open();
    }

    @Step
    public void executeSearch(String keyword){
        homePage.setSearchField(keyword);
        homePage.clickSearchIcon();
    }

    @Step
    public void findAndOpenProduct(String productName){
        Assert.assertTrue(searchResultsPage.openProduct(productName));
    }

    @Step
    public void searchAndSelectProduct(String productName){
        executeSearch(productName);
        findAndOpenProduct(productName);
    }

    @Step
    public void nonexistentProductMessage(){
        Assert.assertTrue(searchResultsPage.productNotFoundText());
    }

    @Step
    public void sortProductByPrice(){
        searchResultsPage.selectDropdownOption();
        Assert.assertTrue(searchResultsPage.isPriceFromHighToLow());
    }


}

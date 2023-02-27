package org.fasttrack.features;

import org.fasttrack.BaseTest.BaseTest;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchForExistingSimpleProduct(){
        searchSteps.executeSearch("t-shirt");
        searchSteps.findAndOpenProduct( "T-Shirt with Logo");
    }

    @Test
    public void searchForNonexistentProduct(){
        searchSteps.executeSearch("skirt");
        searchSteps.nonexistentProductMessage();
    }

    @Test
    public void searchByPriceTest(){
        loginSteps.navigateToHomePage();
        searchSteps.executeSearch("product");
        searchSteps.sortProductByPrice();
    }

}

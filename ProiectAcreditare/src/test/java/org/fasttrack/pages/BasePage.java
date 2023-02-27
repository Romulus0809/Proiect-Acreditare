package org.fasttrack.pages;

import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject {
    public int getIntFromPrice(String priceNonFormatted){
        return Integer.parseInt(priceNonFormatted
                .replace("lei", "")
                .replace(".", ""));
    }


}

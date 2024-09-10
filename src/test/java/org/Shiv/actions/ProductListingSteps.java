package org.Shiv.actions;

import org.Shiv.Pom.HomePage;
import org.Shiv.data.DataReader;
import org.Shiv.driver.SeleniumActions;

public class ProductListingSteps {
    private static final ProductListingSteps PRODUCT_LISTING_STEPS = new ProductListingSteps();
    public static ProductListingSteps getProductListingSteps(){
        return PRODUCT_LISTING_STEPS;
    }

    public void searchProductOnSearchBox () {
        SeleniumActions.verifyIsDisplayed (HomePage.getHomePage ()
            .getSearchBox ());
        SeleniumActions.sendKeys (HomePage.getHomePage ()
            .getSearchBox (), DataReader.readHomePageProps ()
            .getSearch_product ());
        SeleniumActions.alternateClick (HomePage.getHomePage ()
            .getSearchIcon ());
    }
}
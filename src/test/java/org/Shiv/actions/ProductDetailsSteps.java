package org.Shiv.actions;

import org.Shiv.tests.HomepageTest;
import org.Shiv.tests.LoginTests;
import org.Shiv.tests.ProductListingTest;

public class ProductDetailsSteps {
    private static final ProductDetailsSteps PRODUCT_DETAILS_STEPS = new ProductDetailsSteps ();
    public static ProductDetailsSteps getProductDetailsSteps(){
        return PRODUCT_DETAILS_STEPS;
    }

    public void navigateToProductSearchResult() throws InterruptedException {
        HomepageTest homepageTest = new HomepageTest ();
        homepageTest.homePageChooseAddressTest ();
        ProductListingSteps.getProductListingSteps ().searchProductOnSearchBox ();
    }
}

package org.Shiv.tests;

import org.Shiv.Pom.ProductDetailsLocatorPage;
import org.Shiv.actions.ProductDetailsSteps;
import org.Shiv.driver.DriverManager;
import org.Shiv.driver.SeleniumActions;
import org.testng.CommandLineArgs;
import org.testng.annotations.Test;

public class ProductAddCartTest extends BaseTest{
    @Test
    public void addToCart() throws InterruptedException {
        ProductDetailsTest productDetailsTest = new ProductDetailsTest ();
        productDetailsTest.searchAndVerifyProductDetails ();
        System.out.println ("=="+ DriverManager.getTitle ());
        SeleniumActions.scrollIntoView (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
            .getAddCartCTA ());
        SeleniumActions.verifyIsDisplayed (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
            .getAddCartCTA ());
        SeleniumActions.click (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
            .getAddCartCTA ());
        SeleniumActions.sleep (2000);
        SeleniumActions.click (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
            .getCartCTA ());
        SeleniumActions.sleep (10000);
    }

}

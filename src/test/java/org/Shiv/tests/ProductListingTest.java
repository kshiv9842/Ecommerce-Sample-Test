package org.Shiv.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.Shiv.Pom.ProductListingPage;
import org.Shiv.actions.ProductListingSteps;
import org.Shiv.data.ProductDetails;
import org.Shiv.driver.SeleniumActions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductListingTest extends BaseTest{
    ProductDetails        productDetails = new ProductDetails ();
    List <ProductDetails> productlist    = new ArrayList<> ();
    SoftAssert            softAssert;

    @Test
    public void searchProductOnHomepageTest() {
        LoginTests loginTests = new LoginTests ();
        loginTests.validLoginTest ();
        ProductListingSteps.getProductListingSteps ()
            .searchProductOnSearchBox ();
        validateProductFromCurrentPage ();
        SeleniumActions.scrollIntoView (ProductListingPage.getProductListingPage ()
            .getSearchNextPage ());
        while (true) {
            try {
                if (SeleniumActions.find (ProductListingPage.getProductListingPage ()
                        .getSearchNextPage ())
                    .isDisplayed ()) {
                    SeleniumActions.scrollIntoView (ProductListingPage.getProductListingPage ()
                        .getSearchNextPage ());
                    SeleniumActions.click (ProductListingPage.getProductListingPage ()
                        .getSearchNextPage ());
                    SeleniumActions.sleep (3000);
                    validateProductFromCurrentPage ();
                }
            } catch (Exception e) {
                System.out.println ("No more pages to navigate. Exiting.");
                break;
            }
        }
        System.out.println ("Products List - " + this.productlist);
        System.out.println ("Total Products Count - " + this.productlist.size ());
    }
    public void validateProductFromCurrentPage() {
            List<WebElement> itemList = SeleniumActions.finds(ProductListingPage.getProductListingPage ().getSearchedItemList());
            List<WebElement> itemRatings = SeleniumActions.finds(ProductListingPage.getProductListingPage ().getSearchedItemRating());
            List<WebElement> itemPrices = SeleniumActions.finds(ProductListingPage.getProductListingPage ().getSearchedItemPrice());
            List<WebElement> itemNames = SeleniumActions.finds(ProductListingPage.getProductListingPage ().getSearchedItemName ());
            List<WebElement> itemId = SeleniumActions.finds(ProductListingPage.getProductListingPage ().getSearchedItemId ());

            //final int minSize = Math.min (itemList.size(), Math.min (itemRatings.size(), itemPrices.size()));
            for(int i=0;i< itemList.size ();i++)
            {
                if(itemList.get (i).isDisplayed ())
                {
                    SeleniumActions.scrollIntoViewElement (itemList.get (i));
                    this.productDetails = new ProductDetails();
                    if (i < itemRatings.size() && itemRatings.get(i).isDisplayed()) {
                        this.productDetails.setProductRating (itemRatings.get (i)
                            .getAttribute ("aria-label")
                            .replace (" out of 5 stars", ""));
                    }
                    else
                        this.productDetails.setProductRating ("Currently No Ratings Available");
                    if (i < itemPrices.size() && itemPrices.get(i).isDisplayed()) {
                        this.productDetails.setProductPrice (itemPrices.get (i)
                            .getText ());
                    } else
                        this.productDetails.setProductPrice ("Currently Product Out Of Stock");
                }
                this.softAssert = new SoftAssert ();
                this.softAssert.assertTrue (itemNames.get (i).isDisplayed ());
                this.productDetails.setProductName (itemNames.get (i).getText ());
                this.softAssert.assertNotNull (itemId.get (i).getText ());
                this.productDetails.setProductId (itemId.get (i).getAttribute ("data-asin"));
                this.softAssert.assertAll ();
                this.productlist.add (this.productDetails);
            }
            SeleniumActions.sleep (5000);
    }
}

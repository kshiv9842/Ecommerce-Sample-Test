package org.Shiv.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.github.javafaker.Faker;
import org.Shiv.Pom.ProductDetailsLocatorPage;
import org.Shiv.Pom.ProductListingPage;
import org.Shiv.actions.HomePageSteps;
import org.Shiv.actions.ProductDetailsSteps;
import org.Shiv.actions.ProductListingSteps;
import org.Shiv.data.DataReader;
import org.Shiv.data.ProductDetails;
import org.Shiv.driver.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xml.sax.Locator;

// Verify the product title and price on the product detail page.
public class ProductDetailsTest extends BaseTest{
    ProductDetails productDetails = new ProductDetails ();
    Faker faker;
    @Test
    public void searchAndVerifyProductDetails() throws InterruptedException {
        this.faker = new Faker ();
        ProductDetailsSteps.getProductDetailsSteps ().navigateToProductSearchResult ();
        List<WebElement> itemList = SeleniumActions.finds(ProductListingPage.getProductListingPage ().getSearchedItemList());
        final int ChooseProduct = this.faker.random ().nextInt (1,itemList.size ());
        System.out.println ("Selected Product - "+itemList.get (ChooseProduct).getText ());
        this.productDetails.setProductId (itemList.get (ChooseProduct).getAttribute ("data-asin"));
        By itemname = new By.ByXPath ("//div[@data-asin='"+productDetails.getProductId ().toString ()+"']//h2//span");
        this.productDetails.setProductName (SeleniumActions.getText (itemname));
            if (SeleniumActions.isDisplayedWithoutWait (By.xpath ("//div[@data-asin='" + productDetails.getProductId ()
                .toString () + "']//div[@class = 'a-row a-size-small']/span[1]"))) {

                By itemrating = new By.ByXPath ("//div[@data-asin='" + productDetails.getProductId ()
                    .toString () + "']//div[@class = 'a-row a-size-small']/span[1]");
                this.productDetails.setProductRating (SeleniumActions.getAttribute (itemrating, "aria-label"));
            }
        else
            this.productDetails.setProductRating (DataReader.readHomePageProps ()
                .getNo_rating ());

       if (SeleniumActions.isDisplayedWithoutWait (By.xpath ("//div[@data-asin='" + productDetails.getProductId ()
           .toString () + "']//div[@data-cy='price-recipe']//span[@class='a-price-whole']"))) {
           this.productDetails.setProductPrice (SeleniumActions.getText (By.xpath (
               "//div[@data-asin='" + productDetails.getProductId ()
                   .toString () + "']//div[@data-cy='price-recipe']//span[@class='a-price-whole']")));
       }
        else
            this.productDetails.setProductPrice (DataReader.readHomePageProps ()
                .getNo_price ());
        SeleniumActions.scrollIntoView (itemname);
        SeleniumActions.hover (itemname);
        SeleniumActions.sleep (2000);
        SeleniumActions.click (itemname);
        SeleniumActions.sleep (10000);
        SoftAssert softAssert = new SoftAssert ();
        //-- assertion of product name
        SeleniumActions.switchToTheNewTabOpened ();
        SeleniumActions.scrollIntoView (ProductDetailsLocatorPage
            .getProductDetailsLocatorPage ().getProductTitle ());
        softAssert.assertEquals (this.productDetails.getProductName (),SeleniumActions.getText (
            (ProductDetailsLocatorPage.getProductDetailsLocatorPage ().getProductTitle ())), "Product name not matched.");
        //-- assertion of product ratings
        if(!this.productDetails.getProductRating ().equalsIgnoreCase (DataReader.readHomePageProps ()
            .getNo_rating ())){
            SeleniumActions.scrollIntoView (ProductDetailsLocatorPage
                .getProductDetailsLocatorPage ().getProductRating ());
            softAssert.assertEquals (this.productDetails.getProductRating (), SeleniumActions.getAttribute (
                ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                    .getProductRating (),"title"));
        }
        //-- assertion of product price
        if(!this.productDetails.getProductPrice ().equalsIgnoreCase (DataReader.readHomePageProps ()
            .getNo_price ())){
            try {
                if (SeleniumActions.isDisplayedWithoutWait (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                    .getRefurbProductPrice ())) {
                    SeleniumActions.scrollIntoView (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                        .getRefurbProductPrice ());
                    softAssert.assertEquals (this.productDetails.getProductPrice (), SeleniumActions.getText (
                        ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                            .getRefurbProductPrice ()).replace ("₹",""));
                }
            }
            catch (TimeoutException e) {
                    SeleniumActions.scrollIntoView (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                        .getProductPrice ());
                    softAssert.assertEquals (this.productDetails.getProductPrice (), SeleniumActions.getText (
                        ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                            .getProductPrice ()).replace ("₹",""));
            }
        }
        softAssert.assertEquals (this.productDetails.getProductId (),SeleniumActions.getText (ProductDetailsLocatorPage
            .getProductDetailsLocatorPage ().getProductASIN ()));
        softAssert.assertAll ();
    }
}

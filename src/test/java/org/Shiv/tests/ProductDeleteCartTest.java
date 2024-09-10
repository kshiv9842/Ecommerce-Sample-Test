package org.Shiv.tests;

import java.util.List;

import javax.sound.midi.Soundbank;

import org.Shiv.Pom.ProductDetailsLocatorPage;
import org.Shiv.data.DataReader;
import org.Shiv.driver.SeleniumActions;
import org.Shiv.utils.DataUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDeleteCartTest extends BaseTest{
    @Test
    public static void productDelete() {
        LoginTests loginTests = new LoginTests ();
        loginTests.validLoginTest ();
        SeleniumActions.verifyIsDisplayed (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
            .getMainCartCTA ());
        SeleniumActions.click (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
            .getMainCartCTA ());
        if ((Integer.parseInt (SeleniumActions.getText (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                .getCartItemCount ())
            .trim ())) == 0) {
            SeleniumActions.getText (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                    .getNoItemInCart ())
                .contains (DataReader.readHomePageProps ()
                    .getNo_cart_item_placeholder_text ());
            Assert.assertEquals (SeleniumActions.getText (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                .getNoItemInCart ()), DataReader.readHomePageProps ()
                .getNo_cart_item_placeholder_text ());
        } else {
            List<WebElement> cartItemList = SeleniumActions.finds (
                ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                    .getCartItems ());
            for (WebElement element : cartItemList) {
                SeleniumActions.verifyIsDisplayed (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                    .getDeleteCartItemCTA ());
                SeleniumActions.click (ProductDetailsLocatorPage.getProductDetailsLocatorPage ()
                    .getDeleteCartItemCTA ());
            }
        }
    }
}

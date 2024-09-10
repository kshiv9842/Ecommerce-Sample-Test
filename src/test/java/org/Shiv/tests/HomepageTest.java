package org.Shiv.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.Shiv.Pom.HomePage;
import org.Shiv.actions.HomePageSteps;
import org.Shiv.data.DataReader;
import org.Shiv.data.ProductDetails;
import org.Shiv.driver.DriverManager;
import org.Shiv.driver.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.WeakHashMap;

public class HomepageTest extends BaseTest {

    @Test
    @Description ("This test verifies selecting an address on the homepage")
    @Story ("As a user, I should be able to choose a delivery address from the available addresses.")
    public void homePageChooseAddressTest () throws InterruptedException {
        LoginTests loginTests = new LoginTests ();
        loginTests.validLoginTest ();
        HomePageSteps.getHomePageSteps ()
            .navigateToDeliverAddress ();
        for (int i = 0; i < SeleniumActions.finds (HomePage.getHomePage ()
                .getAddresses ())
            .size (); i++) {
            if (SeleniumActions.finds (HomePage.getHomePage ()
                    .getAddresses ())
                .get (i)
                .isDisplayed () && SeleniumActions.finds (HomePage.getHomePage ()
                    .getAddresses ())
                .get (i)
                .getAttribute ("aria-label")
                .equalsIgnoreCase (DataReader.readHomePageProps ()
                    .getChoosen_address ())) {
                SeleniumActions.scrollIntoViewElement (SeleniumActions.finds (HomePage.getHomePage ()
                        .getAddresses ())
                    .get (i));
                System.out.println ("Choosen Address " + SeleniumActions.finds (HomePage.getHomePage ()
                        .getAddresses ())
                    .get (i)
                    .getAttribute ("aria-label"));
                SeleniumActions.finds (HomePage.getHomePage ()
                        .getAddresses ())
                    .get (i)
                    .click ();
                break;
            }
        }
        SeleniumActions.sleep (5000);
    }
}


package org.Shiv.tests;

import java.util.List;

import com.github.javafaker.Faker;
import org.Shiv.Pom.HomePage;
import org.Shiv.Pom.HomePageSearchSuggestionPage;
import org.Shiv.actions.ProductListingSteps;
import org.Shiv.data.DataReader;
import org.Shiv.driver.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.Locator;

public class HomePageSearchSuggestionTest extends BaseTest{
    Faker faker;
    @Test
    public void homepageSearchTest(){
        LoginTests loginTests = new LoginTests ();
        loginTests.validLoginTest ();
        SeleniumActions.verifyIsDisplayed (HomePage.getHomePage ()
            .getSearchBox ());
        faker = new Faker ();
        String keyword = faker.commerce ()
            .material ();
        SeleniumActions.sendKeys (HomePage.getHomePage ()
            .getSearchBox (), keyword);
        SeleniumActions.sleep (2000);
        List<WebElement> itemlist = SeleniumActions.finds (HomePageSearchSuggestionPage.getHomePageSearchSuggestionPage ()
            .getSuggestedItem ());
        for (int i = 0; i < itemlist.size ()-1; i++) {
            SeleniumActions.scrollIntoViewElement (itemlist.get (i));
            System.out.println ("-= "+itemlist.get (i).getAttribute ("aria-label"));
            System.out.println ("Keyword "+keyword);
            Assert.assertTrue (itemlist.get (i).getAttribute ("aria-label").contains (keyword.toLowerCase ()));
            System.out.println (itemlist.get (i).getText ());
        }
        System.out.println (itemlist.size ());
    }
}

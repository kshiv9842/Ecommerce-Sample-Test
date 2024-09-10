package org.Shiv.actions;

import org.Shiv.Pom.HomePage;
import org.Shiv.driver.SeleniumActions;

public class HomePageSteps {
    public static final HomePageSteps HOME_PAGE_STEPS = new HomePageSteps ();
    public static HomePageSteps getHomePageSteps(){
        return HOME_PAGE_STEPS;
    }

    public void navigateToDeliverAddress()
    {
        SeleniumActions.hover(HomePage.getHomePage().getDeliverTo());
        SeleniumActions.click(HomePage.getHomePage().getDeliverTo());
        SeleniumActions.hover (HomePage.getHomePage ().getSeeAllLnk ());
        SeleniumActions.click (HomePage.getHomePage ().getSeeAllLnk ());
        SeleniumActions.sleep (2000);
    }
}

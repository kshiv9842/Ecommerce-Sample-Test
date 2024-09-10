package org.Shiv.actions;

import org.Shiv.Pom.LandingPage;
import org.Shiv.driver.DriverManager;
import org.Shiv.driver.SeleniumActions;
import org.testng.asserts.SoftAssert;

public class LandingSteps {
    public static final LandingSteps LANDING_STEPS = new LandingSteps();
    public static LandingSteps getLandingSteps(){
        return LANDING_STEPS;
    }

    public boolean isApplicationLogoOnLandingPage(){
        return SeleniumActions.isDisplayed(LandingPage.getLandingPage().getApplicationLogo());
           }

    public String titleOfLandingPage(){
        return DriverManager.getTitle();
    }
    public String urlOfLandingPage(){
        return DriverManager.getCurrentUrl();
    }

    public void navigateToLogin(){
        SeleniumActions.isDisplayed(LandingPage.getLandingPage().getSigninLnk());
        SeleniumActions.isDisplayed(LandingPage.getLandingPage().getApplicationLogo());
        SeleniumActions.hover(LandingPage.getLandingPage().getLanguageSelector());
        SeleniumActions.click(LandingPage.getLandingPage().getSigninLnk());
    }
}

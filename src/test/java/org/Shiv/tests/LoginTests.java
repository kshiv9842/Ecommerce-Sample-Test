package org.Shiv.tests;

import com.github.javafaker.Faker;
import lombok.extern.java.Log;
import org.Shiv.Pom.LoginPage;
import org.Shiv.actions.LandingSteps;
import org.Shiv.actions.LoginSteps;
import org.Shiv.data.DataReader;
import org.Shiv.driver.DriverManager;
import org.Shiv.driver.SeleniumActions;
import org.Shiv.utils.PropertiesUtils;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginTests extends BaseTest{
    SoftAssert softAssert;

    @Test
    public void navigateToLoginPage() {
        this.softAssert = new SoftAssert();
        this.softAssert.assertTrue(LandingSteps.getLandingSteps().isApplicationLogoOnLandingPage(),"application Logo not found.");
        this.softAssert.assertEquals(LandingSteps.getLandingSteps().titleOfLandingPage(), DataReader.readLoginProps().getTitleOfLandingPage(),"Page title seems change.");
        //this.softAssert.assertEquals (LandingSteps.getLandingSteps().urlOfLandingPage(), PropertiesUtils.getPropertyValue("applicationUrl"),"Url Not matched.");
        this.softAssert.assertTrue (LandingSteps.getLandingSteps().urlOfLandingPage().contains (PropertiesUtils.getPropertyValue("applicationUrl")),"Url Not matched.");
        LandingSteps.getLandingSteps().navigateToLogin();
        SeleniumActions.sleep(5000);
        this.softAssert.assertAll();
    }

    @Test
    public void validLoginTest() {
        this.softAssert = new SoftAssert();
        this.softAssert.assertTrue(LandingSteps.getLandingSteps().isApplicationLogoOnLandingPage(), "Not navigated to landing steps.");
        LandingSteps.getLandingSteps().navigateToLogin();
        LoginSteps.getLoginSteps().isLoginPage();
        LoginSteps.getLoginSteps().populateSignInForm(PropertiesUtils.getPropertyValue("mobileno"));
        LoginSteps.getLoginSteps().ClickContinueBtn();
        LoginSteps.getLoginSteps().populatePasswordForm(PropertiesUtils.getPropertyValue("password"));
        LoginSteps.getLoginSteps().ClickSignInBtn();
        this.softAssert.assertAll();
    }

    @Test
    public void InvalidLoginTest() {
        this.softAssert = new SoftAssert();
        final Faker faker = new Faker();
        LandingSteps.getLandingSteps().navigateToLogin();
        LoginSteps.getLoginSteps().isLoginPage();
        LoginSteps.getLoginSteps().ClickContinueBtn();
        this.softAssert.assertEquals(SeleniumActions.getText(LoginPage.getLoginPage()
            .getEmptyMobileFieldLbl()),
            DataReader.readLoginProps()
                .getEmptyMobileFieldErrorMessage(),"Empty Error Label not matched.");
        LoginSteps.getLoginSteps().populateSignInForm(faker
            .random().nextInt (111, 9999)
            .toString());
        LoginSteps.getLoginSteps().ClickContinueBtn();
        try {
            this.softAssert.assertEquals (SeleniumActions.getText (LoginPage.getLoginPage ()
                .getIncorrectMobileNoLbl ()), DataReader.readLoginProps ()
                .getInvalidMobilenoFormatErrorMessage (), "Mobile Label not matched");
        }
        catch(TimeoutException e){
            this.softAssert.assertEquals (SeleniumActions.getText (LoginPage.getLoginPage ()
                .getIncorrectMobileNoAlert ()), DataReader.readLoginProps ()
                .getInvalid_mobileno_format_alert_message (), "Mobile Label not matched");

        }
        SeleniumActions.clear(LoginPage.getLoginPage().getMobileNo());
        LoginSteps.getLoginSteps().populateSignInForm(PropertiesUtils.getPropertyValue("mobileno"));
        LoginSteps.getLoginSteps().ClickContinueBtn();
        LoginSteps.getLoginSteps().populatePasswordForm (faker
            .random().nextInt (11111111, 99999999)
            .toString());
        LoginSteps.getLoginSteps().ClickSignInBtn ();
        this.softAssert.assertEquals(SeleniumActions
                .getText(LoginPage.getLoginPage()
                    .getIncorrectPasswordLbl ()),
            DataReader.readLoginProps().getInvalid_password_error_message (),"label not matched");
        SeleniumActions.clear (LoginPage.getLoginPage ()
            .getPassword ());
        LoginSteps.getLoginSteps().populatePasswordForm(PropertiesUtils.getPropertyValue("password"));
        LoginSteps.getLoginSteps().ClickSignInBtn();
        this.softAssert.assertAll ();
    }
}

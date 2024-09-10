package org.Shiv.actions;

import org.Shiv.Pom.LoginPage;
import org.Shiv.driver.SeleniumActions;

public class LoginSteps {
    private static final LoginSteps LOGIN_STEPS= new LoginSteps();

    public static LoginSteps getLoginSteps(){
        return LOGIN_STEPS;
    }
    public void isLoginPage(){
        SeleniumActions.isDisplayed(LoginPage.getLoginPage().getMobileNo());
        SeleniumActions.isDisplayed(LoginPage.getLoginPage().getContinueCTA());
    }
    public void populateSignInForm(final String mobileOremail){
        //SeleniumActions.isDisplayed(LoginPage.getLoginPage().getMobileLbl());
        SeleniumActions.isDisplayed(LoginPage.getLoginPage().getMobileNo());
        //SeleniumActions.isDisplayed(LoginPage.getLoginPage().getSignUpBtn());
        SeleniumActions.isDisplayed(LoginPage.getLoginPage().getContinueCTA());
        SeleniumActions.sendKeys(LoginPage.getLoginPage().getMobileNo(),mobileOremail);
    }
    public void populatePasswordForm(String password){
        SeleniumActions.isDisplayed(LoginPage.getLoginPage().getPasswordLbl());
        SeleniumActions.isDisplayed(LoginPage.getLoginPage().getPassword());
        //SeleniumActions.isDisplayed(LoginPage.getLoginPage().getGetOtpOnPhoneBtn());
        SeleniumActions.isDisplayed(LoginPage.getLoginPage().getSignINCTA());
        SeleniumActions.sendKeys(LoginPage.getLoginPage().getPassword(),password);
    }
    public void ClickContinueBtn(){

        SeleniumActions.click(LoginPage.getLoginPage().getContinueCTA());
    }
    public void ClickSignInBtn(){
        SeleniumActions.click(LoginPage.getLoginPage().getSignINCTA());
    }

}

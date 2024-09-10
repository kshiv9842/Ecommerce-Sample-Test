package org.Shiv.Pom;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class LoginPage extends BasePage{
    static final LoginPage LOGIN_PAGE = new LoginPage();
    public static LoginPage getLoginPage(){
        return LOGIN_PAGE;
    }
    private final By mobileNo    = By.xpath("//input[@type='email']");
    private final By continueCTA = By.id("continue");
    private final By password    = By.xpath ("//input[@type='password']");
    private final By signINCTA   = By.id("signInSubmit");
    private final By profileName  = By.id("nav-link-accountList-nav-line-1");
    private final By passwordLbl = By.xpath("//label[@for='ap_password']");
    private final By mobileLbl   = By.xpath("//label[@for='ap_email']");
    private final By SignUpBtn   = By.id("createAccountSubmit");
    private final By getOtpOnPhoneBtn   = By.id("continue");
    private final By incorrectMobileNoAlert = By.xpath("//h4[@class='a-alert-heading' and contains(text(),'Incorrect')]");
    private final By incorrectMobileNoLbl = By.xpath ("//div[@class='a-alert-content' and contains(text(),'Invalid')]");
    private final By incorrectPasswordLbl = By.xpath("//div[@class='a-alert-content']//li//span");
    private final By emptyMobileFieldLbl = By.xpath("//div[@class='a-alert-content' and contains(text(), 'Enter')]");
}

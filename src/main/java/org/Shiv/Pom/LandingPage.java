package org.Shiv.Pom;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class LandingPage extends BasePage{

    private static final LandingPage LANDING_PAGE = new LandingPage();
    public static LandingPage getLandingPage(){
        return LANDING_PAGE;
    }

    private final By signinLnk = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
    private final By applicationLogo = By.cssSelector ("#nav-logo-sprites");
    private final By languageSelector = By.cssSelector("#icp-nav-flyout");
    private final By searchBox = By.cssSelector("#twotabsearchtextbox");
    private final By signupBtn = By.cssSelector("nav-action-inner");

}

package org.Shiv.Pom;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class HomePage extends BasePage {
    static final HomePage HOME_PAGE= new HomePage();
    public static HomePage getHomePage(){
        return HOME_PAGE;
    }
    private By deliverTo  = By.id("nav-global-location-popover-link");
    //private By addressList= By.id("a-button-input");
    private By address    = By.xpath("deliverydestinationtype");
    private By addressList= By.id ("GLUXAddressList");
    private By addresses = By.xpath ("//li//span//span//span//input[@class='a-button-input']");
    String name = "shiv";
    private By seeAllLnk = By.xpath ("//span[@id='GLUXMoreLink']/a[contains(text(),'See all')]");
    private By chooseLocation = By.xpath("//input[contains(@aria-label, "+name+")]");
    private By searchBox = By.xpath ("//input[contains(@placeholder, 'Search Amazon')]");
    private By searchIcon = By.id ("nav-search-submit-button");
}

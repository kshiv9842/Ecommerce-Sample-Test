package org.Shiv.Pom;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class HomePageSearchSuggestionPage {
    static final HomePageSearchSuggestionPage HOME_PAGE_SEARCH_SUGGESTION_PAGE = new HomePageSearchSuggestionPage ();
    public static HomePageSearchSuggestionPage getHomePageSearchSuggestionPage(){
        return HOME_PAGE_SEARCH_SUGGESTION_PAGE;
    }
    private By suggestedItem = By.xpath ("//div[@class='s-suggestion s-suggestion-ellipsis-direction' and " +
        "@aria-label]");
}

package org.Shiv.Pom;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class ProductListingPage {
    static final ProductListingPage PRODUCT_LISTING_PAGE= new ProductListingPage ();
    public static ProductListingPage getProductListingPage(){
        return PRODUCT_LISTING_PAGE;
    }
    private By searchedItemList   = By.xpath ("//div[@data-component-type='s-search-result']");
    private By searchedItemRating = By.xpath ("//div[@class = 'a-row a-size-small']/span[1]");
    private By searchedItemPrice  = By.xpath ("//div[@data-component-type='s-search-result']//div[@data-cy='price-recipe']//span[@class='a-price-whole']");
    private By searchedItemName   = By.xpath ("//div[@data-component-type='s-search-result']//span[contains(@class, 'a-text-normal')]");
    private By searchedItemId     = By.xpath ("//div[@data-uuid and @data-component-type='s-search-result']");
    private By searchNextPage     = By.xpath ("//a[contains(text(), 'Next')]");
    private By lastPageOnPagination = By.cssSelector ("span.s-pagination-disabled");
}

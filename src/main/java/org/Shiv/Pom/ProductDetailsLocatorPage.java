package org.Shiv.Pom;

import lombok.Getter;
import lombok.ToString;
import org.Shiv.data.ProductDetails;
import org.openqa.selenium.By;
@Getter
@ToString
public class ProductDetailsLocatorPage {
    static final ProductDetailsLocatorPage PRODUCT_DETAILS_LOCATOR_PAGE = new ProductDetailsLocatorPage ();
    public static ProductDetailsLocatorPage getProductDetailsLocatorPage(){
        return PRODUCT_DETAILS_LOCATOR_PAGE;
    }
    private By productTitle = By.cssSelector ("span#productTitle");
    private By productPrice = By.xpath ("//span[contains(@class, 'priceToPay')]//span[@class='a-price-whole']");
    private By refurbProductPrice = By.cssSelector ("span.a-price.a-text-price.a-size-medium.apexPriceToPay");
    private By deliverTo = By.id ("contextualIngressPtLabel_deliveryShortLine");
    private By productRating = By.xpath ("(//div[@id='averageCustomerReviews']//span//span[@id='acrPopover'])[1]");
    private By productASIN = By.xpath ("//div[@id='productDetails_db_sections']//tr[1]//td");
    private By addCartCTA = By.xpath ("(//input[@id='add-to-cart-button'])[2]");
    private By cartCTA = By.xpath ("//div[@id='attach-added-to-cart-message']//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']");
    private By mainCartCTA = By.id ("nav-cart");
    private By cartItems = By.xpath ("//div[@data-name='Active Items']//div[@data-asin]");
    private By deleteCartItemCTA = By.xpath ("//div[@data-name='Active Items']//input[@data-action='delete']");
    private By cartItemCount = By.id ("nav-cart-count");
    private By noItemInCart = By.xpath ("//div[contains(@class, 'sc-cart-header')]//h2");
}

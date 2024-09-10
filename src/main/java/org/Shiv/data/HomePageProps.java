package org.Shiv.data;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HomePageProps {
    private String choosen_address;
    private String search_product;
    private String no_rating;
    private String no_price;
    private String no_cart_item_placeholder_text;
}

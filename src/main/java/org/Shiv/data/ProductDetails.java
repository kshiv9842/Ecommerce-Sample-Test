package org.Shiv.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDetails {
        public String ProductName;
        public String ProductRating;
        public String ProductPrice;
        public String ProductId;
    public ProductDetails(){
    }
}

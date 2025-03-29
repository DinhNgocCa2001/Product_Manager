package org.product.model.DTO.Shopee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceDetail {
    private String price_min;
    private String price_max;
    private Boolean has_discount;
    private Byte max_discount_percentage;
    private Integer max_discount;
    private String selling_price_min;
    private String selling_price_max;
    private String origin_price;
    private String promotion_price;
}

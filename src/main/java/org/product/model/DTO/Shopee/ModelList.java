package org.product.model.DTO.Shopee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelList {
    private BigInteger id;
    private String name;
    private String sku;
    private List<Integer> tier_index;
    private StockDetail stock_detail;
    private Boolean is_default;
    private String image;
    private Tag tag;
    private Statistics statistics;
    private PriceDetail price_detail;
}

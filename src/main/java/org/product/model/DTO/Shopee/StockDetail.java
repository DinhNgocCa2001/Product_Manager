package org.product.model.DTO.Shopee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockDetail {
    private Integer total_available_stock;
    private Integer total_seller_stock;
    private Integer total_shopee_stock;
    private Integer low_stock_status;

    private Boolean enable_stock_reminder;
    private Boolean model_seller_stock_sold_out;
    private Boolean model_shopee_stock_sold_out;
    private AdvancedStock advanced_stock;
    private Integer enable_stock_reminder_status;
}

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
public class Product {
    private BigInteger id;
    private String name;
    private Byte status;
    private String cover_image;
    private String parent_sku;
    private PriceDetail price_detail;
    private StockDetail stock_detail;
    private Promotion promotion;
    private Statistics statistics;
    private Tag tag;
    private BoostInfo boost_info;
    private BigInteger modify_time;
    private BigInteger create_time;
    private List<ModelList> model_list;
    private PromotionDetail PromotionDetail;
    private Integer scheduled_publish_time;
    private AppealInfo appeal_info;
    private BigInteger mtsku_item_id;
    private Integer available_product;
    private Integer seller_product;
}

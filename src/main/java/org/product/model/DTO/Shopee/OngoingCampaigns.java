package org.product.model.DTO.Shopee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OngoingCampaigns {
    private Integer campaign_type;
    private Integer promo_source;
    private Integer start_time;
    private String price_min;
    private String price_max;
    private String product_id;
    private String model_id;
    private String promotion_price;
}

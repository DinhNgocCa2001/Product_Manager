package org.product.model.DTO.Shopee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    private Boolean is_virtual_sku;
    private Boolean unlist;
    private Boolean has_discount;
    private Boolean wholesale;
    private Boolean has_bundle_deal;
    private Boolean has_add_on_deal;
    private Boolean live_sku;
    private Boolean ssp;
    private Boolean has_ams_commission;
    private Boolean member_exclusive;
    private Boolean is_ipr_appealing;
    private Boolean is_partial_fulfillment;
}

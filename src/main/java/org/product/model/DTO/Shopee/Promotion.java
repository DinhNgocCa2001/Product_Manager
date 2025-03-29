package org.product.model.DTO.Shopee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {
    private List<OngoingCampaigns> ongoing_campaigns;
    private Boolean wholesale;
    private Boolean has_bundle_deal;
}

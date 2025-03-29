package org.product.model.DTO.Shopee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoostInfo {
    private Integer boost_entry_status;
    private Boolean show_boost_history;
    private Integer campaign_id;
}

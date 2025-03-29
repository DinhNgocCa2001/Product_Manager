package org.product.model.DTO.Shopee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IprAppealInfo {
    private Integer appeal_opt;
    private String can_not_appeal_transify_key;
    private Integer reference_id;
    private Integer appeal_status;
}

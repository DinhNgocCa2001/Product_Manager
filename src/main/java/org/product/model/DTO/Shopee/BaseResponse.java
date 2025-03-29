package org.product.model.DTO.Shopee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private Short code;
    private String message;
    private String user_message;
    private BaseDataResponse data;
}

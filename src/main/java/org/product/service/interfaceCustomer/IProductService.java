package org.product.service.interfaceCustomer;

import org.product.model.DTO.Shopee.BaseResponse;

public interface IProductService {
    public BaseResponse getDataIntegration(int page, int size);
}

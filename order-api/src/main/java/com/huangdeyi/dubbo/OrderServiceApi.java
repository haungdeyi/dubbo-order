package com.huangdeyi.dubbo;

public interface  OrderServiceApi {
    //下单业务
    public OrderResponse doOrder(OrderRequest orderRequest);

}

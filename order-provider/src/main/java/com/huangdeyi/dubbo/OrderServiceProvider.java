package com.huangdeyi.dubbo;

public class OrderServiceProvider implements OrderServiceApi{

    @Override
    public OrderResponse doOrder(OrderRequest orderRequest) {
        System.out.println(orderRequest.getName() + "偷偷来过");
        OrderResponse or = new OrderResponse();
        or.setStatus("6666");
        or.setData("调用成功");
        return or;
    }
}

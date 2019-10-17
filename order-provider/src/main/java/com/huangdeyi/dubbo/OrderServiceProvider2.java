package com.huangdeyi.dubbo;

public class OrderServiceProvider2 implements OrderServiceApi{
    @Override
    public OrderResponse doOrder(OrderRequest orderRequest) {
        System.out.println("当前版本是2.0 ：" + orderRequest.getName() + "偷偷来过");
        OrderResponse or = new OrderResponse();
        or.setStatus("9999");
        or.setData("调用2.0版本成功");
        return or;
    }
}

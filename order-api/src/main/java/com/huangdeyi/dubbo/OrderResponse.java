package com.huangdeyi.dubbo;

import java.io.Serializable;

public class OrderResponse implements Serializable {
    private static final long serialVersionUID = 3309390131982564127L;
    private String status;
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

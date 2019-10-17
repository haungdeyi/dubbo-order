package com.huangdeyi.dubbo;

import java.io.Serializable;

public class OrderRequest implements Serializable {
    private static final long serialVersionUID = -903347183975343645L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

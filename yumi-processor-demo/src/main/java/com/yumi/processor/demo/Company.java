package com.yumi.processor.demo;

import com.yumi.processor.BuildProperty;

public class Company {
    String name;

    public String getName() {
        return name;
    }

    @BuildProperty
    public void setName(String name) {
        this.name = name;
    }
}

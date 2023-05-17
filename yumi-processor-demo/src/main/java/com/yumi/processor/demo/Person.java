package com.yumi.processor.demo;

import com.yumi.processor.BuildProperty;

public class Person {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    @BuildProperty
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    @BuildProperty
    public void setEmail(String email) {
        this.email = email;
    }
}

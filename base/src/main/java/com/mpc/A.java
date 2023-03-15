package com.mpc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class A {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.specification.version"));
        System.out.println(Integer.toString(27, 3));


        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        zonedDateTime.toInstant();

        System.out.println(now);
        System.out.println(zonedDateTime);
    }
}

package com.mpc.f2;

public class Main {


    public static void main(String[] args) throws InterruptedException{
        // 当前时间为2023-05-05 05:00:00.000
        Thread.sleep(1000);
        // 其他逻辑
        // 其他逻辑一定会在2023-05-05 05:00:01.000 执行吗
        System.out.println(System.currentTimeMillis());
    }
}

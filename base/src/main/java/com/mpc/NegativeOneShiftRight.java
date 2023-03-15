package com.mpc;

public class NegativeOneShiftRight {

    public static void main(String[] args) {
        // ? 结果是啥
        System.out.println(-1 >> 1);
        // ? 结果是啥
        System.out.println(-1 >> 100000);

        // ? -1 是以补码的形式进行保存的
        System.out.println(Integer.toBinaryString(-1));

    }
}

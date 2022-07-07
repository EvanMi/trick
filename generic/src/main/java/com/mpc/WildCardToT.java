package com.mpc;

import java.util.ArrayList;
import java.util.List;

public class WildCardToT {


    private static <T> void tMethod(List<T> list) {
        T l0 = list.get(0);
        T l1 = list.get(1);
        list.set(1, l0);
        list.set(0, l1);
    }

    public static void wildCardMethod(List<?> list) {
        tMethod(list);
    }


    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        aList.add("0");
        aList.add("1");
        wildCardMethod(aList);


        List<?> wildCardList = new ArrayList<Integer>();
        wildCardList.add(null);
        Object o = wildCardList.get(0);
    }

    public static void aFun(Lo<? super Integer> k) {

    }


    static class Lo<T extends Number> {
        List<?> l1;
        List<? super T> l2;
        List<? super String> l3;
    }


    public static <T> void bFun(T t) {
        return;
    }
}

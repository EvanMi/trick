package com.mpc;

import java.util.ArrayList;
import java.util.List;

public class WildCardToT {



    public static <T> void tMethod(List<T> list, int i, int j) {
        T l0 = list.get(i);
        T l1 = list.get(j);
        list.set(j, l0);
        list.set(i, l1);

    }








    public static void wildCardMethod(List<?> list, int i, int j) {
        Object o0 = list.get(0);
        Object o1 = list.get(1);
        //tMethod(list, i, j);
    }


    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        aList.add("0");
        aList.add("1");

        wildCardMethod(aList, 0, 1);



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

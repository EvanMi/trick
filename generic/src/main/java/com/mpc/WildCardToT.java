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
    }

}

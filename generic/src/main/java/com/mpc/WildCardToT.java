package com.mpc;

import java.util.ArrayList;
import java.util.List;

public class WildCardToT {


    public static <T> void t(List<T> list) {
        T l0 = list.get(0);
        T l1 = list.get(1);
        list.set(1, l0);
        list.set(0, l1);
    }

    public static void tt(List<?> list) {
        t(list);
    }


    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        aList.add("0");
        aList.add("1");
        tt(aList);
    }
}

package com.mpc;

import java.util.Comparator;
import java.util.List;

/**
 * @ClassName CompareClass
 * @Description TODO
 * @Author mipengcheng
 * @Date 2022/6/28 下午8:41
 * @Version 1.0
 */
public class CompareClass<T extends Number> implements Comparable<T> {
    @Override
    public int compareTo(T o) {
        List<? super Integer> list;
        //List<T super Integer> list1;
        //List<T extends Integer> list2;
        List<? extends Integer> list3;
        List<?> list4;
        return 0;
    }
}

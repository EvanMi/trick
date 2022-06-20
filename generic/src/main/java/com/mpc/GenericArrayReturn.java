package com.mpc;

import java.lang.reflect.Array;

public class GenericArrayReturn <T> {
    private final T[] x;

    /**
     * 只要通过class才能创建特定类型的数据结构。
     * 也就是说不管声明如何，运行时的实际类型由class指定了，在做转换时便是安全的。
     *
     * @param clazz 数组内的元素类型
     * @param size 数组长度
     */
    @SuppressWarnings("unchecked")
    public GenericArrayReturn(Class<T> clazz, int size) {
        x = (T[]) Array.newInstance(clazz, size);
    }

    public T[] getArray() {
        return x;
    }


    public static void main(String[] args) {
        GenericArrayReturn<String> obj = new GenericArrayReturn<>(String.class, 10);
        String[] array = obj.getArray();
        System.out.println(array.length);
    }
}

package com.mpc;

public class VarargsToGenericArray {

    /**
     * 该方法将
     * @param ts
     * @param <T>
     * @return
     */
    public static <T> T[] toArray(T... ts) {
        return ts;
    }

    public static <T> T[] twoToArray(T t1, T t2) {
        return toArray(t1, t2);
    }


    public static void main(String[] args) {
        try {
            String[] strArr = twoToArray("A", "B");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " from twoToArray");
        }
        try {
            String[] strArr = toArray("A", "B");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " from toArray");
        }
    }
}



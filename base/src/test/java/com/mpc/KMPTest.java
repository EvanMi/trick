package com.mpc;

public class KMPTest {

    public static void main(String[] args) {

        String x = "aabbcbcdd";
        String y = "bcdd";
        int start = kmp(x, y);
        System.out.println(start);
    }

    private static int kmp(String x, String y) {
        int xLen = x.length(), yLen = y.length();
        int i = 0, j = 0;
        int[] next = next(y);

        while (i < xLen && j < yLen) {
            if (j == -1 || x.charAt(i) == y.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j] - 1;
            }
        }

        if (j == yLen) {
            return i - j;
        }

        return -1;
    }

    private static int[] next(String x) {
        int xLen = x.length();
        int i = 0, k = -1;
        int[] next = new int[xLen];

        while (i < xLen -1) {
            if (k == -1 || x.charAt(i) == x.charAt(k)) {
                i++;
                k++;
                next[i] = k + 1;
            } else {
                k = next[k] - 1;
            }
        }
        return next;
    }

//    private static int kmp(String x, String y) {
//        int xLen = x.length(), yLen = y.length();
//        int i = 0, j = 0;
//
//        int[] next = next(y);
//
//        while (i < xLen && j < yLen) {
//            if (j == -1 || x.charAt(i) == y.charAt(j)) {
//                i++;
//                j++;
//            } else {
//                j = next[j] - 1;
//            }
//        }
//
//        if (j == yLen) {
//            return i - j;
//        }
//
//        return -1;
//    }
//
//    private static int[] next(String y) {
//        int yLen = y.length();
//        int[] next = new int[yLen];
//        int i = 0, j = -1;
//        while (i < yLen - 1) {
//            if (j == -1 || y.charAt(i) == y.charAt(j)) {
//                i++;
//                j++;
//                next[i] = j + 1;
//            } else {
//                j = next[j] - 1;
//            }
//        }
//        return next;
//    }


//    private static int kmp(String x, String y) {
//        int xLen = x.length();
//        int yLen = y.length();
//
//        int i = 0, j = 0;
//
//        int [] next = next(y);
//
//        while (i < xLen && j < yLen) {
//            if (j == -1 || x.charAt(i) == y.charAt(j)) {
//                i++;
//                j++;
//            } else {
//                j = next[j] - 1;
//            }
//        }
//
//        if (j == yLen) {
//            return i - j;
//        }
//
//        return -1;
//    }
//
//    private static int[] next(String y) {
//        int yLen = y.length();
//        int[] next = new int[yLen];
//
//        int k = -1, j = 0;
//
//        while (j < yLen - 1) {
//            if (k == -1 || y.charAt(k) == y.charAt(j)) {
//                j++;
//                k++;
//                next[j] = k + 1;
//            } else {
//                k = next[k] - 1;
//            }
//        }
//        return next;
//    }
}

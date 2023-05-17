package com.yumi.tcf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TCFTest {

    static class FakeRuntimeException extends RuntimeException {}

    static class FakeException extends Exception {}

    public void testFakeRuntimeException() {
        try {
            throw new FakeRuntimeException();
        } catch (FakeRuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void testFakeException() {
        try {
            throw new FakeException();
        } catch (FakeException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }

    public void testFinally() {
        int i = 0;
        try {
            i = 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i++;
        }
        System.out.println(i);
    }

    public int getInt2() {
        int i = 0;
        try {
            i = 1;
            return i;
        } finally {
            i++;
        }
    }

    public int getInt() {
        int i = 0;
        try {
            i = 1;
            i = i / 0;
            return i;
        } finally {
            i++;
            return i;
        }
    }



    public static void main(String[] args) {
        TCFTest tcfTest = new TCFTest();
        System.out.println(tcfTest.getInt());
        System.out.println(tcfTest.getInt2());
    }










    public void doubleTryWithResource() {
        try (InputStream in1 = new FileInputStream("f1");
             InputStream in2 = new FileInputStream("f2")) {

             in1.read();
             in2.read();


        } catch (IOException e) {

        }
    }


    public void tryWithResource() {
        try(InputStream in = new FileInputStream("/yumin")) {
            System.out.println(in.read());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    public void rightTryCatch() {
        try {
            InputStream  in = new FileInputStream("/file");
            //做一些操作
            try {
                int x = in.read()/ 0;
            } catch (Throwable th) {
                try {
                    in.close();
                } catch (Throwable th1) {
                    th.addSuppressed(th1);
                }
                throw th;
            }
            in.close();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
















    public void aRightTryCatch() {
        try {
            InputStream  in = new FileInputStream("/file");
            try {
                int read = in.read();
                read = read / 0;
            } catch (Throwable th) {
                try {
                    in.close();
                } catch (Throwable th1) {
                    th.addSuppressed(th1);
                }
                throw th;
            }
            in.close();
        } catch (FileNotFoundException e) {
            //针对  in = new FileInputStream("/file");
            throw new RuntimeException(e);
        } catch (IOException e) {
            //针对  in.close();
            throw new RuntimeException(e);
        }
    }

}

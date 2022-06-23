package com.mpc;

public class GenericInherit {
    public static void main(String[] args) {
        C c = new C();
        c.b("b");
    }
}

abstract class B<T> {
    abstract public void b(T t);
}

class C extends B<String> {
    @Override
    public void b(String s) {

    }
}
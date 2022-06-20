package com.mpc;

public class InnerClassInherit {

    public class InnerClass {
    }

    public static class NestedClass {
    }
}

class SecondClass extends InnerClassInherit.InnerClass {
    public SecondClass(InnerClassInherit ii) {
        ii.super();
    }
}

class ThirdClass extends InnerClassInherit.NestedClass {
}

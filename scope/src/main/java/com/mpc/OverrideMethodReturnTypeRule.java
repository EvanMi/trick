package com.mpc;

public class OverrideMethodReturnTypeRule {
    public static void main(String[] args) {
        ObjectReturnClass objectReturnClass = new FujiReturnClass();
        Object o = objectReturnClass.returnValue();
        System.out.println(o instanceof Fuji);
    }
}


class Fruit {}
class Apple extends Fruit{}
class Fuji extends Apple{}


class ObjectReturnClass {
    public Object returnValue() {
        return new Object();
    }
}

class FruitReturnClass extends ObjectReturnClass{
    @Override
    public Fruit returnValue() {
        return new Fruit();
    }
}

class AppleReturnClass extends  FruitReturnClass {
    @Override
    public Apple returnValue() {
       return new Apple();
    }
}

class FujiReturnClass extends AppleReturnClass {
    @Override
    public Fuji returnValue() {
        return new Fuji();
    }
}

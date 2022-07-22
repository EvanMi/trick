package com.mpc;

public class OverrideMethodArgsRule {
}

class ArgsFruitClass {
    public void method(Fruit fruit) {}
}

/**
 * ArgsAppleClass继承ArgsFruitClass，并对method进行重写。在重写的过程中尝试将Fruit参数类型具体化为Apple类型
 * 但是这里会报错。原因有两个：
 * 1. 在java中的方法的签名定义为方法名+参数列表，ArgsFruitClass中method方法的签名是 method(Fruit)，
 * 而在ArgsAppleClass中method方法的签名时method(Apple)，所以签名不同，两个方法一定不能是同一个方法。
 * 2. java中重载的限制。在ArgsFruitClass中可以定义一个 public void method(Apple fruit){} 方法来对
 * public void method(Fruit fruit){} 进行重载。所以在java看来，其子类ArgsAppleClass中的 public void method(Apple fruit){}
 * 是public void method(Apple fruit){}的重载方法，而不是重写方法。
 * */
/**
class ArgsAppleClass extends ArgsFruitClass{
    @Override
    public void method(Apple apple) {
    }
}
 */









abstract class GenericArgsClass <T extends Fruit>{
    public abstract void method(T t);
}

class GenericArgsFruitClass extends GenericArgsClass<Fruit> {

    @Override
    public void method(Fruit fruit) {

    }
}

class GenericArgsAppleClass extends GenericArgsClass<Apple> {
    @Override
    public void method(Apple apple) {

    }
}

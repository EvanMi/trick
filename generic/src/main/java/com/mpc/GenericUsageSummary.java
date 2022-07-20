package com.mpc;

import java.util.ArrayList;
import java.util.List;

public class GenericUsageSummary {


    static class Fruit {}
    static class Apple extends Fruit {}
    static class Fuji extends Apple {}

    interface Eatable {}
    interface Colorable {}



    /**define a generic 定义*/

    /**
     * 最普通的泛型使用，在类上定义一个泛型，在该类中的所有非static方法以及field上都可以使用
     * */
    static class NormalGenericDefineDemo <T> {
        private T aFiled;
        //静态变量，不能使用在类上声明的泛型
        //private static T bFiled;

        public T identity(T t) {
            return t;
        }

        //静态方法，不能使用在类上声明的泛型
        //public static T staticIdentity(T t) {
        //    return t;
        //}


        //静态和非静态方法，都可以定义在该方法级别上生效的泛型
        public static <R> R staticIdentity(R t) {
            return t;
        }
        //当然，非静态方法也能使用类上定义的泛型
        public <R> R anotherIdentity(R r, T t) {
            return r;
        }
    }

    /**
     * 在定义一个泛型的时候，可以指定这个泛型的上界。
     * 这就类似于我们定义一个类指定该类的父类， 这里的父类为Fruit。
     * 因为类似于定义一个类时指定类的父类，而在定义类时可以指定实现多个接口，所以泛型也可以声明多个接口。 这里的接口为 Eatable Colorable
     *
     *
     * !!! 千万不要与有边界的wildcard混淆，在定义一个具体的泛型时只能使用extends关键字来指定父类和父接口。
     * 而在wildcard中会有 extends 和 super两个关键字，会有 <? extends String> 和 <? super String> 两种形式。
     * 详情后面的内容会进行介绍
     * */
    static class UpperBoundLimitedGenericDefineDemo <T extends Fruit> {
        public Fruit identity(T t) {
            return t;
        }

        public static <R extends Fruit> Fruit staticGetFruit(R r) {
            return r;
        }

        public <R extends Fruit> Fruit getFruit(R r) {
            return r;
        }
    }

    static class MultiUpperBoundLimitedGenericDefineDemo <T extends Fruit & Eatable & Colorable> {

        public Fruit toFruit(T t) {
            return t;
        }

        public Eatable toEatable(T t) {
            return t;
        }

        public Colorable toColorable(T t) {
            return t;
        }

        public static <R extends Fruit & Eatable & Colorable> Eatable staticGetEatable(R r) {
            return r;
        }

        public <R extends Fruit & Eatable & Colorable> Colorable getColorable(R r) {
            return r;
        }
    }


    abstract static class RootGenericDemo <T> {
        protected abstract T getT(T t);
    }

    //                         泛型定义                    泛型使用
    //                           |                         |
    //                           |                         |
    //                           |                         |
    //                           ↓                         ↓
    static class SubGenericDemo<R> extends RootGenericDemo<R> {
        @Override
        protected R getT(R r) {
            return r;
        }
    }

    static class ConcreteSubGenericDemo extends RootGenericDemo<String> {
        @Override
        protected String getT(String s) {
            return "result";
        }
    }

    //泛型被忽略了，直接变成了Object
    static class NothingSubGenericDemo extends RootGenericDemo {
        @Override
        protected Object getT(Object o) {
            return null;
        }
    }

    //
    static class ComplexUpperBoundLimitedGenericDefineDemo <T extends Comparable<? super T>> extends RootGenericDemo<T> {
        @Override
        protected T getT(T t) {
            return null;
        }
    }

    /**use generic to declare variable 声明泛型变量*/
    static class DeclareGenericVariableDemo {

        //看方法的内部
        public void toolManMethod() {
            //声明一个具体的String类型的list
            List<String> strList;
            //声明一个下界为String类型的wildcard list
            List<? super String> superStrList;
            //声明一个上界为String类型的wildcard list
            List<? extends String> extendsStrList;
            //声明一个没有任何界定的list
            List<?> wildcardList;

            List<? extends Comparable<? super ArrayList<? super String>>> complexList;
        }




    }

    /**use generic to create object 创建泛型对象*/

}

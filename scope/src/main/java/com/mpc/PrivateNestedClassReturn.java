package com.mpc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateNestedClassReturn {

    /**
     * 静态内部类，用英文一般会表述为NestedClass
     * 内部类，用英文则会表述为InnerClass
     * 两者之间有本质区别
     */
    private static class NestedClass extends BaseClass{
        public String name;

        public String getName() {
            return this.name + ", from get name method!";
        }


        @Override
        public String toString() {
            return "NestedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * 将一个private的NestedClass对象返回到外部调用方
     * @return {@link NestedClass}
     */
    public NestedClass getNestedClassInstance() {
        NestedClass nestedClass = new NestedClass();
        nestedClass.name = "getNestedClassInstance";
        return nestedClass;
    }

    public void doSomethingInClassWithNestedClass() {
        NestedClass nestedClass = new NestedClass();
        nestedClass.name = "nestedClass";
        System.out.println(nestedClass.getName());
    }
}

class BaseClass {
    public void baseHello() {
        System.out.println("Hello World");
    }
}

class MainClass{
    public static void main(String[] args) throws Exception {
        PrivateNestedClassReturn privateNestedClassReturn = new PrivateNestedClassReturn();
        //可以正常工作，因为并没有将对外部不可见的NestedClass对外暴露
        privateNestedClassReturn.doSomethingInClassWithNestedClass();
        //编译报错，原因是NestedClass为private，对外部的类不可见。这种不可见包括不能创建NestedClass对象，以及声明一个NestedClass变量。
        //new PrivateNestedClassReturn.NestedClass();
        //PrivateNestedClassReturn.NestedClass nestedClassInstance = privateNestedClassReturn.getNestedClassInstance();
        System.out.println("-------------华丽的分割线----------------");


        //可以使用任何外部可见的父类型变量来接收返回的NestedClass对象
        BaseClass baseClass = privateNestedClassReturn.getNestedClassInstance();
        baseClass.baseHello();
        Object obj = privateNestedClassReturn.getNestedClassInstance();
        System.out.println(obj.toString());
        System.out.println("-------------华丽的分割线----------------");


        //上面的方法已经再也无法操作NestedClass的任何属性和方法，只能通过反射来进一步操作
        //1.不管用什么类型的变量来接收一个对象，通过getClass都可以获取到该对象真实的class信息
        System.out.println(obj.getClass().getName());
        //2.通过反射进行操作
        Class<?> aClass = obj.getClass();
        Method getName = aClass.getMethod("getName");
        Object result = getName.invoke(obj);
        System.out.println(result.getClass());
        System.out.println(result);
        Field nameField = aClass.getField("name");
        Object name = nameField.get(obj);
        System.out.println(name);

    }
}

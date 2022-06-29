package com.mpc;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GenericInherit {
    public static void main(String[] args) {
        printClassInfo(B.class);
        printClassInfo(C.class);

        B<String> bc = new C();
        //bc.b(Integer.valueOf(1));
        bc.b("1");
    }

    private static void printClassInfo(Class<?> aClass) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Modifier.toString(aClass.getModifiers()));
        stringBuilder.append(" class ");
        stringBuilder.append(aClass.getSimpleName() + "{");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods
        ) {
            stringBuilder.append("\n");
            stringBuilder.append("\t");
            stringBuilder.append(Modifier.toString(method.getModifiers()));
            stringBuilder.append(" ");
            stringBuilder.append(method.getReturnType().getSimpleName());
            stringBuilder.append(" ");
            stringBuilder.append(method.getName());
            stringBuilder.append("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class pClass : parameterTypes
            ) {
                stringBuilder.append(pClass.getName() + ",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("){}");
            stringBuilder.append("\n");

        }
        stringBuilder.append("}");
        System.out.println(stringBuilder);
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
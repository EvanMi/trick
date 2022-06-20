package com.mpc;

public class GenericArrayCannotReturn<A> {
    private final A[] x;

    @SuppressWarnings("unchecked")
    public GenericArrayCannotReturn(int size) {
        //完全不能进行new操作，其原因是由于泛型擦除后无法确定具体的类型，就无法创建对象
        //因为创建对象的过程中需要进行明确的内存分配
        //A 在此处只理解为一个简单的标记即可
        //this.x = new A [size];
        this.x = (A[]) new Object[size];
    }

    /**
     * 返回泛型数组
     * @return 泛型数组
     */
    public A[] getArray() {
        return x;
    }

    /**
     * 输出数组的长度，会调用{@link GenericArrayCannotReturn#getArray()} 方法来获取到实例化的数组
     */
    public void printArrayLength() {
        A[] array = getArray();
        System.out.println(array.length);
    }


    public static void main(String[] args) {
        GenericArrayCannotReturn<String> strArray = new GenericArrayCannotReturn<>(1);
        strArray.printArrayLength();
        System.out.println("-------------华丽的分割线----------------");
        try {
            String[] array = strArray.getArray();

        } catch (Exception e) {
            //这里一定会报转换异常
            System.out.println(e.getMessage());
        }
    }
}

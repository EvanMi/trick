package com.mpc;

import java.util.ArrayList;
import java.util.List;

/**
 * BoundedWildCard PECS示例
 */
public class GenericBoundedWildCardPeCs {

    /**
     * 这里容器(container)会消费元素（c),所以使用super类型的泛型(s)
     *
     * @param container
     */
    public static void containerConsumer(List<? super Fuji> container) {
        Fuji fuji = new Fuji();
        container.add(fuji);
    }

    /**
     * 这里容器(container)会提供元素(p)，所以使用extends类型的泛型(e)
     *
     * @param container
     */
    public static void containerProducer(List<? extends Fruit> container) {
        if (!container.isEmpty()) {
            Fruit fruit = container.get(0);
            System.out.println(fruit.getName());
        }
    }


    public static void main(String[] args) {
        testContainerConsumer();
        testContainerProducer();
    }


    public static void testContainerConsumer() {
        List<Object> objectList = new ArrayList<>();
        containerConsumer(objectList);

        List<Fruit> fruitList = new ArrayList<>();
        containerConsumer(fruitList);

        List<Apple> appleList = new ArrayList<>();
        containerConsumer(appleList);

        List<Fuji> fujiList = new ArrayList<>();
        containerConsumer(fujiList);

        List<GeDaGouFuji> geDaGouFujiList = new ArrayList<>();
        //编译器报错，无法接受该类型的参数
        //containerConsumer(geDaGouFujiList);
    }

    public static void testContainerProducer() {
        Jonathan jonathan = new Jonathan();

        List<Object> objectList = new ArrayList<>();
        objectList.add(jonathan);
        //编译器报错，无法接受该类型的参数
        //containerProducer(objectList);

        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(jonathan);
        containerProducer(fruitList);

        List<Apple> appleList = new ArrayList<>();
        appleList.add(jonathan);
        containerProducer(appleList);

        List<Jonathan> jonathanList = new ArrayList<>();
        jonathanList.add(jonathan);
        containerProducer(jonathanList);
    }

}

abstract class Fruit {
    public abstract String getName();
}

class Apple extends Fruit {
    @Override
    public String getName() {
        return "就是一个苹果";
    }
}

class Fuji extends Apple {
    @Override
    public String getName() {
        return "富士苹果";
    }
}


class GeDaGouFuji extends Fuji {
    @Override
    public String getName() {
        return "疙瘩沟生产的富士苹果";
    }
}

class Jonathan extends Apple {

    @Override
    public String getName() {
        return "红玉苹果";
    }
}
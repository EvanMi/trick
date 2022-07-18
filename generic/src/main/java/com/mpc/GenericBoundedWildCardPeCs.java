package com.mpc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
        Fuji fuji = new Fuji(300);
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

    /**
     * 这里入参的Comparator扮演的是一个消费者的角色，即消费泛型参数，然后一个产生整数的比较结果。
     * 具体的消费方法是 {@link Comparator#compare(Object, Object)}
     * @param comparator
     */
    public static void comparatorConsumer(Comparator<? super Fuji> comparator) {
        GeDaGouFuji smallOne = new GeDaGouFuji(10);
        GeDaGouFuji bigOne = new GeDaGouFuji(20);
        comparator.compare(smallOne, bigOne);
    }


    public static void fruitProducer(FruitProducer<? extends Fruit> fruitProducer) {
        Fruit produce = fruitProducer.produce();
        System.out.println(produce.getName());
    }


    public static void testFruitProducer() {
        FruitProducer<Fuji> fruitFruitProducer = new FruitProducer<>();
        fruitFruitProducer.addAll(new Fuji(10), new GeDaGouFuji(20), new Fuji(10));
        fruitProducer(fruitFruitProducer);

        FruitProducer<Apple> appleFruitProducer = new FruitProducer<>();
        appleFruitProducer.addAll(new Fuji(10), new GeDaGouFuji(20), new Fuji(10));
        fruitProducer(appleFruitProducer);

    }


    static class FruitProducer<T> {
        private List<T> fujiList = new ArrayList<>();

        public void addAll(T...ts) {
            for (T t : ts) {
                fujiList.add(t);
            }
        }

        T produce() {
            int size = fujiList.size();
            int i = ThreadLocalRandom.current().nextInt(size);
            return fujiList.get(i);
        }
    }



    public static void main(String[] args) {
        testContainerConsumer();
        testContainerProducer();
        testComparatorConsumer();
        testFruitProducer();
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
        Jonathan jonathan = new Jonathan(300);

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


    public static void testComparatorConsumer() {
        Comparator<Object> objectComparator = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 1;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        comparatorConsumer(objectComparator);

        Comparator<Fruit> fruitComparator = new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                if (o1.getWeight() > o2.getWeight()) {
                    return 1;
                } else if (o1.getWeight() < o2.getWeight()) {
                    return -1;
                } else {
                    return 0;
                }
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        comparatorConsumer(fruitComparator);

        Comparator<Apple> appleComparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                if (o1.getWeight() > o2.getWeight()) {
                    return 1;
                } else if (o1.getWeight() < o2.getWeight()) {
                    return -1;
                } else {
                    return 0;
                }
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        comparatorConsumer(appleComparator);

        Comparator<Fuji> fujiComparator = new Comparator<Fuji>() {
            @Override
            public int compare(Fuji o1, Fuji o2) {
                if (o1.getWeight() > o2.getWeight()) {
                    return 1;
                } else if (o1.getWeight() < o2.getWeight()) {
                    return -1;
                } else {
                    return 0;
                }
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        comparatorConsumer(fujiComparator);

        Comparator<GeDaGouFuji> geDaGouFujiComparator = new Comparator<GeDaGouFuji>() {
            @Override
            public int compare(GeDaGouFuji o1, GeDaGouFuji o2) {
                if (o1.getWeight() > o2.getWeight()) {
                    return 1;
                } else if (o1.getWeight() < o2.getWeight()) {
                    return -1;
                } else {
                    return 0;
                }
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        //无法赋值
        //comparatorProducer(geDaGouFujiComparator);

    }

}

abstract class Fruit {
    public abstract String getName();

    public abstract int getWeight();
}

class Apple extends Fruit {
    private int weight;

    public Apple(int weight) {
        this.weight = weight;
    }
    @Override
    public String getName() {
        return "就是一个苹果";
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
}

class Fuji extends Apple {
    public Fuji(int weight) {
        super(weight);
    }

    @Override
    public String getName() {
        return "富士苹果";
    }
}


class GeDaGouFuji extends Fuji {
    public GeDaGouFuji(int weight) {
        super(weight);
    }

    @Override
    public String getName() {
        return "疙瘩沟生产的富士苹果";
    }
}

class Jonathan extends Apple {

    public Jonathan(int weight) {
        super(weight);
    }

    @Override
    public String getName() {
        return "红玉苹果";
    }
}
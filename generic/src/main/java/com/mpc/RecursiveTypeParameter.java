package com.mpc;

public class RecursiveTypeParameter {
    public static void main(String[] args) {
        WomanSelf womanSelf = new WomanSelf();
        womanSelf.doSelf(womanSelf);

        ManSelf manSelf = new ManSelf();
        manSelf.doSelf(manSelf);
    }
}

abstract class Self <T extends Self<T>> {
    protected abstract Self doSelf(T self);
}

class WomanSelf extends Self <WomanSelf> {

    @Override
    protected WomanSelf doSelf(WomanSelf self) {
        return self;
    }
}


class ManSelf extends Self<ManSelf> {

    @Override
    protected ManSelf doSelf(ManSelf self) {
        return self;
    }
}

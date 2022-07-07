package com.mpc;

public class RecursiveTypeParameter {
    public static void main(String[] args) throws SelfException {
        WomanSelf womanSelf = new WomanSelf();
        womanSelf.doSelf(womanSelf);

        ManSelf manSelf = new ManSelf();
        manSelf.doSelf(manSelf);
    }
}

abstract class Self <T extends Self<T>> {
    protected abstract Self doSelf(T self) throws SelfException;
}

class WomanSelf extends Self <WomanSelf> {

    @Override
    protected WomanSelf doSelf(WomanSelf self) throws ManSelfException{
        if (null == self) {
            throw  new ManSelfException();
        }
        return self;
    }
}


class ManSelf extends Self<ManSelf> {

    @Override
    protected ManSelf doSelf(ManSelf self) {
        return self;
    }
}


class SelfException extends Exception {}

class ManSelfException extends SelfException {}
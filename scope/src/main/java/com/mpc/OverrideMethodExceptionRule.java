package com.mpc;

public class OverrideMethodExceptionRule {
}

class RootException extends Exception {}

class ChildException extends  RootException {}


class RootExceptionClass {
    public void doThrow() throws RootException {
        throw  new RootException();
    }
}

class ChildExceptionClass extends RootExceptionClass{
    @Override
    public void doThrow() throws ChildException {
        throw new ChildException();
    }
}

class NoExceptionClass extends RootExceptionClass{
    @Override
    public void doThrow() {
    }
}

/** 报错信息：overridden method does not throw 'java.lang.Exception' */
//class FaultExceptionClass extends RootExceptionClass {
//    @Override
//    public void doThrow() throws Exception {
//        throw new Exception();
//    }
//}


class RootRuntimeException extends RuntimeException {}

class ChildRuntimeException extends RuntimeException {}

class RootRuntimeExceptionClass {
    public void doThrow() throws RootRuntimeException {
        throw new RootRuntimeException();
    }
}

class ChildRuntimeExceptionClass extends RootRuntimeExceptionClass{
    @Override
    public void doThrow() throws ChildRuntimeException {
        throw new ChildRuntimeException();
    }
}

class NoRuntimeExceptionClass extends RootRuntimeExceptionClass {
    @Override
    public void doThrow() {
        
    }
}

class ShouldFaultRuntimeExceptionClass extends RootRuntimeExceptionClass {
    @Override
    public void doThrow() throws RuntimeException {
        throw new RuntimeException();
    }
}


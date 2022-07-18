package com.mpc;

public class OverrideMethodExceptionRule {
}

class RootException extends Exception {}

class ChildException extends  RootException {}

class AnotherChildException extends RootException{}

class GrandsonException extends ChildException{}

class AnotherGrandsonException extends AnotherChildException{}


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


class AllChildrenExceptionClass extends RootExceptionClass {
    @Override
    public void doThrow() throws ChildException, AnotherChildException {
        long now = System.nanoTime();
        if (now % 2 == 0) {
            throw new ChildException();
        } else {
            throw new AnotherChildException();
        }
    }
}

class AllGrandsonExceptionClass extends AllChildrenExceptionClass {
    @Override
    public void doThrow() throws GrandsonException, AnotherGrandsonException {
    }
}


class OneGrandsonExceptionClass extends AllChildrenExceptionClass {
    @Override
    public void doThrow() throws GrandsonException {
    }
}

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


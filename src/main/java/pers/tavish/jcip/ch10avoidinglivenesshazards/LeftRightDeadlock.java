package pers.tavish.jcip.ch10avoidinglivenesshazards;

// 程序清单10-1
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }

    private void doSomething() {
    }

    private void doSomethingElse() {
    }
}

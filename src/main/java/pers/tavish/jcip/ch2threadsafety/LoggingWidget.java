package pers.tavish.jcip.ch2threadsafety;

// 程序清单2-7
class Widget {
    public synchronized void doSomething() {
        // ...
    }
}

public class LoggingWidget extends Widget {
    @Override
    public synchronized void doSomething() {
        // ...
        super.doSomething();
    }
}



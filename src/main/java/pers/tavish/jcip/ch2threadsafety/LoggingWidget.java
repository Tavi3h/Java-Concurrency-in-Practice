package pers.tavish.jcip.ch2threadsafety;

// 程序清单2-7
public class LoggingWidget extends Widget {
    @Override
    public synchronized void doSomething() {
        // ...
        super.doSomething();
    }
}



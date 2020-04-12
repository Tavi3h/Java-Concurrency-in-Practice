package pers.tavish.jcip.ch4composingobjects;

import net.jcip.annotations.GuardedBy;
import pers.tavish.jcip.ch2threadsafety.Widget;

// 程序清单4-3
public class PrivateLock {
    private final Object myLock = new Object();

    @GuardedBy("myLock")
    private Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // Access or modify the state of widget
        }
    }
}

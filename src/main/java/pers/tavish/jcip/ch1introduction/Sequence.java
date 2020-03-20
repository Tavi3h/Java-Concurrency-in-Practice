package pers.tavish.jcip.ch1introduction;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

// 程序清单1-2
@ThreadSafe
public class Sequence {

    @GuardedBy("this")
    private int value;

    public synchronized int getNext() {
        return value++;
    }
}

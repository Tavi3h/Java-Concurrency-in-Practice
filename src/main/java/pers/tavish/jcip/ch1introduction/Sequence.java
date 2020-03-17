package pers.tavish.jcip.ch1introduction;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Sequence {

    @GuardedBy("this")
    private int value;

    public synchronized int getNext() {
        return value++;
    }
}

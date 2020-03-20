package pers.tavish.jcip.ch1introduction;

import net.jcip.annotations.NotThreadSafe;

// 程序清单1-1
@NotThreadSafe
public class UnSafeSequence {

    private int value;

    public int getNext() {
        return value++;
    }
}

package pers.tavish.jcip.ch1introduction;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnSafeSequence {

    private int value;

    public int getNext() {
        return value++;
    }
}

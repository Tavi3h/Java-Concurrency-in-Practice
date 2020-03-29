package pers.tavish.jcip.ch3sharingobjects;

import net.jcip.annotations.NotThreadSafe;

// 程序清单3-2
@NotThreadSafe
public class MutableInteger {

    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
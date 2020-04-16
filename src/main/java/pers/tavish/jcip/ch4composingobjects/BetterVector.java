package pers.tavish.jcip.ch4composingobjects;

import net.jcip.annotations.ThreadSafe;

import java.util.Vector;

// 程序清单4-13
@ThreadSafe
public class BetterVector<E> extends Vector<E> {
    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }
}

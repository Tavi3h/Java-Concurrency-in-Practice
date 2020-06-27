package pers.tavish.jcip.ch14buildingcustomsynchronizers;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

// 程序清单14-9
@ThreadSafe
public class ThreadGate {

    // 条件谓词：(isOpen || generation > n)
    @GuardedBy("this")
    private boolean isOpen;

    @GuardedBy("this")
    private int generation;

    public synchronized void close() {
        isOpen = false;
    }

    public synchronized void open() {
        ++generation;
        isOpen = true;
        notifyAll();
    }

    public synchronized void await() throws InterruptedException {
        int arrivalGeneration = generation;
        while (!isOpen && arrivalGeneration == generation) {
            wait();
        }
    }
}

package pers.tavish.jcip.ch15atomicvariablesandnonblockingsynchronization;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 程序清单15-4
@ThreadSafe
public class ReentrantLockPseudoRandom extends PseudoRandom {

    private final Lock lock = new ReentrantLock(false);
    private int seed;

    ReentrantLockPseudoRandom(int seed) {
        this.seed = seed;
    }

    public int nextInt(int n) {
        lock.lock();
        try {
            int s = seed;
            seed = calculateNext(s);
            int remainder = s % n;
            return remainder > 0 ? remainder : remainder + n;
        } finally {
            lock.unlock();
        }
    }
}
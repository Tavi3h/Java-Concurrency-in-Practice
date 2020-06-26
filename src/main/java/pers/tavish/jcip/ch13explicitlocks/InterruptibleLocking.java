package pers.tavish.jcip.ch13explicitlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 程序清单13-5
public class InterruptibleLocking {
    private Lock lock = new ReentrantLock();

    public boolean sendOnSharedLine(String message) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            return cancellableSendOnSharedLine(message);
        } finally {
            lock.unlock();
        }
    }

    private boolean cancellableSendOnSharedLine(String message) {
        /* send something */
        return true;
    }

}

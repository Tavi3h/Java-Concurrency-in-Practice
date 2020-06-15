package pers.tavish.jcip.ch8applyingthreadpools;

import java.util.concurrent.ThreadFactory;

// 程序清单8-6
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    public Thread newThread(Runnable runnable) {
        return new MyAppThread(runnable, poolName);
    }
}

package pers.tavish.jcip.ch6taskexecution;

import java.util.concurrent.Executor;

// 程序清单6-5
// 每个任务一个线程
public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable r) {
        new Thread(r).start();
    }
}


package pers.tavish.jcip.ch6taskexecution;

import java.util.concurrent.Executor;

// 程序清单6-6
// 所有任务一个线程
public class WithinThreadExecutor implements Executor {
    @Override
    public void execute(Runnable r) {
        r.run();
    }
}

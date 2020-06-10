package pers.tavish.jcip.ch7cancellationandshutdown;

import java.util.concurrent.*;

// 程序清单7-10
public class TimedRun {
    private static final ExecutorService taskExec = Executors.newCachedThreadPool();

    public static void timedRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        Future<?> task = taskExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
            // task will be cancelled below
        } catch (ExecutionException e) {
            // exception thrown in task; rethrow
            throw LaunderThrowable.launderThrowable(e.getCause());
        } finally {
            // Harmless if task already completed
            task.cancel(true); // interrupt if running
        }
    }

    static class LaunderThrowable {

        static RuntimeException launderThrowable(Throwable t) {
            if (t instanceof RuntimeException)
                return (RuntimeException) t;
            else if (t instanceof Error)
                throw (Error) t;
            else
                throw new IllegalStateException("Not unchecked", t);
        }
    }
}



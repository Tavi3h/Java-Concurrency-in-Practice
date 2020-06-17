package pers.tavish.jcip.ch11performanceandscalability;

import java.util.concurrent.BlockingQueue;

// 程序清单11-1
public class WorkerThread extends Thread {

    private final BlockingQueue<Runnable> queue;

    public WorkerThread(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                Runnable task = queue.take();
                task.run();
            } catch (InterruptedException e) {
                break; /* Allow thread to exit */
            }
        }
    }
}

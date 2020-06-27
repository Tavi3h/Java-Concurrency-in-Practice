package pers.tavish.jcip.ch14buildingcustomsynchronizers;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;


// 程序清单14-14
@ThreadSafe
public class OneShotLatch {

    private final Sync sync = new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected int tryAcquireShared(int ignored) {
            return getState() == 1 ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int ignored) {
            setState(1);
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OneShotLatch latch = new OneShotLatch();
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.signal();
            }
        });
        thread.start();

        System.out.println("acquire");
        latch.await();
        System.out.println("acquire done..." + thread.getState().name());
    }
}

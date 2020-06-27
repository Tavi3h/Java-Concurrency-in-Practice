package pers.tavish.jcip.ch14buildingcustomsynchronizers;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.TimeUnit;

// 程序清单14-5
@ThreadSafe
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    private static final int SLEEP_GRANULARITY = 100000;

    protected SleepyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                    return;
                }
                TimeUnit.MILLISECONDS.sleep(SLEEP_GRANULARITY);

            }
        }
    }

    public V take() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isEmpty()) {
                    return doTake();
                }
                TimeUnit.MILLISECONDS.sleep(SLEEP_GRANULARITY);
            }
        }
    }
}

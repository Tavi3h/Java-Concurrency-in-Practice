package pers.tavish.jcip.ch14buildingcustomsynchronizers;

import net.jcip.annotations.ThreadSafe;

// 程序清单14-6
@ThreadSafe
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {

    protected BoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        doPut(v);
        notifyAll();
    }

    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        V v = doTake();
        notifyAll();
        return v;
    }
}

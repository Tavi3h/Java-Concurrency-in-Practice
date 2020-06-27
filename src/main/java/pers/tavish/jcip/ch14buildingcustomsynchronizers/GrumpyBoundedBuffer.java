package pers.tavish.jcip.ch14buildingcustomsynchronizers;

import net.jcip.annotations.ThreadSafe;

// 程序清单14-3
@ThreadSafe
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    protected GrumpyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws BufferFullException {
        if (isFull()) {
            throw new BufferFullException();
        }
        doPut(v);
    }

    public synchronized V take() throws BufferEmptyException {
        if (isEmpty()) {
            throw new BufferEmptyException();
        }
        return doTake();
    }

    private static class BufferFullException extends Throwable {

    }

    private static class BufferEmptyException extends Throwable {

    }
}

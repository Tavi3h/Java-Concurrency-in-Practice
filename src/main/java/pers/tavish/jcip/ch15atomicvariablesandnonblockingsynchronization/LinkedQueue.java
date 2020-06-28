package pers.tavish.jcip.ch15atomicvariablesandnonblockingsynchronization;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

// 程序清单15-7
@ThreadSafe
public class LinkedQueue<E> {

    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        Node(E item, LinkedQueue.Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }

    private final LinkedQueue.Node<E> dummy = new LinkedQueue.Node<>(null, null);
    private final AtomicReference<LinkedQueue.Node<E>> head = new AtomicReference<>(dummy);
    private final AtomicReference<LinkedQueue.Node<E>> tail = new AtomicReference<>(dummy);

    public boolean put(E item) {
        LinkedQueue.Node<E> newNode = new LinkedQueue.Node<>(item, null);
        while (true) {
            LinkedQueue.Node<E> curTail = tail.get();
            LinkedQueue.Node<E> tailNext = curTail.next.get();
            if (curTail == tail.get()) {
                if (tailNext != null) {
                    // Queue in intermediate state, advance tail
                    tail.compareAndSet(curTail, tailNext);
                } else {
                    // In quiescent state, try inserting new node
                    if (curTail.next.compareAndSet(null, newNode)) {
                        // Insertion succeeded, try advancing tail
                        tail.compareAndSet(curTail, newNode);
                        return true;
                    }
                }
            }
        }
    }
}
package pers.tavish.jcip.ch15atomicvariablesandnonblockingsynchronization;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

// 程序清单15-6
@ThreadSafe
public class ConcurrentStack<E> {

    private AtomicReference<Node<E>> top = new AtomicReference<>();

    public void push(E item) {
        Node<E> newHead = new Node<E>(item);
        Node<E> oldHead;
        do {
            oldHead = top.get();
            newHead.next = oldHead;
        } while (!top.compareAndSet(oldHead, newHead));
    }

    public E pop() {
        Node<E> oldHead;
        Node<E> newHead;
        do {
            oldHead = top.get();
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.next;
        } while (!top.compareAndSet(oldHead, newHead));
        return oldHead.item;
    }

    private static class Node<E> {

        private final E item;
        private Node<E> next;

        private Node(E item) {
            this.item = item;
        }
    }
}
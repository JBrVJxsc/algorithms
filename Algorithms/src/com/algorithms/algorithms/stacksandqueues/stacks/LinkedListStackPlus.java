package com.algorithms.algorithms.stacksandqueues.stacks;

import com.algorithms.algorithms.stacksandqueues.stacks.interfaces.IStackPlus;

import java.util.Iterator;

/**
 * Created by Who on 2014/4/20.
 */
public class LinkedListStackPlus<T> implements IStackPlus<T> {

    private Node firstNode = null;

    public void push(T item) {
        Node oldFirstNode = firstNode;
        firstNode = new Node();
        firstNode.setItem(item);
        firstNode.setNext(oldFirstNode);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T item = firstNode.getItem();
        firstNode = firstNode.getNext();
        return item;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    @Override
    public Iterator iterator() {
        return new StackIterator<T>(this);
    }

    private class StackIterator<T> implements Iterator<T> {

        private LinkedListStackPlus linkedListStackPlus = null;
        private Node pointer = null;

        public StackIterator(LinkedListStackPlus linkedListStackPlus) {
            this.linkedListStackPlus = linkedListStackPlus;
            pointer = this.linkedListStackPlus.getFirstNode();
        }

        @Override
        public boolean hasNext() {
            return pointer != null;
        }

        @Override
        public T next() {
            T t = (T) pointer.getItem();
            pointer = pointer.getNext();
            return t;
        }
    }

    private class Node {
        T item = null;
        Node next = null;

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

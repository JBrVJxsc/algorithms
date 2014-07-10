package com.algorithms.algorithms.stacksandqueues.programmingassignments;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Who on 2014/4/22.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first = null;
    private Node<Item> last = null;
    private int size = 0;

    public Deque() {
    }

    public static void main(String[] args) {

    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node node = new Node(item);
        node.setNext(first);
        if (first != null) {
            first.setLast(node);
        }
        first = node;
        if (last == null) {
            last = first;
        }
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node node = new Node(item);
        node.setLast(last);
        if (last != null) {
            last.setNext(node);
        }
        last = node;
        if (first == null) {
            first = last;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.getItem();
        first = first.getNext();
        size--;
        if (size == 0) {
            first = last = null;
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = last.getItem();
        last = last.getLast();
        size--;
        if (size == 0) {
            last = first = null;
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator<Item>(this);
    }

    private class DequeIterator<Item> implements Iterator<Item> {

        private Node<Item> pointer = null;
        private Deque<Item> deque = null;

        public DequeIterator(Deque<Item> deque) {
            this.deque = deque;
            pointer = (Node<Item>) this.deque.first;
        }

        @Override
        public boolean hasNext() {
            return pointer != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = pointer.getItem();
            pointer = pointer.getNext();
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node<Item> {

        Item item = null;
        Node next = null;
        Node last = null;

        public Node(Item item) {
            this.item = item;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getLast() {
            return last;
        }

        public void setLast(Node last) {
            this.last = last;
        }
    }
}

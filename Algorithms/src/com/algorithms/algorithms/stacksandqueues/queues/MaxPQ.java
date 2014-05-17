package com.algorithms.algorithms.stacksandqueues.queues;

import com.algorithms.algorithms.stacksandqueues.queues.interfaces.IQueue;

/**
 * Created by Who on 2014/4/30.
 */
public class MaxPQ<Key extends Comparable<Key>> implements IQueue<Key> {

    private Key[] pq;
    private int size = 0;

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public MaxPQ(Key[] a) {
        pq = (Key[]) new Comparable[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            pq[i + 1] = a[i];
        }
    }

    public void insert(Key v) {
        if (size == pq.length - 1) {
            return;
        }
        pq[++size] = v;
        swim(size);
    }

    public Key delMax() {
        if (isEmpty()) {
            return null;
        }
        Key key = pq[1];
        exch(1, size);
        pq[size--] = null;
        sink(1);
        return key;
    }

    public Key max() {
        if (isEmpty()) {
            return null;
        }
        return pq[1];
    }

    public int size() {
        return size;
    }

    private void swim(int k) {
        //My method..
        if (false) {
            int i = k;
            while (i > 1 && less(i / 2, i)) {
                exch(i / 2, i);
                i /= 2;
            }
        }
        //Course's method.
        else {
            while (k > 1 && less(k / 2, k)) {
                exch(k, k / 2);
                k = k / 2;
            }
        }
    }

    private void sink(int k) {
        //My method.
        if (false) {
            int i = k * 2;
            int length = size;
            while (i <= length) {
                if (i < length && less(i, i++)) {
                    i++;
                }
                if (less(i, i / 2)) {
                    exch(i, i / 2);
                } else {
                    break;
                }
                i *= 2;
            }
        }
        //Course's method.
        else {
            int length = size;
            while (2 * k <= length) {
                int j = 2 * k;
                if (j < length && less(j, j + 1)) {
                    j++;
                }
                if (!less(k, j)) {
                    break;
                }
                exch(k, j);
                k = j;
            }
        }
    }

    private boolean less(int i, int j) {
        if (pq[i].compareTo(pq[j]) < 0) {
            return true;
        }
        return false;
    }

    private void exch(int i, int j) {
        Key item = pq[i];
        pq[i] = pq[j];
        pq[j] = item;
    }

    @Override
    public void enqueue(Key item) {
        insert(item);
    }

    @Override
    public Key dequeue() {
        return delMax();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String getQueueItems() {
        if (isEmpty()) {
            return "Get queue items failed. MaxPQ is empty now.";
        }
        String string = "";
        int length = size;
        for (int i = 1; i <= length; i++) {
            if (pq[i] != null) {
                string += pq[i].toString() + " ";
            }
        }
        return string;
    }
}

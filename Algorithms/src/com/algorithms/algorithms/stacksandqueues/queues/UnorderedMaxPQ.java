package com.algorithms.algorithms.stacksandqueues.queues;

/**
 * Created by Who on 2014/4/30.
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        exch(max, N - 1);
        return pq[--N];
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
}

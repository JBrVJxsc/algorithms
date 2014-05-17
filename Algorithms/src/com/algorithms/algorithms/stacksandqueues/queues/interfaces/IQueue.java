package com.algorithms.algorithms.stacksandqueues.queues.interfaces;

/**
 * Created by Who on 2014/4/19.
 */
public interface IQueue<T> {
    void enqueue(T item);

    T dequeue();

    boolean isEmpty();

    String getQueueItems();
}

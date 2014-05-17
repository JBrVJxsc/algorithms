package com.algorithms.algorithms.stacksandqueues.bag.interfaces;

/**
 * Created by Who on 2014/4/20.
 */
public interface IBag<T> extends Iterable<T> {
    void add(T item);

    int size();
}

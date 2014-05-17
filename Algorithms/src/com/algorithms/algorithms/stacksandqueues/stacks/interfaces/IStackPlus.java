package com.algorithms.algorithms.stacksandqueues.stacks.interfaces;

/**
 * Created by Who on 2014/4/20.
 */
public interface IStackPlus<T> extends Iterable<T> {
    T pop();

    void push(T item);

    boolean isEmpty();
}

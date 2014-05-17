package com.algorithms.algorithms.stacksandqueues.queues;

import com.algorithms.algorithms.stacksandqueues.queues.interfaces.IQueue;

/**
 * Created by Who on 2014/4/19.
 */
public class ArrayQueue<T> implements IQueue<T> {

    //Only 100 (or any other specific number) space for items. A defect of array implementation of Stack.
    private T[] items = (T[]) new Object[100];
    private int top = 0;
    private int bottom = 0;

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = items[top];
        items[top] = null;
        top++;
        return item;
    }

    @Override
    public void enqueue(T item) {
        if (bottom == items.length) {
            return;
        }
        items[bottom++] = item;
    }

    @Override
    public boolean isEmpty() {
        if (bottom - top == 0) {
            top = bottom = 0;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getQueueItems() {
        if (isEmpty()) {
            return "Get queue items failed. Array queue is empty now.";
        }
        String string = "";
        for (int i = bottom - 1; i >= 0; i--) {
            if (items[i] != null) {
                string += items[i].toString() + " ";
            }
        }
        return string;
    }
}

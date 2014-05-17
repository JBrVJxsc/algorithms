package com.algorithms.algorithms.stacksandqueues.queues;

import com.algorithms.algorithms.stacksandqueues.queues.interfaces.IQueue;

/**
 * Created by Who on 2014/4/19.
 */
public class ResizingArrayQueue<T> implements IQueue<T> {

    private int top = 0;
    private int bottom = 0;
    private T[] items = (T[]) new Object[1];

    @Override
    public void enqueue(T item) {
        items[bottom++] = item;
        if (bottom >= items.length) {
            resize();
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = items[top];
        int size = size();
        if (size != 0 && size <= items.length / 4) {
            resize();
        }
        items[top] = null;
        top++;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String getQueueItems() {
        if (isEmpty()) {
            return "Get queue items failed. Resizing array queue is empty now.";
        }
        String string = "";
        for (int i = top; i <= bottom; i++) {
            if (items[i] != null) {
                string += items[i].toString() + " ";
            }
        }
        return string;
    }

    private int size() {
        return bottom - top;
    }

    private void resize() {
        int size = size();
        int newSize = size * 2;
        T[] newItems = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[i + top];
        }
        bottom -= top;
        top = 0;
        items = newItems;
    }
}

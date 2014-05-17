package com.algorithms.algorithms.stacksandqueues.stacks;

import com.algorithms.algorithms.stacksandqueues.stacks.interfaces.IStack;

/**
 * Created by Who on 2014/4/19.
 */
public class ResizingArrayStack implements IStack {

    private String[] items = new String[1];
    private int N = 0;

    @Override
    public String pop() {
        if (isEmpty()) {
            return "Pop failed. Resizing array stack is empty now.";
        }
        String item = items[--N];
        if (N != 0 && N <= items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    @Override
    public void push(String item) {
        items[N++] = item;
        if (N == items.length) {
            resize(2 * N);
        }
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public String getStackItems() {
        if (isEmpty()) {
            return "Get stack items failed. Resizing array stack is empty now.";
        }
        String string = "";
        for (int i = N - 1; i >= 0; i--) {
            string += items[i];
        }
        return string;
    }

    private void resize(int size) {
        String[] newItems = new String[size];
        if (newItems.length >= items.length) {
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
        } else {
            for (int i = 0; i < newItems.length; i++) {
                newItems[i] = items[i];
            }
        }
        items = newItems;
    }
}

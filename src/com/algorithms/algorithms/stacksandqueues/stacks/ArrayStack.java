package com.algorithms.algorithms.stacksandqueues.stacks;

import com.algorithms.algorithms.stacksandqueues.stacks.interfaces.IStack;

/**
 * Created by Who on 2014/4/19.
 */
public class ArrayStack implements IStack {

    //Only 100 (or any other specific number) space for items. A defect of array implementation of Stack.
    private String[] items = new String[100];
    private int N = 0;

    @Override
    public String pop() {
        if (isEmpty()) {
            return "Pop failed. Array stack is empty now.";
        }
        String item = items[--N];
        items[N] = null;
        return item;
    }

    @Override
    public void push(String item) {
        if (N == items.length) {
            return;
        }
        items[N++] = item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public String getStackItems() {
        if (isEmpty()) {
            return "Get stack items failed. Array stack is empty now.";
        }
        String string = "";
        for (int i = N - 1; i >= 0; i--) {
            if (items[i] != null) {
                string += items[i];
            }
        }
        return string;
    }
}

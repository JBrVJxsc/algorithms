package com.algorithms.algorithms.stacksandqueues.bags;

import com.algorithms.algorithms.stacksandqueues.bags.interfaces.IBag;
import com.algorithms.algorithms.stacksandqueues.stacks.LinkedListStackPlus;

import java.util.Iterator;

/**
 * Created by Who on 2014/4/20.
 */
public class LinkedListBag<T> implements IBag<T> {

    private LinkedListStackPlus<T> linkedListStackPlus = new LinkedListStackPlus<T>();
    private int size = 0;

    @Override
    public void add(T item) {
        linkedListStackPlus.push(item);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return linkedListStackPlus.iterator();
    }
}

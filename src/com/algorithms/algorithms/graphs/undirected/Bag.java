package com.algorithms.algorithms.graphs.undirected;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Who on 2014/8/21.
 */
public class Bag<T> implements Iterable {

    private LinkedList<T> linkedList = new LinkedList<T>();

    public void add(T v) {
        linkedList.addLast(v);
    }

    @Override
    public Iterator iterator() {
        return linkedList.iterator();
    }
}

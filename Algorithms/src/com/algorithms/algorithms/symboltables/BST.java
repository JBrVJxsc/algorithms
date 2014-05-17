package com.algorithms.algorithms.symboltables;

import java.util.Iterator;

/**
 * Created by Who on 2014/5/6.
 */
public class BST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private Node root;

    public void put(Key key, Value value) {

    }

    public Value get(Key key) {
        return null;
    }

    public void delete(Key key) {

    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    private class Node {
        private Key key = null;
        private Value value = null;
        private Node left = null;
        private Node right = null;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}

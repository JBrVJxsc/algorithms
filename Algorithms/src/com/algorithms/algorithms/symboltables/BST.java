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
        Node node = root;
        Value value = null;
        while (node != null) {
            if (node.key.equals(key)) {
                value = node.value;
                break;
            } else {
                if (node.key.compareTo(key) > 0) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
        return value;
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

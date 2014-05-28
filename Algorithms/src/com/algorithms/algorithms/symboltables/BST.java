package com.algorithms.algorithms.symboltables;

import java.util.Iterator;

/**
 * Created by Who on 2014/5/6.
 */
public class BST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private Node root;

    public void put(Key key, Value value) {
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        Node node = root;
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            } else {
                if (node.key.compareTo(key) > 0) {
                    if (node.left == null) {
                        node.left = new Node(key, value);
                        return;
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new Node(key, value);
                        return;
                    }
                    node = node.right;
                }
            }
        }
    }

    public void putCourse(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            node.right = put(node.right, key, value);
        } else if (compareResult < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            } else {
                if (node.key.compareTo(key) > 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        return null;
    }

    public Value getCourse(Key key) {
        Node node = root;
        while (node != null) {
            int compareResult = key.compareTo(node.key);
            if (compareResult < 0) {
                node = node.left;
            } else if (compareResult > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    public Key floor(Key key) {
        Node node = root;
        Node found = null;
        while (node != null) {
            int compareResult = key.compareTo(node.key);
            if (compareResult > 0) {
                found = node;
                node = node.right;
            } else if (compareResult < 0) {
                node = node.left;
            } else {
                return key;
            }
        }
        if (found == null) {
            return null;
        }
        return found.key;
    }

    public Key ceiling(Key key) {
        Node node = root;
        Node found = null;
        while (node != null) {
            int compareResult = key.compareTo(node.key);
            if (compareResult > 0) {
                node = node.right;
            } else if (compareResult < 0) {
                found = node;
                node = node.left;
            } else {
                return key;
            }
        }
        if (found == null) {
            return null;
        }
        return found.key;
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

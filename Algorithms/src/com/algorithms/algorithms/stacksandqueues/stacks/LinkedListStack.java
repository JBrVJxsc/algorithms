package com.algorithms.algorithms.stacksandqueues.stacks;

import com.algorithms.algorithms.stacksandqueues.stacks.interfaces.IStack;

/**
 * Created by Who on 2014/4/19.
 */
public class LinkedListStack implements IStack {

    private Node firstNode = null;

    public void push(String item) {
        Node oldFirstNode = firstNode;
        firstNode = new Node();
        firstNode.setItem(item);
        firstNode.setNext(oldFirstNode);
    }

    public String pop() {
        if (isEmpty()) {
            return "Pop failed. Linked list stack is empty now.";
        }
        String string = firstNode.getItem();
        firstNode = firstNode.getNext();
        return string;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public String getStackItems() {
        if (isEmpty()) {
            return "Get stack items failed. Linked list stack is empty now.";
        }
        return getString(firstNode);
    }

    private String getString(Node node) {
        String string = "";
        if (node == null) {
            return string;
        }
        string = node.getItem();
        if (node.getNext() != null) {
            string += getString(node.getNext());
        }
        return string;
    }

    private class Node {
        String item = null;
        Node next = null;

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

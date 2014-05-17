package com.algorithms.algorithms.stacksandqueues.programmingassignments;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by Who on 2014/4/22.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private int bottom = 0;
    private Item[] items = (Item[]) new Object[1];
    private int size = 0;
    private Random random = new Random();

    public RandomizedQueue() {

    }

    public static void main(String[] args) {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        items[bottom++] = item;
        size++;
        if (bottom >= items.length) {
            resize();
        }
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = getRandomDequeueIndex();
        Item item = items[index];
        items[index] = null;
        size--;
        int size = size();
        if (size != 0 && size <= items.length / 4) {
            resize();
        }
        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = getRandomDequeueIndex();
        Item item = items[index];
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        RandomizedQueueIterator randomizedQueueIterator = new RandomizedQueueIterator(getItems());
        return randomizedQueueIterator;
    }

    private void resize() {
        int size = size();
        int newSize = size * 2;
        Item[] newItems = (Item[]) new Object[newSize];
        int index = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                newItems[index] = items[i];
                index++;
            }
        }
        bottom = size;
        items = newItems;
    }

    private Item[] getItems() {
        Item[] newItems = (Item[]) new Object[size];
        int index = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                newItems[index] = items[i];
                index++;
            }
        }
        //Knuth Shuffling.
        for (int i = 0; i < newItems.length; i++) {
            index = random.nextInt(i + 1);
            swap(newItems, i, index);
        }
        return newItems;
    }

    private void swap(Item[] items, int i, int j) {
        Item item = items[i];
        items[i] = items[j];
        items[j] = item;
    }

    private int getRandomDequeueIndex() {
        int index = random.nextInt(items.length);
        while (items[index] == null) {
            index = random.nextInt(items.length);
        }
        return index;
    }

    private class RandomizedQueueIterator<Item> implements Iterator<Item> {
        private Item[] items = null;
        private int pointer = 0;

        public RandomizedQueueIterator(Item[] items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            return pointer != items.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[pointer++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

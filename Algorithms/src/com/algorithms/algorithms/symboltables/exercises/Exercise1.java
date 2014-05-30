package com.algorithms.algorithms.symboltables.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.symboltables.BST;
import com.algorithms.base.Parameter;
import com.algorithms.common.Random;
import com.algorithms.interfaces.IAlgorithm;

import java.util.Iterator;

/**
 * Created by Who on 2014/5/27.
 */
public class Exercise1 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1401201709912l;
    }

    @Override
    public String getName() {
        return "Exercise1 for BST";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
//        testPutGet();
//        testFloor();
//        testCeiling();
//        testCount();
//        testRank();
//        testMin();
//        testMax();
//        testDeleteMin();
//        testDeleteMax();
//        testDelete();
        testIterator();
    }

    private void testIterator() {
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        for (int i = 0; i < 5; i++) {
            int key = Random.getInt(100);
            if (bstOne.get(key) != null) {
                continue;
            }
            bstOne.put(key, key);
            print("Put: " + key);
        }
        print();
        print("PRE_ORDER:");
        Iterable<Integer> iterable = bstOne.iterator(BST.OrderType.PRE_ORDER);
        Iterator<Integer> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            print(iterator.next());
        }
        print();
        print("IN_ORDER:");
        iterable = bstOne.iterator(BST.OrderType.IN_ORDER);
        iterator = iterable.iterator();
        while (iterator.hasNext()) {
            print(iterator.next());
        }
        print();
        print("POST_ORDER:");
        iterable = bstOne.iterator(BST.OrderType.POST_ORDER);
        iterator = iterable.iterator();
        while (iterator.hasNext()) {
            print(iterator.next());
        }
    }

    private void testDelete() {
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int key = Random.getInt(100);
            if (bstOne.get(key) != null) {
                continue;
            }
            bstOne.put(key, key);
            print("Put: " + key);
            count++;
        }
        Parameter<Integer> key = new Parameter<Integer>(0, "Key");
        for (int i = 0; i < count; i++) {
            set(key);
            bstOne.delete(key.getValue());
            print(bstOne.max());
        }
    }

    private void testDeleteMax() {
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int key = Random.getInt(100);
            if (bstOne.get(key) != null) {
                continue;
            }
            bstOne.put(key, key);
            print("Put: " + key);
            count++;
        }
        for (int i = 0; i < count; i++) {
            print(bstOne.max());
            bstOne.deleteMax();
        }
    }

    private void testDeleteMin() {
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int key = Random.getInt(100);
            if (bstOne.get(key) != null) {
                continue;
            }
            bstOne.put(key, key);
            print("Put: " + key);
            count++;
        }
        for (int i = 0; i < count; i++) {
            print(bstOne.min());
            bstOne.deleteMin();
        }
    }

    private void testMax() {
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            int key = Random.getInt(100);
            bstOne.put(key, key);
            print("Put: " + key);
        }
        print(bstOne.max());
    }

    private void testMin() {
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            int key = Random.getInt(100);
            bstOne.put(key, key);
            print("Put: " + key);
        }
        print(bstOne.min());
    }

    private void testPutGet() {
        Parameter<Integer> bound = new Parameter<Integer>(200, "Bound");
        set(bound);
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        BST<Integer, Integer> bstTwo = new BST<Integer, Integer>();
        for (int i = 0; i < 100; i++) {
            int key = Random.getInt(bound.getValue());
            bstOne.put(key, key);
            bstOne.put(key, key);
            bstTwo.put(key, key);
            bstTwo.put(key, key);
            print("BST-ONE:" + bstOne.get(key));
            print("BST-TWO:" + bstTwo.get(key));
            print();
        }
    }

    private void testCount() {
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        BST<Integer, Integer> bstTwo = new BST<Integer, Integer>();
        for (int i = 0; i < 100; i++) {
            int key = Random.getInt(10090);
            bstOne.put(key, key);
            bstTwo.put(key, key);
            print("BST-ONE Size:" + bstOne.size());
            print("BST-TWO Size:" + bstTwo.size());
            print();
        }
    }

    private void testFloor() {
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        for (int i = 0; i < 100; i++) {
            int key = Random.getInt(100);
            bstOne.put(key, key);
            print("Put: " + key);
            print("Floor: " + bstOne.floor(key - 1));
            print();
        }
    }

    private void testCeiling() {
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        for (int i = 0; i < 100; i++) {
            int key = Random.getInt(100);
            bstOne.put(key, key);
            print("Put: " + key);
            print("Ceiling: " + bstOne.ceiling(key + 1));
            print();
        }
    }

    private void testRank() {
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        for (int i = 0; i < 100; i++) {
            int key = Random.getInt(100);
            bstOne.put(key, key);
            print("Put: " + key);
            print("Rank: " + bstOne.rank(key + 1));
            print();
        }
        print();
        print("Size: " + bstOne.size());
        print();
        print("RankAll: " + bstOne.rank(10000));
    }
}

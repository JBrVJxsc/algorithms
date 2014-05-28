package com.algorithms.algorithms.symboltables.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.symboltables.BST;
import com.algorithms.base.Parameter;
import com.algorithms.common.Random;
import com.algorithms.interfaces.IAlgorithm;

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
        testFloor();
        print();
        print("--------------------------------------");
        print();
        testCeiling();
    }

    private void test1() {
        Parameter<Integer> bound = new Parameter<Integer>(200, "Bound");
        set(bound);
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        BST<Integer, Integer> bstTwo = new BST<Integer, Integer>();
        for (int i = 0; i < 100; i++) {
            int key = Random.getInt(bound.getValue());
            bstOne.put(key, key);
            bstOne.put(key, key);
            bstTwo.putCourse(key, key);
            bstTwo.putCourse(key, key);
            print("BST-ONE:" + bstOne.get(key));
            print("BST-TWO:" + bstTwo.getCourse(key));
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
}

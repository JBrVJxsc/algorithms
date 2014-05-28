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
        Parameter<Integer> number = new Parameter<Integer>(200, "Number");
        set(number);
        BST<Integer, Integer> bstOne = new BST<Integer, Integer>();
        BST<Integer, Integer> bstTwo = new BST<Integer, Integer>();
        for (int i = 0; i < 100; i++) {
            int key = Random.getInt(number.getValue());
            bstOne.putOne(key, key);
            bstOne.putOne(key, key);
            bstTwo.putTwo(key, key);
            bstTwo.putTwo(key, key);
            print("BST-ONE:" + bstOne.get(key));
            print("BST-TWO:" + bstTwo.getTwo(key));
            print();
        }
    }
}

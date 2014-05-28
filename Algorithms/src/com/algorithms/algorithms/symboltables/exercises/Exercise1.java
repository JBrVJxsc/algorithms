package com.algorithms.algorithms.symboltables.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.symboltables.BST;
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
        BST<Integer, String> bstOne = new BST<Integer, String>();
        BST<Integer, String> bstTwo = new BST<Integer, String>();

        Random.getInt(100);
    }
}

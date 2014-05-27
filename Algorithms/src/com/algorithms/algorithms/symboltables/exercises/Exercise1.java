package com.algorithms.algorithms.symboltables.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.symboltables.BST;
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
        BST<Integer, String> bst = new BST<Integer, String>();
        bst.put(0, "A");
        bst.put(1, "B");
        bst.put(2, "C");
        bst.put(3, "D");
        bst.put(4, "E");
        bst.put(5, "F");
        bst.put(6, "G");
        print(bst.get(6));
        print(bst.get(5));
        print(bst.get(4));
        print(bst.get(3));
        print(bst.get(2));
        print(bst.get(1));
        print(bst.get(0));
    }
}

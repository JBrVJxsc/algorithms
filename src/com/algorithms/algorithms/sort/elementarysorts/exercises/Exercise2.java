package com.algorithms.algorithms.sort.elementarysorts.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.sort.elementarysorts.InsertionSort;
import com.algorithms.algorithms.sort.interfaces.ISort;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/21.
 */
public class Exercise2 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398063588285l;
    }

    @Override
    public String getName() {
        return "Exercise #2 for Insertion Sort";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        print("Test1:");
        test1();
        print("Test2:");
        test2();
        print("Test3:");
        test3();
    }

    private void test1() {
        ISort iSort = new InsertionSort();
        Comparable[] comparables = new Comparable[5];
        for (int i = 0; i < comparables.length; i++) {
            comparables[i] = comparables.length - i;
        }
        print("Comparable items:");
        for (int i = 0; i < comparables.length; i++) {
            print(comparables[i].toString());
        }
        print("Sorting:");
        iSort.sort(comparables);
        for (int i = 0; i < comparables.length; i++) {
            print(comparables[i].toString());
        }
    }

    private void test2() {
        ISort iSort = new InsertionSort();
        Comparable[] comparables = new Comparable[20];
        for (int i = 0; i < comparables.length; i++) {
            comparables[i] = comparables.length - i;
        }
        comparables[12] = 12 * 2;
        comparables[13] = 13 * 2;
        comparables[14] = 14 * 2;
        print("Comparable items:");
        for (int i = 0; i < comparables.length; i++) {
            print(comparables[i].toString());
        }
        print("Sorting:");
        iSort.sort(comparables);
        for (int i = 0; i < comparables.length; i++) {
            print(comparables[i].toString());
        }
    }

    private void test3() {
        ISort iSort = new InsertionSort();
        Comparable[] comparables = new Comparable[10];
        for (int i = 0; i < comparables.length; i++) {
            comparables[i] = comparables.length - i;
        }
        comparables[2] = 4;
        comparables[3] = 4;
        comparables[4] = 4;
        print("Comparable items:");
        for (int i = 0; i < comparables.length; i++) {
            print(comparables[i].toString());
        }
        print("Sorting:");
        iSort.sort(comparables);
        for (int i = 0; i < comparables.length; i++) {
            print(comparables[i].toString());
        }
    }
}

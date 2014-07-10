package com.algorithms.algorithms.sort.quicksorts.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.sort.BaseSort;
import com.algorithms.algorithms.sort.mergesorts.Mergesort;
import com.algorithms.algorithms.sort.quicksorts.Partitioning3way;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/28.
 */
public class Exercise4 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398692166236l;
    }

    @Override
    public String getName() {
        return "Exercise #4 for Partitioning3way";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        Comparable[] comparables = new Comparable[]{1, 2, 3, 3, 2, 1, 1, 2, 3, 3, 2, 1};
        comparables = BaseSort.getRandomComparables(25);
        print("Before:");
        print(comparables);
        Mergesort mergesort = new Mergesort();
        Comparable[] tempt = comparables.clone();
        mergesort.sort(tempt);
        Partitioning3way partitioning3way = new Partitioning3way();
        int[] ints = partitioning3way.partition(comparables, 0, comparables.length - 1);
        print("After:");
        print(comparables);
        print(ints);
        if (comparables[ints[0]] == comparables[ints[1]]) {
            show("");
        }
        mergesort.sort(comparables);
        if (!print(tempt).equals(print(comparables))) {
            show("Wrong!");
        }
    }
}

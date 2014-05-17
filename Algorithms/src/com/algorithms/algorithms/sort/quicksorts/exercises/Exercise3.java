package com.algorithms.algorithms.sort.quicksorts.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.sort.BaseSort;
import com.algorithms.algorithms.sort.quicksorts.Quickselect;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/28.
 */
public class Exercise3 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398678561845l;
    }

    @Override
    public String getName() {
        return "Exercise #3 for Quickselect";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        Quickselect quickselect = new Quickselect();
        Comparable[] comparables = BaseSort.getRandomComparables(20);
        print(comparables);
        print(quickselect.select(comparables, comparables.length / 2));
        print(comparables);
    }
}

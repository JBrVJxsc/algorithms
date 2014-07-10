package com.algorithms.algorithms.sort.quicksorts.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.sort.BaseSort;
import com.algorithms.algorithms.sort.interfaces.ISort;
import com.algorithms.algorithms.sort.quicksorts.Quicksort;
import com.algorithms.base.Parameter;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/27.
 */
public class Exercise2 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398591696192l;
    }

    @Override
    public String getName() {
        return "Exercise #2 for Quicksort";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        Parameter<Integer> size = new Parameter<Integer>(12, "Size of array");
        set(size);
        Comparable[] comparables = BaseSort.getRandomComparables(size.getValue());
        print("Quicksort:");
        testQuicksort(comparables.clone());
    }

    private void testQuicksort(Comparable[] comparables) {
        String string = "";
        for (int i = 0; i < 10; i++) {
            string += " " + comparables[i];
        }
        print("Before sorting: " + string);
        ISort iSort = new Quicksort();
        timerOn();
        iSort.sort(comparables);
        print("Sorting time: " + String.valueOf(timerOff()) + " ms.");
        string = "";
        for (int i = 0; i < 10; i++) {
            string += " " + comparables[i];
        }
        print("After sorting: " + string);
        print("Loop times: " + iSort.getLoopTimes());
    }
}

package com.algorithms.algorithms.sort.elementarysorts.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.sort.BaseSort;
import com.algorithms.algorithms.sort.elementarysorts.InsertionSort;
import com.algorithms.algorithms.sort.elementarysorts.SelectionSort;
import com.algorithms.algorithms.sort.elementarysorts.Shellsort;
import com.algorithms.algorithms.sort.heapsorts.Heapsort;
import com.algorithms.algorithms.sort.interfaces.ISort;
import com.algorithms.algorithms.sort.mergesorts.BottomUpMergesort;
import com.algorithms.algorithms.sort.mergesorts.Mergesort;
import com.algorithms.algorithms.sort.quicksorts.Quicksort;
import com.algorithms.algorithms.sort.quicksorts.Quicksort3way;
import com.algorithms.common.Parameter;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/21.
 */
public class Exercise4 extends BaseAlgorithm implements IAlgorithm {

    private Comparable[] comparables = null;

    @Override
    public long getID() {
        return 1398748562381l;
    }

    @Override
    public String getName() {
        return "Comparison between ISorts";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        Parameter<Integer> size = new Parameter<Integer>(5, "Size of array");
        set(size);
        comparables = BaseSort.getRandomComparables(size.getValue());
        //Test. If there are lots of duplicate keys, the running time will be less.
        if (false) {
            int multiple = 100;
            comparables = BaseSort.getRandomComparables(size.getValue() * multiple);
            for (int i = 0; i < comparables.length; i += multiple) {
                for (int j = 0; j < multiple; j++) {
                    comparables[i + j] = i;
                }
            }
        }
        testSort(new Heapsort());
        testSort(new Quicksort());
        testSort(new Quicksort3way());
        testSort(new BottomUpMergesort());
        testSort(new Mergesort());
        testSort(new Shellsort());
        if (false) {
            testSort(new InsertionSort());
            testSort(new SelectionSort());
        }
    }

    private void testSort(ISort iSort) {
        Comparable[] tempt = comparables.clone();
        String string = "";
        int length = tempt.length;
        if (length > 10) {
            length = 10;
        }
        for (int i = 0; i < length; i++) {
            string += " " + tempt[i];
        }
        print(iSort.getClass().getSimpleName() + ":");
        print("Before sorting: " + string);
        timerOn();
        iSort.sort(tempt);
        print("Sorting time: " + String.valueOf(timerOff()) + " ms.");
        string = "";
        for (int i = 0; i < length; i++) {
            string += " " + tempt[i];
        }
        print("After sorting: " + string);
        print("Loop times: " + iSort.getLoopTimes());
        print();
    }
}

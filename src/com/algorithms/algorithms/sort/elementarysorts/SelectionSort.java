package com.algorithms.algorithms.sort.elementarysorts;

import com.algorithms.algorithms.sort.BaseSort;

/**
 * Created by Who on 2014/4/21.
 */
public class SelectionSort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
                loopTimes++;
            }
            exch(a, i, minIndex);
        }
    }
}

package com.algorithms.algorithms.sort.elementarysorts;

import com.algorithms.algorithms.sort.BaseSort;

/**
 * Created by Who on 2014/4/21.
 */
public class InsertionSort extends BaseSort {
    @Override
    public void sort(Comparable[] a) {
        sortOne(a);
    }

    //First method to sort.
    private void sortOne(Comparable[] a) {
        //i begins from 1 is ok, because when i is 0, j-loop does not work at all.
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j - 1, j);
                } else {
                    break;
                }
                loopTimes++;
            }
        }
    }

    //Second method to sort.
    private void sortTwo(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int last = i;
            int next = i + 1;
            while (less(a[next], a[last])) {
                exch(a, last--, next--);
                if (last == -1) {
                    break;
                }
                loopTimes++;
            }
        }
    }
}

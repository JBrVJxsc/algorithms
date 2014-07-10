package com.algorithms.algorithms.sort.mergesorts;

import com.algorithms.algorithms.sort.BaseSort;

/**
 * Created by Who on 2014/4/24.
 */
public class Merging {
    private Comparable[] aux = null;
    private int lo = 0;
    private int mid = 0;
    private int hi = 0;

    public void sort(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        //Actually, aux can be the clone of the a, but this is not pure algorithm.
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        //My method.
        if (false) {
            int aLow = lo;
            int bLow = mid + 1;
            int aHigh = mid;
            int bHigh = hi;
            int index = lo;
            while (aLow <= aHigh && bLow <= bHigh) {
                if (BaseSort.less(aux[aLow], aux[bLow])) {
                    a[index++] = aux[aLow++];
                } else {
                    a[index++] = aux[bLow++];
                }
            }
            //There must be some remaining elements in the part one or part two, put the rest of them into the tempt[].
            if (aLow > aHigh) {
                for (int i = bLow; i <= bHigh; i++) {
                    a[index++] = aux[i];
                }
            } else if (bLow > bHigh) {
                for (int i = aLow; i <= aHigh; i++) {
                    a[index++] = aux[i];
                }
            }
        }
        //The course' s method.
        else {
            int i = lo;
            int j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                } else if (j > hi) {
                    a[k] = aux[i++];
                } else if (BaseSort.less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                } else {
                    a[k] = aux[i++];
                }
            }
        }
    }
}

package com.algorithms.algorithms.sort.quicksorts;

import com.algorithms.algorithms.sort.BaseSort;

/**
 * Created by Who on 2014/4/28.
 */
public class Partitioning3way {
    public int[] partition(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return null;
        }
        Comparable v = a[lo];
        int lt = lo;
        int gt = hi;
        int i = lo + 1;
        //My method.
        if (false) {
            while (true) {
                if (BaseSort.less(a[i], v)) {
                    BaseSort.exch(a, i++, lt++);
                } else if (BaseSort.less(v, a[i])) {
                    BaseSort.exch(a, i, gt--);
                } else {
                    i++;
                }
                if (i > gt) {
                    break;
                }
            }
            return new int[]{lt, gt};
        }
        //Course's method.
        else {
            while (i <= gt) {
                int cmp = a[i].compareTo(v);
                if (cmp < 0) {
                    BaseSort.exch(a, i++, lt++);
                } else if (cmp > 0) {
                    BaseSort.exch(a, i, gt--);
                } else {
                    i++;
                }
            }
            return new int[]{lt, gt};
        }
    }
}

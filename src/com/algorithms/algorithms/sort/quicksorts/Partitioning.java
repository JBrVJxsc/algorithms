package com.algorithms.algorithms.sort.quicksorts;

import com.algorithms.algorithms.sort.BaseSort;

import java.util.Comparator;

/**
 * Created by Who on 2014/4/27.
 */
public class Partitioning {
    public int partition(Comparable[] a, int lo, int hi) {
        //My method.
        if (false) {
            int i = lo;
            int j = hi + 1;
            while (j > i) {
                i++;
                j--;
                while (i < hi && BaseSort.less(a[i], a[lo])) {
                    i++;
                }
                while (j > lo && BaseSort.less(a[lo], a[j])) {
                    j--;
                }
                if (i >= j) {
                    break;
                }
                BaseSort.exch(a, i, j);
            }
            BaseSort.exch(a, lo, j);
            return j;
        }
        //Course's method.
        else {
            int i = lo;
            int j = hi + 1;
            while (true) {
                while (BaseSort.less(a[++i], a[lo])) {
                    if (i == hi) {
                        break;
                    }
                }
                while (BaseSort.less(a[lo], a[--j])) {
                    if (j == lo) {
                        break;
                    }
                }
                if (i >= j) {
                    break;
                }
                BaseSort.exch(a, i, j);
            }
            BaseSort.exch(a, lo, j);
            return j;
        }
    }

    public int partition(Comparable[] a, int lo, int hi, Comparator comparator) {
        //My method.
        if (false) {
            int i = lo;
            int j = hi + 1;
            while (j > i) {
                i++;
                j--;
                while (i < hi && BaseSort.less(a[i], a[lo], comparator)) {
                    i++;
                }
                while (j > lo && BaseSort.less(a[lo], a[j], comparator)) {
                    j--;
                }
                if (i >= j) {
                    break;
                }
                BaseSort.exch(a, i, j);
            }
            BaseSort.exch(a, lo, j);
            return j;
        }
        //Course's method.
        else {
            int i = lo;
            int j = hi + 1;
            while (true) {
                while (BaseSort.less(a[++i], a[lo], comparator)) {
                    if (i == hi) {
                        break;
                    }
                }
                while (BaseSort.less(a[lo], a[--j], comparator)) {
                    if (j == lo) {
                        break;
                    }
                }
                if (i >= j) {
                    break;
                }
                BaseSort.exch(a, i, j);
            }
            BaseSort.exch(a, lo, j);
            return j;
        }
    }
}

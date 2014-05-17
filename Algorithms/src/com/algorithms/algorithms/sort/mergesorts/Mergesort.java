package com.algorithms.algorithms.sort.mergesorts;

import com.algorithms.algorithms.sort.BaseSort;

/**
 * Created by Who on 2014/4/24.
 */
public class Mergesort extends BaseSort {

    private Merging merging = new Merging();

    @Override
    public void sort(Comparable[] a) {
        sort(a, new Comparable[a.length], 0, a.length - 1);
    }

    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        //Improvement #1. If already sorted, return.
        if (less(a[mid], a[mid + 1])) {
            return;
        }
        merge(a, aux, lo, mid, hi);
        loopTimes++;
    }

    protected void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        merging.sort(a, aux, lo, mid, hi);
    }
}

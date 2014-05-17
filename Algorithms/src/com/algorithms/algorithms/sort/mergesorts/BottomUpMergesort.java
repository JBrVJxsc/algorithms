package com.algorithms.algorithms.sort.mergesorts;

/**
 * Created by Who on 2014/4/25.
 */
public class BottomUpMergesort extends Mergesort {
    @Override
    public void sort(Comparable[] a) {
        int size = 1;
        int length = a.length;
        Comparable[] aux = new Comparable[length];
        while (size < length) {
            for (int lo = 0; lo < length - size; lo += size * 2) {
                //Improvement #1. If already sorted, return.
                if (less(a[lo + size - 1], a[lo + size])) {
                    continue;
                }
                merge(a, aux, lo, lo + size - 1, Math.min(lo + size * 2 - 1, length - 1));
                loopTimes++;
            }
            size *= 2;
        }
    }
}

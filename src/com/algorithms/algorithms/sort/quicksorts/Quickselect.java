package com.algorithms.algorithms.sort.quicksorts;

import com.algorithms.algorithms.sort.elementarysorts.shuffling.KnuthShuffle;

/**
 * Created by Who on 2014/4/28.
 */
public class Quickselect {
    public Comparable select(Comparable[] a, int k) {
        KnuthShuffle knuthShuffle = new KnuthShuffle();
        knuthShuffle.shuffle(a);
        Partitioning partitioning = new Partitioning();
        int lo = 0;
        int hi = a.length - 1;
        while (hi > lo) {
            int j = partitioning.partition(a, lo, hi);
            if (j > k) {
                hi = k;
            } else if (j < k) {
                lo = j + 1;
            } else {
                return a[k];
            }
        }
        return a[k];
    }
}

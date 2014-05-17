package com.algorithms.algorithms.sort.quicksorts;

import com.algorithms.algorithms.sort.BaseSort;
import com.algorithms.algorithms.sort.elementarysorts.shuffling.KnuthShuffle;

/**
 * Created by Who on 2014/4/28.
 */
public class Quicksort3way extends BaseSort {

    private Partitioning3way partitioning3way = new Partitioning3way();
    private KnuthShuffle knuthShuffle = new KnuthShuffle();

    @Override
    public void sort(Comparable[] a) {
        knuthShuffle.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int[] ints = partitioning3way.partition(a, lo, hi);
        sort(a, lo, ints[0] - 1);
        sort(a, ints[1] + 1, hi);
        loopTimes++;
    }
}

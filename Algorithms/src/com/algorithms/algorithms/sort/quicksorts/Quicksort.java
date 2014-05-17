package com.algorithms.algorithms.sort.quicksorts;

import com.algorithms.algorithms.sort.BaseSort;
import com.algorithms.algorithms.sort.elementarysorts.shuffling.KnuthShuffle;

import java.util.Comparator;

/**
 * Created by Who on 2014/4/27.
 */
public class Quicksort extends BaseSort {

    Partitioning partitioning = new Partitioning();

    @Override
    public void sort(Comparable[] a) {
        KnuthShuffle knuthShuffle = new KnuthShuffle();
        knuthShuffle.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, Comparator comparator) {
        KnuthShuffle knuthShuffle = new KnuthShuffle();
        knuthShuffle.shuffle(a);
        sort(a, 0, a.length - 1, comparator);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partitioning.partition(a, lo, hi);
        sort(a, lo, index - 1);
        sort(a, index + 1, hi);
        loopTimes++;
    }

    private void sort(Comparable[] a, int lo, int hi, Comparator comparator) {
        if (lo >= hi) {
            return;
        }
        int index = partitioning.partition(a, lo, hi, comparator);
        sort(a, lo, index - 1, comparator);
        sort(a, index + 1, hi, comparator);
        loopTimes++;
    }
}

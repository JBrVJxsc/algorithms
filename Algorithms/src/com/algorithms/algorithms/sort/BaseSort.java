package com.algorithms.algorithms.sort;

import com.algorithms.algorithms.sort.interfaces.ISort;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by Who on 2014/4/21.
 */
public abstract class BaseSort implements ISort {

    protected long loopTimes = 0;

    public static Comparable[] getRandomComparables(int size) {
        Comparable[] comparables = new Comparable[size];
        Random random = new Random();
        for (int i = 0; i < comparables.length; i++) {
            comparables[i] = random.nextInt(size * 2);
        }
        return comparables;
    }

    public static void printComparables(Comparable[] comparables) {
        String string = "";
        for (int i = 0; i < comparables.length; i++) {
            string += comparables[i].toString() + " ";
        }
        System.out.print("\n" + string);
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean less(Comparable v, Comparable w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable tempt = a[i];
        a[i] = a[j];
        a[j] = tempt;
    }

    public long getLoopTimes() {
        long times = loopTimes;
        loopTimes = 0;
        return times;
    }
}

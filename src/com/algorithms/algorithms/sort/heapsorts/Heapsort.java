package com.algorithms.algorithms.sort.heapsorts;

import com.algorithms.algorithms.sort.BaseSort;

/**
 * Created by Who on 2014/5/1.
 */
public class Heapsort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        build(a);
        int N = a.length;
        //My method.
        if (true) {
            for (int i = N; i > 1; i--) {
                exch(a, 0, i - 1);
                sink(a, 1, i - 1);
            }
        }
        //Course's method.
        else {
            while (N > 1) {
                exch(a, 0, N - 1);
                sink(a, 1, --N);
            }
        }
    }

    private void build(Comparable[] a) {
        int N = a.length / 2;
        int length = a.length;
        for (int i = N; i >= 1; i--) {
            sink(a, i, length);
        }
    }

    private void sink(Comparable[] a, int k, int N) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(a[j - 1], a[j])) {
                j++;
            }
            if (less(a[k - 1], a[j - 1])) {
                exch(a, k - 1, j - 1);
            } else {
                break;
            }
            k = j;
            loopTimes++;
        }
    }
}

package com.algorithms.algorithms.sort.elementarysorts;

import com.algorithms.algorithms.sort.BaseSort;

/**
 * Created by Who on 2014/4/21.
 */
public class Shellsort extends BaseSort {
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            //The code is so much like the Insertion Sort. The difference between both is, change the 1 in to the h.
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (less(a[j], a[j - h])) {
                        exch(a, j - h, j);
                    } else {
                        break;
                    }
                    loopTimes++;
                }
            }
            h /= 3;
        }
    }
}

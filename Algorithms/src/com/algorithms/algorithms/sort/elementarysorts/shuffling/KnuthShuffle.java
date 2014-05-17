package com.algorithms.algorithms.sort.elementarysorts.shuffling;

import java.util.Random;

/**
 * Created by Who on 2014/4/21.
 */
public class KnuthShuffle {

    private Random random = new Random();

    public void shuffle(Object[] objects) {
        int N = objects.length;
        for (int i = 0; i < N; i++) {
            //It works much better than random.nextInt(N). I do not know why, but it is.
            int r = random.nextInt(i + 1);
            swap(objects, i, r);
        }
    }

    private void swap(Object[] objects, int i, int j) {
        Object tempt = objects[i];
        objects[i] = objects[j];
        objects[j] = tempt;
    }
}

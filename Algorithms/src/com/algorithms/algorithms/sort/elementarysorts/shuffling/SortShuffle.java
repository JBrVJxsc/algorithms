package com.algorithms.algorithms.sort.elementarysorts.shuffling;

import com.algorithms.algorithms.sort.elementarysorts.Shellsort;
import com.algorithms.algorithms.sort.elementarysorts.shuffling.interfaces.IShuffle;
import com.algorithms.algorithms.sort.elementarysorts.shuffling.interfaces.IShuffleable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Who on 2014/4/21.
 */
public class SortShuffle implements IShuffle {

    private ArrayList<Long> indexList = null;
    private Random random = null;
    private Shellsort shellSort = new Shellsort();

    @Override
    public void shuffle(IShuffleable[] shuffleables) {
        indexList = new ArrayList<Long>();
        random = new Random();
        for (int i = 0; i < shuffleables.length; i++) {
            long index = random.nextLong();
            //Loop until get an unique index.
            while (indexList.contains(index)) {
                index = random.nextLong();
            }
            shuffleables[i].setIndex(index);
            indexList.add(index);
        }
        shellSort.sort(shuffleables);
    }
}

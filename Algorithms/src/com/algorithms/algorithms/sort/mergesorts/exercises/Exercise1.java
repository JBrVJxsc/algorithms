package com.algorithms.algorithms.sort.mergesorts.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.sort.elementarysorts.InsertionSort;
import com.algorithms.algorithms.sort.elementarysorts.SelectionSort;
import com.algorithms.algorithms.sort.elementarysorts.Shellsort;
import com.algorithms.algorithms.sort.interfaces.ISort;
import com.algorithms.algorithms.sort.mergesorts.BottomUpMergesort;
import com.algorithms.algorithms.sort.mergesorts.Mergesort;
import com.algorithms.interfaces.IAlgorithm;

import java.util.Random;

/**
 * Created by Who on 2014/4/24.
 */
public class Exercise1 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398328206546l;
    }

    @Override
    public String getName() {
        return "Exercise #1 for Merge Sort";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        test();
    }

    private void test() {
        ISort iSort = null;
        Comparable[] tempt = null;
        Random random = new Random();
        Comparable[] firstPart = new Comparable[10];
        for (int i = 0; i < firstPart.length; i++) {
            firstPart[i] = random.nextInt(100);
        }
        print("First Part: ");
        print(firstPart);
        Comparable[] secondPart = new Comparable[11];
        for (int i = 0; i < secondPart.length; i++) {
            secondPart[i] = random.nextInt(100);
        }
        print("Second Part: ");
        print(secondPart);
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(firstPart);
        print("First Part Sorted: ");
        print(firstPart);
        insertionSort.sort(secondPart);
        print("Second Part Sorted: ");
        print(secondPart);
        Comparable[] allPart = new Comparable[firstPart.length + secondPart.length];
        int index = 0;
        for (int i = 0; i < firstPart.length; i++) {
            allPart[index++] = firstPart[i];
        }
        for (int i = 0; i < secondPart.length; i++) {
            allPart[index++] = secondPart[i];
        }
        print("All Part: ");
        print(allPart);

//        allPart = new Comparable[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        allPart = new Comparable[]{83, 58, 64, 46, 27, 33, 52, 96, 61, 70, 20, 68};

        iSort = new BottomUpMergesort();
        tempt = allPart.clone();
        iSort.sort(tempt);
        print("All Part: Sorted by BottomUpMergesort:");
        String s7 = print(tempt);

        iSort = new Mergesort();
        tempt = allPart.clone();
        iSort.sort(tempt);
        print("All Part: Sorted by Mergesort:");
        String s2 = print(tempt);

        iSort = new Shellsort();
        tempt = allPart.clone();
        iSort.sort(tempt);
        print("All Part: Sorted by ShellSort:");
        String s3 = print(tempt);

        iSort = new SelectionSort();
        tempt = allPart.clone();
        iSort.sort(tempt);
        print("All Part: Sorted by SelectionSort:");
        String s4 = print(tempt);

        iSort = new InsertionSort();
        tempt = allPart.clone();
        iSort.sort(tempt);
        print("All Part: Sorted by InsertionSort:");
        String s5 = print(tempt);
    }
}

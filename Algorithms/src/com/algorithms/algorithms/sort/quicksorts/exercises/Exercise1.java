package com.algorithms.algorithms.sort.quicksorts.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.sort.BaseSort;
import com.algorithms.algorithms.sort.quicksorts.Partitioning;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/27.
 */
public class Exercise1 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398566885367l;
    }

    @Override
    public String getName() {
        return "Exercise #1 for Partitioning";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        Partitioning partitioning = new Partitioning();
        Comparable[] comparables = BaseSort.getRandomComparables(100);
        comparables = new Comparable[]{"A", "A", "B", "B", "A", "B", "B", "A", "B", "A", "B", "B"};
        print("Before My Method Partition:");
        Comparable[] my = comparables.clone();
        print(my);
        //Using my partition method.
        int index = partitioning.partition(my, 0, comparables.length - 1);
        print("After Partition:");
        String myString = print(my) + print("Partition Index:") + print(index);
        print("\nBefore Course's Method Partition:");
        Comparable[] course = comparables.clone();
        print(course);
        index = partitioning.partition(course, 0, comparables.length - 1);
        print("After Partition:");
        String courseString = print(course) + print("Partition Index:") + print(index);
        if (!myString.equals(courseString)) {
            print("\nMyString and CourseString are different.");
            show("MyString and CourseString are different.", "Help!");
        }
    }
}

package com.algorithms.algorithms.stacksandqueues.bag.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.stacksandqueues.bags.LinkedListBag;
import com.algorithms.interfaces.IAlgorithm;

import java.awt.*;

/**
 * Created by Who on 2014/4/20.
 */
public class Exercise1 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398001426227l;
    }

    @Override
    public String getName() {
        return "Exercise #1 for Bag";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        test1();
        test2();
    }

    private void test1() {
        LinkedListBag<String> linkedListBag = new LinkedListBag<String>();
        print("Iterating:");
        for (String string : linkedListBag) {
            print(string);
        }
        print("New pushes:");
        linkedListBag.add("A");
        linkedListBag.add("B");
        linkedListBag.add("C");
        linkedListBag.add("D");
        linkedListBag.add("E");
        print("Iterating:");
        for (String string : linkedListBag) {
            print(string);
        }
        print("New pushes:");
        linkedListBag.add("1");
        linkedListBag.add("2");
        linkedListBag.add("3");
        linkedListBag.add("4");
        linkedListBag.add("5");
        print("Iterating:");
        for (String string : linkedListBag) {
            print(string);
        }
        print("Iterating:");
        for (String string : linkedListBag) {
            print(string);
        }
    }

    private void test2() {
        LinkedListBag<Point> linkedListBag = new LinkedListBag<Point>();
        print("Iterating:");
        for (Point point : linkedListBag) {
            print(point);
        }
        print("New pushes:");
        for (int i = 0; i < 5; i++) {
            linkedListBag.add(new Point(i, i));
        }
        print("Iterating:");
        for (Point point : linkedListBag) {
            print(point);
        }
        print("New pushes:");
        for (int i = 5; i < 10; i++) {
            linkedListBag.add(new Point(i, i));
        }
        print("Iterating:");
        for (Point point : linkedListBag) {
            print(point);
        }
        print("Iterating:");
        for (Point point : linkedListBag) {
            print(point);
        }
    }
}

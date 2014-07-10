package com.algorithms.algorithms.stacksandqueues.stacks.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.stacksandqueues.stacks.LinkedListStackPlus;
import com.algorithms.interfaces.IAlgorithm;

import java.awt.*;

/**
 * Created by Who on 2014/4/20.
 */
public class Exercise2 extends BaseAlgorithm implements IAlgorithm {

    @Override
    public long getID() {
        return 1397998628445l;
    }

    @Override
    public String getName() {
        return "Exercise #2 for StackPlus";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        print("\nTest1:\n");
        test1();
        print("\nTest2:\n");
        test2();
    }

    private void test1() {
        LinkedListStackPlus<String> linkedListStackPlus = new LinkedListStackPlus<String>();
        print("Iterating:");
        for (String string : linkedListStackPlus) {
            print(string);
        }
        print("New pushes:");
        linkedListStackPlus.push("A");
        linkedListStackPlus.push("B");
        linkedListStackPlus.push("C");
        linkedListStackPlus.push("D");
        linkedListStackPlus.push("E");
        print("Iterating:");
        for (String string : linkedListStackPlus) {
            print(string);
        }
        print("New pushes:");
        linkedListStackPlus.push("1");
        linkedListStackPlus.push("2");
        linkedListStackPlus.push("3");
        linkedListStackPlus.push("4");
        linkedListStackPlus.push("5");
        print("Iterating:");
        for (String string : linkedListStackPlus) {
            print(string);
        }
        for (int i = 0; i < 5; i++) {
            print("Pop:");
            print(linkedListStackPlus.pop());
            print("Iterating:");
            for (String string : linkedListStackPlus) {
                print(string);
            }
        }
        print("Iterating:");
        for (String string : linkedListStackPlus) {
            print(string);
        }
    }

    private void test2() {
        LinkedListStackPlus<Point> linkedListStackPlus = new LinkedListStackPlus<Point>();
        print("Iterating:");
        for (Point point : linkedListStackPlus) {
            print(point.toString());
        }
        print("New pushes:");
        for (int i = 0; i < 5; i++) {
            linkedListStackPlus.push(new Point(i, i));
        }
        print("Iterating:");
        for (Point point : linkedListStackPlus) {
            print(point.toString());
        }
        print("New pushes:");
        for (int i = 5; i < 10; i++) {
            linkedListStackPlus.push(new Point(i, i));
        }
        print("Iterating:");
        for (Point point : linkedListStackPlus) {
            print(point.toString());
        }
        for (int i = 0; i < 5; i++) {
            print("Pop:");
            print(linkedListStackPlus.pop().toString());
            print("Iterating:");
            for (Point point : linkedListStackPlus) {
                print(point.toString());
            }
        }
        print("Iterating:");
        for (Point point : linkedListStackPlus) {
            print(point.toString());
        }
    }
}

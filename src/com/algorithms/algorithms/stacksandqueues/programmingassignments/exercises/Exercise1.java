package com.algorithms.algorithms.stacksandqueues.programmingassignments.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.stacksandqueues.programmingassignments.Deque;
import com.algorithms.interfaces.IAlgorithm;

import java.util.Random;

/**
 * Created by Who on 2014/4/23.
 */
public class Exercise1 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398223168055l;
    }

    @Override
    public String getName() {
        return "Exercise #1 for Deque";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        //test6();
        randomTestOne();
    }

    private void test1() {
        Deque<String> deque = new Deque<String>();
        print("\nTEST1: addFirst-removeFirst");
        deque.addFirst("FIRST");
        print(deque.removeFirst());
        print(deque.isEmpty());
    }

    private void test2() {
        Deque<String> deque = new Deque<String>();
        print("\nTEST2: addFirst-removeLast");
        deque.addFirst("FIRST");
        print(deque.removeLast());
        print(deque.isEmpty());
    }

    private void test3() {
        Deque<String> deque = new Deque<String>();
        print("\nTEST3: addFirst-addLast-removeLast-removeFirst");
        deque.addFirst("FIRST");
        deque.addLast("LAST");
        print(deque.removeLast());
        print(deque.removeFirst());
        print(deque.isEmpty());
    }

    private void test4() {
        Deque<String> deque = new Deque<String>();
        print("\nTEST4: addFirst-addLast-removeLast-removeFirst");
        deque.addFirst("FIRST");
        deque.addLast("LAST");
        print(deque.removeLast());
        print(deque.removeFirst());
        print(deque.isEmpty());
    }

    private void test5() {
        Deque<String> deque = new Deque<String>();
        print("\nTEST5: addFirst-addLast-removeFirst-removeFirst");
        deque.addFirst("FIRST");
        deque.addLast("LAST");
        print(deque.removeFirst());
        print(deque.removeFirst());
        print(deque.isEmpty());
    }

    private void test6() {
        Deque<String> deque = new Deque<String>();
//        deque.addFirst("A");
//        deque.removeFirst();
//        deque.addFirst("B");
//        deque.addFirst("C");
//        deque.removeLast();
//        deque.removeLast();

        deque.addLast("A");
        deque.removeFirst();
        deque.addLast("B");
        deque.addLast("C");
        deque.addFirst("D");
        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
    }

    private void randomTestOne() {
        Deque<String> deque = new Deque<String>();
        Random random = new Random();
        while (true) {
            int order = random.nextInt(4);
            switch (order) {
                case 0: {
                    print("deque.addLast(\"\");");
                    deque.addLast("");
                    break;
                }
                case 1: {
                    print("deque.addFirst(\"\");");
                    deque.addFirst("");
                    break;
                }
                case 2: {
                    if (deque.size() > 0) {
                        print("deque.removeLast();");
                        deque.removeLast();
                    }
                    break;
                }
                case 3: {
                    if (deque.size() > 0) {
                        print("deque.removeFirst();");
                        deque.removeFirst();
                    }
                    break;
                }
            }
        }
    }

    private void randomTestTwo() {
        Deque<String> deque = new Deque<String>();
        Random random = new Random();
        while (true) {
            int order = random.nextInt(4);
            switch (order) {
                case 0: {
                    deque.addLast("");
                    print("AddL. " + "Size: " + deque.size());
                    break;
                }
                case 1: {
                    deque.addFirst("");
                    print("AddF. " + "Size: " + deque.size());
                    break;
                }
                case 2: {
                    if (deque.size() > 0) {
                        print("RemoveL. " + deque.removeLast() + " Size: " + deque.size());
                    }
                    break;
                }
                case 3: {
                    if (deque.size() > 0) {
                        print("RemoveF. " + deque.removeFirst() + " Size: " + deque.size());
                    }
                    break;
                }
            }
        }
    }
}

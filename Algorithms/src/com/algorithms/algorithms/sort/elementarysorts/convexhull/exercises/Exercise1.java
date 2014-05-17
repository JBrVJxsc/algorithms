package com.algorithms.algorithms.sort.elementarysorts.convexhull.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.sort.elementarysorts.convexhull.grahamscan.GrahamScan;
import com.algorithms.common.Parameter;
import com.algorithms.interfaces.IAlgorithm;

import java.util.Stack;

/**
 * Created by Who on 2014/4/22.
 */
public class Exercise1 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398136141075l;
    }

    @Override
    public String getName() {
        return "Exercise #1 for the Graham Scan of Convex Hull";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        testGrahamScan();
    }

    private void testStack() {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            print(stack.get(i));
        }
        print("Pop 4 times:");
        print(stack.pop());
        print(stack.pop());
        print(stack.pop());
        print(stack.pop());
        print("Peek:");
        print(stack.peek());
        print("Get:");
        print(stack.get(stack.size() - 1));
        print("Pop 6 times:");
        print(stack.pop());
        print(stack.pop());
        print(stack.pop());
        print(stack.pop());
        print(stack.pop());
        print(stack.pop());
    }

    private void testGrahamScan() {
        GrahamScan grahamScan = new GrahamScan();
        Parameter<Integer> size = new Parameter<Integer>(200, "Number of points");
        set(size);
        while (grahamScan.demo(size.getValue())) {
        }
    }
}

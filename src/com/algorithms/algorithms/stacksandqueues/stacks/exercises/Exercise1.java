package com.algorithms.algorithms.stacksandqueues.stacks.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.stacksandqueues.stacks.ArrayStack;
import com.algorithms.algorithms.stacksandqueues.stacks.LinkedListStack;
import com.algorithms.algorithms.stacksandqueues.stacks.ResizingArrayStack;
import com.algorithms.algorithms.stacksandqueues.stacks.interfaces.IStack;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/19.
 */
public class Exercise1 extends BaseAlgorithm implements IAlgorithm {

    private IStack stack = null;

    @Override
    public long getID() {
        return 1397870671552l;
    }

    @Override
    public String getName() {
        return "Exercise #1 for Stack";
    }

    @Override
    public String getSummary() {
        return getName();
    }

    @Override
    public void run() {
        stack = new LinkedListStack();
        print("Linked list stack test1:");
        testStack1(stack);
        print("Linked list stack test2:");
        testStack2(stack);
        stack = new ArrayStack();
        print();
        print("Array stack test1:");
        testStack1(stack);
        print("Array stack test2:");
        testStack2(stack);
        stack = new ResizingArrayStack();
        print();
        print("Resizing array stack test1:");
        testStack1(stack);
        print("Resizing array stack test2:");
        testStack2(stack);
    }

    private void testStack1(IStack stack) {
        stack.push("A");
        print(stack.getStackItems());
        stack.push("B");
        print(stack.getStackItems());
        stack.push("C");
        print(stack.getStackItems());
        stack.push("D");
        print(stack.getStackItems());
        stack.push("E");
        print(stack.getStackItems());
        stack.push("1");
        print(stack.getStackItems());
        stack.push("2");
        print(stack.getStackItems());
        stack.push("3");
        print(stack.getStackItems());
        stack.push("4");
        print(stack.getStackItems());
        stack.push("5");
        print(stack.getStackItems());
        print(stack.pop());
        print(stack.getStackItems());
        print(stack.pop());
        print(stack.getStackItems());
        print(stack.pop());
        print(stack.getStackItems());
        print(stack.pop());
        print(stack.getStackItems());
        print(stack.pop());
        print(stack.getStackItems());
        print(stack.pop());
        print(stack.getStackItems());
        print(stack.pop());
        print(stack.getStackItems());
        print(stack.pop());
        print(stack.getStackItems());
        print(stack.pop());
        print(stack.getStackItems());
        print(stack.pop());
        print(stack.getStackItems());
    }

    private void testStack2(IStack stack) {
        stack.push("A");
        print(stack.pop());
        stack.push("B");
        print(stack.pop());
        stack.push("C");
        print(stack.pop());
        stack.push("1");
        stack.push("2");
        stack.push("3");
        print(stack.pop());
        print(stack.pop());
        print(stack.pop());
        print(stack.getStackItems());
    }
}

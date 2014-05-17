package com.algorithms.algorithms.stacksandqueues.programmingassignments.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.stacksandqueues.programmingassignments.RandomizedQueue;
import com.algorithms.interfaces.IAlgorithm;

import java.util.Random;

/**
 * Created by Who on 2014/4/23.
 */
public class Exercise2 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398260103324l;
    }

    @Override
    public String getName() {
        return "Exercise #2 for RandomizedDequeue";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
//        randomTestOne();
        test1();
    }

    private void randomTestOne() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        Random random = new Random();
        while (true) {
            int order = random.nextInt(2);
            switch (order) {
                case 0: {
                    print("randomizedQueue.enqueue(\"\");");
                    randomizedQueue.enqueue("");
                    break;
                }
                case 1: {
                    if (randomizedQueue.size() > 0) {
                        print("randomizedQueue.dequeue(\"\");");
                        print(randomizedQueue.dequeue());
                    }
                    break;
                }
            }
        }
    }

    private void test1() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        randomizedQueue.enqueue("1");
        randomizedQueue.enqueue("2");
        randomizedQueue.enqueue("3");
        randomizedQueue.dequeue();

        for (String string : randomizedQueue) {
            print(string);
        }
    }
}

package com.algorithms.algorithms.stacksandqueues.queues.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.stacksandqueues.queues.ArrayQueue;
import com.algorithms.algorithms.stacksandqueues.queues.LinkedListQueue;
import com.algorithms.algorithms.stacksandqueues.queues.MaxPQ;
import com.algorithms.algorithms.stacksandqueues.queues.ResizingArrayQueue;
import com.algorithms.algorithms.stacksandqueues.queues.interfaces.IQueue;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/19.
 */
public class Exercise1 extends BaseAlgorithm implements IAlgorithm {

    private IQueue queue = null;

    @Override
    public long getID() {
        return 1398859400977l;
    }

    @Override
    public String getName() {
        return "Exercise #1 for Queue";
    }

    @Override
    public String getSummary() {
        return getName();
    }

    @Override
    public void run() {
        queue = new LinkedListQueue();
        testQueue1(queue);
        testQueue2(queue);
        queue = new ArrayQueue();
        testQueue1(queue);
        testQueue2(queue);
        queue = new ResizingArrayQueue();
        testQueue1(queue);
        testQueue2(queue);
        queue = new MaxPQ(100);
        testQueue1(queue);
        testQueue2(queue);
    }

    private void testQueue1(IQueue queue) {
        queue.enqueue("A");
        print(queue.getQueueItems());
        queue.enqueue("B");
        print(queue.getQueueItems());
        queue.enqueue("C");
        print(queue.getQueueItems());
        queue.enqueue("D");
        print(queue.getQueueItems());
        queue.enqueue("E");
        print(queue.getQueueItems());
        queue.enqueue("1");
        print(queue.getQueueItems());
        queue.enqueue("2");
        print(queue.getQueueItems());
        queue.enqueue("3");
        print(queue.getQueueItems());
        queue.enqueue("4");
        print(queue.getQueueItems());
        queue.enqueue("5");
        print(queue.getQueueItems());
        print(queue.dequeue());
        print(queue.getQueueItems());
        print(queue.dequeue());
        print(queue.getQueueItems());
        print(queue.dequeue());
        print(queue.getQueueItems());
        print(queue.dequeue());
        print(queue.getQueueItems());
        print(queue.dequeue());
        print(queue.getQueueItems());
        print(queue.dequeue());
        print(queue.getQueueItems());
        print(queue.dequeue());
        print(queue.getQueueItems());
        print(queue.dequeue());
        print(queue.getQueueItems());
        print(queue.dequeue());
        print(queue.getQueueItems());
        print(queue.dequeue());
        print(queue.getQueueItems());
    }

    private void testQueue2(IQueue queue) {
        queue.enqueue("A");
        print(queue.dequeue());
        queue.enqueue("B");
        print(queue.dequeue());
        queue.enqueue("C");
        print(queue.dequeue());
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        print(queue.dequeue());
        print(queue.dequeue());
        print(queue.dequeue());
        print(queue.getQueueItems());
    }
}

package com.algorithms.algorithms.graphs.undirected.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.graphs.undirected.BFS;
import com.algorithms.algorithms.graphs.undirected.Graph;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/8/24.
 */
public class Exercise2 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1408881060676l;
    }

    @Override
    public String getName() {
        return "Exercise #2 for Undirected  Graph";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(1, 2);
        graph.addEdge(5, 3);
        graph.addEdge(4, 3);

        BFS bfs = new BFS(graph, 0);
        print(bfs.marked);
        print(bfs.edgeTo);
        print(bfs.depth);
    }
}

package com.algorithms.algorithms.graphs.undirected;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Who on 2014/8/24.
 */
public class BFS {
    public boolean[] marked;
    public int[] edgeTo;
    public int[] depth;

    public BFS(Graph graph, int s) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        depth = new int[graph.V()];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(s);
        marked[s] = true;
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            for (Integer i : graph.adj(cur)) {
                if (!marked[i]) {
                    marked[i] = true;
                    queue.add(i);
                    edgeTo[i] = cur;
                    depth[i] = depth[cur] + 1;
                }
            }
        }
    }
}

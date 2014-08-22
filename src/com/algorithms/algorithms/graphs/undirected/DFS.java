package com.algorithms.algorithms.graphs.undirected;

/**
 * Created by Who on 2014/8/22.
 */
public class DFS {
    public boolean[] marked;
    public int[] edgeTo;
    private int start;

    public DFS(Graph graph, int start) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.start = start;
        dfs(graph, start);
    }

    public void dfs(Graph graph, int v) {
        marked[v] = true;
        for (Integer i : graph.adj(v)) {
            if (!marked[i]) {
                dfs(graph, i);
                edgeTo[i] = v;
            }
        }
    }
}

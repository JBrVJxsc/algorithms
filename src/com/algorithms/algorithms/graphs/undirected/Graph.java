package com.algorithms.algorithms.graphs.undirected;

/**
 * Created by Who on 2014/8/20.
 */
public class Graph {
    public Graph(int V) {

    }

    public void addEdge(int v, int w) {

    }

    public Iterable<Integer> adj(int v) {
        return null;
    }

    public int V() {
        return 0;
    }

    public int E() {
        return 0;
    }

    public String toString() {
        return null;
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            max = Math.max(max, degree(G, v));
        }
        return max;
    }

    public static double averageDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        return count / 2;
    }
}

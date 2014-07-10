package com.algorithms.algorithms.unionfind.programmingassignments;

import com.algorithms.algorithms.unionfind.UnionFind;

import java.util.Random;

/**
 * Created by Who on 2014/4/17.
 */
public class Percolation {

    private int[] openStates = null;
    private int numberOfOpenedSites = 0;
    private int N = 0;
    private int n = 0;
    private int topIndex = 0;
    private int bottomIndex = 0;
    private Random random = new Random();
    private UnionFind unionFind = null;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        this.N = N;
        unionFind = new UnionFind();
        n = N * N;
        openStates = new int[n];
        //extra 2 space for the top and the bottom.
        unionFind.init(n + 2);
        topIndex = unionFind.getN().length - 2;
        bottomIndex = unionFind.getN().length - 1;
        for (int i = 0; i < N; i++) {
            //set the root for the top.
            unionFind.union(topIndex, i);
            //set the root for the bottom.
            unionFind.union(bottomIndex, topIndex - 1 - i);
        }
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        if (isOpen(i, j)) {
            return;
        }
        int index = getIndex(i, j);
        openStates[index] = 1;
        drawOpenStates();
        Site[] neighbors = getNeighbors(i, j);
        Site site = null;
        for (int k = 0; k < neighbors.length; k++) {
            if (neighbors[k] != null) {
                site = neighbors[k];
                if (isOpen(site.x, site.y)) {
                    unionFind.union(index, getIndex(site.x, site.y));
                }
            }
        }
        numberOfOpenedSites++;
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        return openStates[getIndex(i, j)] == 1;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        return unionFind.connected(getIndex(i, j), topIndex);
    }

    public boolean percolates() {
        return unionFind.connected(bottomIndex, topIndex);
    }

    public double getProbability() {
        return (double) ((double) numberOfOpenedSites / (double) (n));
    }

    public void randomOpen() {
        int i = random.nextInt(N);
        int j = random.nextInt(N);
        open(i, j);
    }

    public int getIndex(int i, int j) {
        return i * N + j;
    }

    public Site[] getNeighbors(int i, int j) {
        //0. top; 1. bottom 2. left 3. right
        Site[] neighbors = new Site[4];
        //top.
        if (i == 0) {
            neighbors[0] = null;
        } else {
            neighbors[0] = new Site(i - 1, j);
        }
        //bottom.
        if (i == N - 1) {
            neighbors[1] = null;
        } else {
            neighbors[1] = new Site(i + 1, j);
        }
        //left.
        if (j == 0) {
            neighbors[2] = null;
        } else {
            neighbors[2] = new Site(i, j - 1);
        }
        //right.
        if (j == N - 1) {
            neighbors[3] = null;
        } else {
            neighbors[3] = new Site(i, j + 1);
        }
        return neighbors;
    }

    public void drawOpenStates() {
        if (N > 10) {
            return;
        }
        String str = "";
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (openStates[i] == 1) {
                str += " " + "■";
            } else {
                str += " " + "□";
            }
            count++;
            if (count == N) {
                str += "\n";
                count = 0;
            }
        }
        System.out.print("\n" + str);
    }

    class Site {
        int x = 0;
        int y = 0;

        public Site(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

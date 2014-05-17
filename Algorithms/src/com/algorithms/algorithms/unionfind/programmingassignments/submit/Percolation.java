package com.algorithms.algorithms.unionfind.programmingassignments.submit;

/**
 * Created by Who on 2014/4/18.
 */
public class Percolation {

    private int[] openStates = null;
    private int n = 0;
    private int N = 0;
    private int topIndex = 0;
    private int bottomIndex = 0;
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
        if (i < 1 || j < 1 || i > N + 1 || j > N + 1) {
            throw new IndexOutOfBoundsException();
        }
        int index = getIndex(i - 1, j - 1);
        openStates[index] = 1;
        Site[] neighbors = getNeighbors(i - 1, j - 1);
        Site site = null;
        for (int k = 0; k < neighbors.length; k++) {
            if (neighbors[k] != null) {
                site = neighbors[k];
                if (isOpen(site.x, site.y)) {
                    unionFind.union(index, getIndex(site.x, site.y));
                }
            }
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        if (i < 1 || j < 1 || i > N + 1 || j > N + 1) {
            throw new IndexOutOfBoundsException();
        }
        return openStates[getIndex(i - 1, j - 1)] == 1;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        if (i < 1 || j < 1 || i > N + 1 || j > N + 1) {
            throw new IndexOutOfBoundsException();
        }
        return unionFind.connected(getIndex(i - 1, j - 1), topIndex);
    }

    public boolean percolates() {
        return unionFind.connected(bottomIndex, topIndex);
    }

    private int getIndex(int i, int j) {
        return i * N + j;
    }

    private Site[] getNeighbors(int i, int j) {
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

    private class Site {
        private int x = 0;
        private int y = 0;

        public Site(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private class UnionFind {
        private int[] N;
        private int[] nSize;

        public int[] getN() {
            return N;
        }

        public void init(int n) {
            N = new int[n];
            nSize = new int[n];
            for (int i = 0; i < n; i++) {
                N[i] = i;
                nSize[i] = 1;
            }
        }

        public int root(int n) {
            while (n != N[n]) {
                //Compress.
                N[n] = N[N[n]];
                n = N[n];
            }
            return n;
        }

        public void union(int p, int q) {
            int pRoot = root(p);
            int qRoot = root(q);
            //I do not want a loop.
            if (pRoot == qRoot) {
                return;
            }
            if (nSize[pRoot] >= nSize[qRoot]) {
                N[qRoot] = pRoot;
                nSize[pRoot] += nSize[qRoot];
            } else {
                N[pRoot] = qRoot;
                nSize[qRoot] += nSize[pRoot];
            }
        }

        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }
    }
}
package com.algorithms.algorithms.unionfind;

/**
 * Created by Who on 2014/4/4.
 */

public class UnionFind {

    private int[] N;
    private int[] NSize;

    public int[] getN() {
        return N;
    }

    public void init(int n) {
        N = new int[n];
        NSize = new int[n];
        for (int i = 0; i < n; i++) {
            N[i] = i;
            NSize[i] = 1;
        }
    }

    public int root(int n) {
        while (n != N[n]) {
            //Compress。增加此行代码，大大压缩了树的高度。所以，当N的数量不大时，树的高度将被压缩为2层：一个root，和一群node。
            N[n] = N[N[n]];
            n = N[n];
        }
        return n;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        //如果已经union，则不再次union，防止形成loop。
        if (pRoot == qRoot) {
            return;
        }
        if (NSize[pRoot] >= NSize[qRoot]) {
            N[qRoot] = pRoot;
            NSize[pRoot] += NSize[qRoot];
        } else {
            N[pRoot] = qRoot;
            NSize[qRoot] += NSize[pRoot];
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void printN() {
        int length = String.valueOf(N.length).length();
        String str = "";
        for (int i = 0; i < N.length; i++) {
            str += " " + padding(String.valueOf(N[i]), "0", length);
        }
        System.out.print("\n" + str);
    }

    public void printN(int wrap) {
        int length = String.valueOf(N.length).length();
        String str = "";
        int count = 0;
        for (int i = 0; i < N.length; i++) {
            str += " " + padding(String.valueOf(N[i]), "0", length);
            count++;
            if (count == wrap) {
                str += "\n";
                count = 0;
            }
        }
        System.out.print("\n" + str);
    }

    public String padding(String string, String pad, int length) {
        while (string.length() < length) {
            string = pad + string;
        }
        return string;
    }
}

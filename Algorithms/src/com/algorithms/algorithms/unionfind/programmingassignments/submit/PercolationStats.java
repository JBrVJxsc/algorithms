package com.algorithms.algorithms.unionfind.programmingassignments.submit;

import java.util.Random;

/**
 * Created by Who on 2014/4/18.
 */
public class PercolationStats {

    private int N = 0;
    private int T = 0;
    private int n = 0;
    private double[] probabilities = null;
    private int numberOfOpenedSites = 0;
    private Random random = new Random();

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        this.N = N;
        this.T = T;
        n = N * N;
    }

    // test client, described below
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(N, T);
        percolationStats.run();
    }

    // sample mean of percolation threshold
    public double mean() {
        double sum = 0d;
        for (int i = 0; i < probabilities.length; i++) {
            sum += probabilities[i];
        }
        return sum / probabilities.length;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        double sum = 0d;
        double mean = mean();
        for (int i = 0; i < probabilities.length; i++) {
            sum += (probabilities[i] - mean) * (probabilities[i] - mean);
        }
        double stddev = 0d;
        if (probabilities.length > 1) {
            stddev = Math.sqrt(sum / (probabilities.length - 1));
        } else {
            return Math.sqrt(sum);
        }
        return stddev;
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        double mean = mean();
        double stddev = stddev();
        double confidenceLo = mean - 1.96 * stddev / Math.sqrt(probabilities.length);
        return confidenceLo;
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        double mean = mean();
        double stddev = stddev();
        double confidenceHi = mean + 1.96 * stddev / Math.sqrt(probabilities.length);
        return confidenceHi;
    }

    private void run() {
        probabilities = new double[T];
        for (int i = 0; i < probabilities.length; i++) {
            Percolation percolation = new Percolation(N);
            while (!percolation.percolates()) {
                int x = random.nextInt(N) + 1;
                int y = random.nextInt(N) + 1;
                if (percolation.isOpen(x, y)) {
                    continue;
                }
                percolation.open(x, y);
                numberOfOpenedSites++;
            }
            probabilities[i] = (double) numberOfOpenedSites / (double) n;
        }
        System.out.print("\nMean: " + String.valueOf(mean()));
        System.out.print("\nStandard deviation: : " + String.valueOf(stddev()));
        System.out.print("\nLower confidence interval: " + String.valueOf(confidenceLo()));
        System.out.print("\nUpper confidence interval: " + String.valueOf(confidenceHi()));
    }
}

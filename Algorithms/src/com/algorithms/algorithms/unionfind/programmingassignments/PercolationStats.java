package com.algorithms.algorithms.unionfind.programmingassignments;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.common.Parameter;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/17.
 */
public class PercolationStats extends BaseAlgorithm implements IAlgorithm {

    private double[] probabilities = null;


    public PercolationStats() {

    }

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {

    }

    // test client, described below
    public static void main(String[] args) {

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
            sum += Math.pow(probabilities[i] - mean, 2);
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

    @Override
    public long getID() {
        return 1397731133753l;
    }

    @Override
    public String getName() {
        return "Percolation";
    }

    @Override
    public String getSummary() {
        String summary = "Write a program to estimate the value of the percolation threshold via Monte Carlo simulation.";
        summary += "\nhttp://coursera.cs.princeton.edu/algs4/assignments/percolation.html";
        return summary;
    }

    @Override
    public void run() {
        Parameter<Integer> sizeN = new Parameter<Integer>(200, "Size of N");
        Parameter<Integer> timesExperiment = new Parameter<Integer>(100, "Times of Experiment");
        set(sizeN, timesExperiment);
        probabilities = new double[timesExperiment.getValue()];
        for (int i = 0; i < probabilities.length; i++) {
            Percolation percolation = new Percolation(sizeN.getValue());
            while (!percolation.percolates()) {
                percolation.randomOpen();
            }
            probabilities[i] = percolation.getProbability();
            print(probabilities[i]);
        }
        print("Mean: " + mean());
        print("Standard deviation: : " + stddev());
        print("Lower confidence interval: " + confidenceLo());
        print("Upper confidence interval: " + confidenceHi());
    }
}

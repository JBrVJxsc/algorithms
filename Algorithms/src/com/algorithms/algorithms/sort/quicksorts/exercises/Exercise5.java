package com.algorithms.algorithms.sort.quicksorts.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.sort.quicksorts.Quicksort;
import com.algorithms.algorithms.sort.quicksorts.programmingassignments.Point;
import com.algorithms.algorithms.sort.quicksorts.programmingassignments.Points;
import com.algorithms.common.Parameter;
import com.algorithms.common.managers.StdDraw;
import com.algorithms.interfaces.IAlgorithm;

import java.util.ArrayList;

/**
 * Created by Who on 2014/5/4.
 */
public class Exercise5 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1399193045697l;
    }

    @Override
    public String getName() {
        return "Comparison between Brute and Fast for Collinear Points problem";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        Parameter<Integer> size = new Parameter<Integer>(350, "Number of points");
        set(size);
        Point[] ps = Point.getPoints(size.getValue());
        timerOn();
        testBrute(ps.clone());
        print("Brute time:");
        print(timerOff());
        show("Next");
        timerOn();
        testFast(ps.clone());
        print("Fast time:");
        print(timerOff());
    }

    private void testBrute(Point[] ps) {
        ArrayList<Points> pointsArrayList = new ArrayList<Points>();
        for (int i = 0; i < ps.length; i++) {
            for (int j = i + 1; j < ps.length; j++) {
                for (int k = j + 1; k < ps.length; k++) {
                    for (int l = k + 1; l < ps.length; l++) {
                        Point p = ps[i];
                        double s1 = ps[j].slopeTo(p);
                        double s2 = ps[k].slopeTo(p);
                        double s3 = ps[l].slopeTo(p);
                        if (s1 == s2 && s2 == s3) {
                            Points points = new Points(p, ps[j], ps[k], ps[l]);
                            if (!pointsArrayList.contains(points)) {
                                pointsArrayList.add(points);
                            }
                        }
                    }
                }
            }
        }
        //Draw.
        StdDraw.setXscale(0, ps.length);
        StdDraw.setYscale(0, ps.length);
        StdDraw.clear();
        print("Brute size:");
        print(pointsArrayList.size());
        for (Points points : pointsArrayList) {
            if (points.getPoints() != null) {
                Point[] p = points.getPoints();
                StdDraw.line(p[0].getX(), p[0].getY(), p[1].getX(), p[1].getY());
                StdDraw.line(p[0].getX(), p[0].getY(), p[2].getX(), p[2].getY());
                StdDraw.line(p[0].getX(), p[0].getY(), p[3].getX(), p[3].getY());
            } else {
                return;
            }
        }
        StdDraw.setVisible(true);
        for (int i = 0; i < ps.length; i++) {
            StdDraw.point(ps[i].getX(), ps[i].getY());
        }
    }

    private void testFast(Point[] ps) {
        Quicksort quicksort = new Quicksort();
        Point[] tempt = ps.clone();
        ArrayList<Points> pointsArrayList = new ArrayList<Points>();
        int length = ps.length;
        for (int i = 0; i < length; i++) {
            Point p = ps[i];
            quicksort.sort(tempt, p.SLOPE_ORDER);
            for (int j = 0; j < length - 2; j++) {
                double s1 = tempt[j].slopeTo(p);
                double s2 = tempt[j + 1].slopeTo(p);
                double s3 = tempt[j + 2].slopeTo(p);
                if (s1 == s2 && s2 == s3) {
                    Points points = new Points(p, tempt[j], tempt[j + 1], tempt[j + 2]);
                    if (!pointsArrayList.contains(points)) {
                        pointsArrayList.add(points);
                    }
                }
            }
        }
        //Draw.
        StdDraw.setXscale(0, ps.length);
        StdDraw.setYscale(0, ps.length);
        StdDraw.clear();
        print("Fast size:");
        print(pointsArrayList.size());
        for (Points points : pointsArrayList) {
            if (points.getPoints() != null) {
                Point[] p = points.getPoints();
                StdDraw.line(p[0].getX(), p[0].getY(), p[1].getX(), p[1].getY());
                StdDraw.line(p[0].getX(), p[0].getY(), p[2].getX(), p[2].getY());
                StdDraw.line(p[0].getX(), p[0].getY(), p[3].getX(), p[3].getY());
            } else {
                return;
            }
        }
        StdDraw.setVisible(true);
        for (int i = 0; i < ps.length; i++) {
            StdDraw.point(ps[i].getX(), ps[i].getY());
        }
    }
}

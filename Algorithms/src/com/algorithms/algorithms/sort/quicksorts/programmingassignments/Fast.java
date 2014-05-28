package com.algorithms.algorithms.sort.quicksorts.programmingassignments;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.sort.quicksorts.Quicksort;
import com.algorithms.common.Parameter;
import com.algorithms.common.functions.StdDraw;
import com.algorithms.interfaces.IAlgorithm;

import java.util.ArrayList;

/**
 * Created by Who on 2014/5/3.
 */
public class Fast extends BaseAlgorithm implements IAlgorithm {

    @Override
    public long getID() {
        return 1399174995481l;
    }

    @Override
    public String getName() {
        return "Collinear Points: Fast";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        Quicksort quicksort = new Quicksort();
        Parameter<Integer> size = new Parameter<Integer>(300, "Number of points");
//        set(size);
        Point[] ps = Point.getPoints(size.getValue());
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
        StdDraw.setXscale(0, size.getValue());
        StdDraw.setYscale(0, size.getValue());
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

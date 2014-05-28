package com.algorithms.algorithms.sort.quicksorts.programmingassignments;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.common.Parameter;
import com.algorithms.common.functions.StdDraw;
import com.algorithms.interfaces.IAlgorithm;

import java.util.ArrayList;

/**
 * Created by Who on 2014/5/3.
 */
public class Brute extends BaseAlgorithm implements IAlgorithm {

    @Override
    public long getID() {
        return 1399114787988l;
    }

    @Override
    public String getName() {
        return "Collinear Points: Brute";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        Parameter<Integer> size = new Parameter<Integer>(300, "Number of points");
//        set(size);
        Point[] ps = Point.getPoints(size.getValue());
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
        StdDraw.setXscale(0, size.getValue());
        StdDraw.setYscale(0, size.getValue());
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
}

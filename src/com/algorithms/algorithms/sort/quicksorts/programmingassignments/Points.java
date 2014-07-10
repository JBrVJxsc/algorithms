package com.algorithms.algorithms.sort.quicksorts.programmingassignments;

import java.util.ArrayList;

/**
 * Created by Who on 2014/5/3.
 */
public class Points {

    private Point[] points = null;
    private ArrayList<Point> pointArrayList = null;

    public Points(Point... points) {
        this.points = new Point[points.length];
        pointArrayList = new ArrayList<Point>();
        int i = 0;
        for (Point point : points) {
            this.points[i++] = point;
            pointArrayList.add(point);
        }
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object obj) {
        for (int i = 0; i < points.length; i++) {
            if (!pointArrayList.contains(obj)) {
                return false;
            }
        }
        return true;
    }
}

package com.algorithms.algorithms.sort.quicksorts.programmingassignments;

import com.algorithms.common.managers.StdDraw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by Who on 2014/5/3.
 */
public class Point implements Comparable<Point> {

    public final Comparator<Point> SLOPE_ORDER;
    private final int x;
    private final int y;

    public Point(int x, final int y) {
        this.x = x;
        this.y = y;
        SLOPE_ORDER = new Comparator<Point>() {
            private Point point = null;

            public Comparator<Point> setPoint(Point point) {
                this.point = point;
                return this;
            }

            @Override
            public int compare(Point o1, Point o2) {
                double slope1 = o1.slopeTo(point);
                double slope2 = o2.slopeTo(point);
                return Double.compare(slope1, slope2);
            }
        }.setPoint(this);
    }

    public static Point[] getPoints(int number) {
        Random random = new Random();
        ArrayList<Point> pointArrayList = new ArrayList<Point>();
        Point[] points = new Point[number];
        int index = 0;
        int range = number;
        while (index != points.length) {
            Point point = new Point(random.nextInt(range), random.nextInt(range));
            //Loop, until get an unique point.
            while (pointArrayList.contains(point)) {
                point = new Point(random.nextInt(range), random.nextInt(range));
            }
            points[index] = point;
            pointArrayList.add(point);
            index++;
        }
        return points;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(x, y, that.x, that.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double slopeTo(Point that) {
        if (x == that.x) {
            if (y > that.y) {
                return Double.NEGATIVE_INFINITY;
            } else if (y < that.y) {
                return Double.NEGATIVE_INFINITY;
            } else {
                return Double.MIN_VALUE;
            }
        }
        return (double) (that.y - y) / (double) (that.x - x);
    }

    @Override
    public int compareTo(Point o) {
        if (y == o.y) {
            return Integer.compare(x, o.x);
        }
        return Integer.compare(y, o.y);
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return x == p.x && y == p.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

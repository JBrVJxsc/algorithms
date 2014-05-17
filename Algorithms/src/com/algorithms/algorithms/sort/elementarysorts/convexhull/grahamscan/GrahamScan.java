package com.algorithms.algorithms.sort.elementarysorts.convexhull.grahamscan;

import com.algorithms.algorithms.sort.elementarysorts.Shellsort;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * Created by Who on 2014/4/22.
 */
public class GrahamScan {

    private Point2D[] getPoints(int number) {
        Random random = new Random();
        ArrayList<Point2D> point2DArrayList = new ArrayList<Point2D>();
        Point2D[] point2Ds = new Point2D[number];
        int index = 0;
        int range = 700;
        while (index != point2Ds.length) {
            Point2D point2D = new Point2D(random.nextInt(range), random.nextInt(range));
            //Loop, until get an unique point.
            while (point2DArrayList.contains(point2D)) {
                point2D = new Point2D(random.nextInt(range), random.nextInt(range));
            }
            point2Ds[index] = point2D;
            point2DArrayList.add(point2D);
            index++;
        }
        return point2Ds;
    }

    private int ccw(Point a, Point b, Point c) {
        double area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        //clockwise.
        if (area < 0) {
            return -1;
        }
        //counter-clockwise.
        else if (area > 0) {
            return 1;
        }
        //collinear.
        return 0;
    }

    public boolean scan(Point2D[] point2Ds) {
        Shellsort shellSort = new Shellsort();
        //Default compare model is Y. So there is no need to set their compare model.
        shellSort.sort(point2Ds);
        ArrayList<Point2D> point2DArrayList = new ArrayList<Point2D>();
        int minY = point2Ds[0].y;
        for (int i = 0; i < point2Ds.length; i++) {
            if (point2Ds[i].y == minY) {
                point2DArrayList.add(point2Ds[i]);
            } else {
                break;
            }
        }
        //After getting all points which the Y is the smallest, and find the biggest X in them.
        Point2D[] point2DsForXCompare = new Point2D[point2DArrayList.size()];
        for (int i = 0; i < point2DsForXCompare.length; i++) {
            point2DsForXCompare[i] = point2DArrayList.get(i);
            point2DsForXCompare[i].setCompareModel(CompareModel.X);
        }
        shellSort.sort(point2DsForXCompare);
        //Found the polar point.
        Point2D polarPoint = point2DsForXCompare[point2DsForXCompare.length - 1];
        //Create new array without polar point and sort it by the polar angle.
        Point2D[] point2DsSorted = new Point2D[point2Ds.length - 1];
        int index = 0;
        for (int i = 0; i < point2Ds.length; i++) {
            if (point2Ds[i].equals(polarPoint)) {
                continue;
            } else {
                point2DsSorted[index] = point2Ds[i];
                point2DsSorted[index].setPolarPoint(polarPoint);
                point2DsSorted[index].setCompareModel(CompareModel.PolarAngle);
                index++;
            }
        }
        shellSort.sort(point2DsSorted);
        //Scan.
        StackPlus<Point2D> stack = new StackPlus<Point2D>();
        stack.push(polarPoint);
        stack.push(point2DsSorted[point2DsSorted.length - 1]);
        //It is only five lines long code...
        for (int i = point2DsSorted.length - 2; i >= 0; i--) {
            while (ccw(stack.getSecond(), stack.getFirst(), point2DsSorted[i]) <= 0) {
                stack.pop();
            }
            stack.push(point2DsSorted[i]);
        }
        //Get all convex hull points.
        int size = stack.size() + 1;
        Point2D[] resultPoints = new Point2D[size];
        resultPoints[0] = polarPoint;
        for (int i = 1; i < size; i++) {
            resultPoints[i] = stack.get(i - 1);
            resultPoints[i].setVertex(true);
        }
        //Draw the result.
        DrawingDialog drawingDialog = new DrawingDialog(point2Ds, resultPoints);
        drawingDialog.setResizable(false);
        drawingDialog.pack();
        drawingDialog.setLocationRelativeTo(null);
        drawingDialog.setVisible(true);
        return drawingDialog.isContinueRun();
    }

    public boolean demo(int number) {
        Point2D[] point2Ds = getPoints(number);
        return scan(point2Ds);
    }

    private class StackPlus<T> extends Stack<T> {
        public T getFirst() {
            if (size() > 0) {
                return get(size() - 1);
            } else {
                return null;
            }
        }

        public T getSecond() {
            if (size() > 1) {
                return get(size() - 2);
            } else {
                return null;
            }
        }
    }
}

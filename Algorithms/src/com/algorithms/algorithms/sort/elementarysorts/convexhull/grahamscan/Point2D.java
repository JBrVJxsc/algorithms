package com.algorithms.algorithms.sort.elementarysorts.convexhull.grahamscan;

import java.awt.*;

/**
 * Created by Who on 2014/4/22.
 */
public class Point2D extends Point implements Comparable {

    private CompareModel compareModel = CompareModel.Y;
    private Point2D polarPoint = null;
    private Point2D pointOnY = null;
    private boolean vertex = false;

    public Point2D(int x, int y) {
        super(x, y);
    }

    public void setCompareModel(CompareModel compareModel) {
        this.compareModel = compareModel;
    }

    public void setPolarPoint(Point2D polarPoint) {
        this.polarPoint = polarPoint;
        this.pointOnY = new Point2D(0, polarPoint.y);
    }

    public boolean isVertex() {
        return vertex;
    }

    public void setVertex(boolean vertex) {
        this.vertex = vertex;
    }

    private double getPolarAngle() {
        double ma_x = x - polarPoint.x;
        double ma_y = y - polarPoint.y;
        double mb_x = pointOnY.x - polarPoint.x;
        double mb_y = pointOnY.y - polarPoint.y;
        double v1 = (ma_x * mb_x) + (ma_y * mb_y);
        double ma_val = Math.sqrt(ma_x * ma_x + ma_y * ma_y);
        double mb_val = Math.sqrt(mb_x * mb_x + mb_y * mb_y);
        double cosM = v1 / (ma_val * mb_val);
        double angleAMB = Math.acos(cosM) * 180 / Math.PI;
        return angleAMB;
    }

    @Override
    public int compareTo(Object o) {
        Point2D point2D = (Point2D) o;
        if (compareModel == CompareModel.X) {
            if (x > point2D.x) {
                return 1;
            } else if (x < point2D.x) {
                return -1;
            }
        } else if (compareModel == CompareModel.Y) {
            if (y > point2D.y) {
                return 1;
            } else if (y < point2D.y) {
                return -1;
            }
        } else if (compareModel == CompareModel.PolarAngle) {
            if (getPolarAngle() > point2D.getPolarAngle()) {
                return 1;
            } else if (getPolarAngle() < point2D.getPolarAngle()) {
                return -1;
            }
        }
        return 0;
    }
}
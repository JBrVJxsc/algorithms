package com.algorithms.algorithms.sort.elementarysorts.convexhull.grahamscan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawingDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel pnlDraw;

    private boolean continueRun = false;
    private Point2D[] allPoints = null;
    private Point2D[] convexHullPoints = null;
    private int[] convexHullPointsX = null;
    private int[] convexHullPointsY = null;
    private int xOffset = 80;
    private int yOffset = 80;

    public DrawingDialog(Point2D[] allPoints, Point2D[] convexHullPoints) {
        this.allPoints = allPoints;
        this.convexHullPoints = convexHullPoints;
        convexHullPointsX = new int[convexHullPoints.length];
        convexHullPointsY = new int[convexHullPoints.length];
        for (int i = 0; i < convexHullPoints.length; i++) {
            convexHullPointsX[i] = convexHullPoints[i].x + xOffset + 1;
            convexHullPointsY[i] = convexHullPoints[i].y + yOffset + 1;
        }
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here
        continueRun = true;
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        continueRun = false;
        dispose();
    }

    public boolean isContinueRun() {
        return continueRun;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < allPoints.length; i++) {
            int x = allPoints[i].x + xOffset;
            int y = allPoints[i].y + yOffset;
            g.fillRect(x, y, 3, 3);
            if (allPoints[i].isVertex()) {
                g.drawString("(" + x + ", " + y + ")", x + 5, y + 5);
            }
        }
        g.drawPolygon(convexHullPointsX, convexHullPointsY, convexHullPoints.length);
    }
}

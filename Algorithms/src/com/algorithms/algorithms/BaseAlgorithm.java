package com.algorithms.algorithms;

import com.algorithms.common.Parameter;
import com.algorithms.listeners.PrintConsoleListener;
import com.algorithms.listeners.SetParameterListener;

import javax.swing.*;
import java.util.Stack;

/**
 * Created by Who on 2014/4/10.
 */
public abstract class BaseAlgorithm {

    private PrintConsoleListener printConsoleListener = new PrintConsoleListener();
    private SetParameterListener setParameterListener = new SetParameterListener();
    private Stack<Long> timer = new Stack<Long>();

    public abstract String getName();

    public void addPrintConsoleListener(PrintConsoleListener printConsoleListener) {
        this.printConsoleListener = (PrintConsoleListener) printConsoleListener;
    }

    public void addSetParameterListener(SetParameterListener setParameterListener) {
        this.setParameterListener = (SetParameterListener) setParameterListener;
    }

    protected void show(Object message) {
        JOptionPane.showMessageDialog(null, message);
    }

    protected void show(Object message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    protected String print(Object[] objects) {
        String string = "";
        for (Object object : objects) {
            string += object.toString() + " ";
        }
        return print(string);
    }

    protected String print(Object object) {
        String string = object.toString();
        return print(string);
    }

    protected String print(double d) {
        return print(String.valueOf(d));
    }

    protected String print(double[] ds) {
        String string = "";
        for (double d : ds) {
            string += String.valueOf(d) + " ";
        }
        return print(string);
    }

    protected String print(Double d) {
        return print(String.valueOf(d));
    }

    protected String print(long l) {
        return print(String.valueOf(l));
    }

    protected String print(long[] ls) {
        String string = "";
        for (long l : ls) {
            string += String.valueOf(l) + " ";
        }
        return print(string);
    }

    protected String print(Long l) {
        return print(String.valueOf(l));
    }

    protected String print(int i) {
        return print(String.valueOf(i));
    }

    protected String print(int[] is) {
        String string = "";
        for (int i : is) {
            string += String.valueOf(i) + " ";
        }
        return print(string);
    }

    protected String print(Integer i) {
        return print(String.valueOf(i));
    }

    protected String print(String string) {
        printConsoleListener.print("\n" + string);
        System.out.print("\n" + string);
        return string;
    }

    protected String print() {
        return print("");
    }

    protected void set(Parameter... parameters) {
        setParameterListener.set(parameters);
    }

    protected void timerOn() {
        timer.push(System.currentTimeMillis());
    }

    protected long timerOff() {
        return System.currentTimeMillis() - timer.pop();
    }

    @Override
    public String toString() {
        return getName();
    }
}
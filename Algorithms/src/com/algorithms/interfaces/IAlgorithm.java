package com.algorithms.interfaces;

import com.algorithms.listeners.PrintConsoleListener;
import com.algorithms.listeners.SetParameterListener;

/**
 * Created by Who on 2014/4/4.
 */
public interface IAlgorithm {
    long getID();

    String getName();

    String getSummary();

    void run();

    void addPrintConsoleListener(PrintConsoleListener printConsoleListener);

    void addSetParameterListener(SetParameterListener setParameterListener);
}

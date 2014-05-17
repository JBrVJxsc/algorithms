package com.algorithms.algorithms.unionfind.jobinterview.a1q1;

/**
 * Created by Who on 2014/4/4.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LogFile {

    private ArrayList<Log> logList = new ArrayList<Log>();

    public void AddLog(int p, int q, long timestamp) {
        logList.add(new Log(p, q, timestamp));
    }

    public void Clear() {
        logList.clear();
    }

    public void Sort() {
        Collections.sort(logList, new SortByTimestamp());
    }

    public ArrayList<Log> getLogList() {
        return logList;
    }

    class Log {

        private int p;
        private int q;
        private long timestamp;

        public Log(int p, int q, long timestamp) {
            setP(p);
            setQ(q);
            setTimestamp(timestamp);
        }

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }

        public int getQ() {
            return q;
        }

        public void setQ(int q) {
            this.q = q;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
    }

    class SortByTimestamp implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            // TODO Auto-generated method stub
            if (((Log) o1).getTimestamp() > ((Log) o2).getTimestamp()) {
                return 1;
            }
            return 0;
        }
    }
}

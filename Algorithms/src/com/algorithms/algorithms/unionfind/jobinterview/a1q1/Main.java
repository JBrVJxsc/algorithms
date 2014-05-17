package com.algorithms.algorithms.unionfind.jobinterview.a1q1;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.unionfind.UnionFind;
import com.algorithms.common.Parameter;
import com.algorithms.interfaces.IAlgorithm;

import java.util.Random;

/**
 * Created by Who on 2014/4/4.
 */
public class Main extends BaseAlgorithm implements IAlgorithm {

    @Override
    public long getID() {
        return 1397731085146l;
    }

    @Override
    public String getName() {
        return "Social network connectivity";
    }

    @Override
    public String getSummary() {
        return "Given a social network containing N members and a log file containing M timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be MlogN or better and use extra space proportional to N.";
    }

    @Override
    public void run() {
        Parameter<Integer> initCount = new Parameter<Integer>(50, "The size of N");
        set(initCount);
        UnionFind unionFind = new UnionFind();
        unionFind.init(initCount.getValue());
        LogFile logFile = randomUnion(unionFind);
    }

    public LogFile randomUnion(UnionFind unionFind) {
        Random random = new Random();
        int nLength = unionFind.getN().length;
        int randomCount = 0;
        LogFile logFile = new LogFile();
        while (!check(unionFind, randomCount)) {
            int p = random.nextInt(nLength);
            int q = random.nextInt(nLength);
            logFile.AddLog(p, q, System.currentTimeMillis());
            unionFind.union(p, q);
            print(p + " " + q);
            try {
                //每次循环都暂停1毫秒，否则相邻的两次时间戳有可能相同。
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
            randomCount++;
        }
        long startTime = logFile.getLogList().get(0).getTimestamp();
        long endTime = logFile.getLogList().get(randomCount - 1).getTimestamp();
        print("All items are connected. \nTime cost: " + String.valueOf(endTime - startTime) + " ms\nRandom Times: " + randomCount);
        return logFile;
    }

    public LogFile randomUnion(UnionFind unionFind, int n) {
        Random random = new Random();
        int nLength = unionFind.getN().length;
        LogFile logFile = new LogFile();
        for (int i = 0; i < n; i++) {
            int p = random.nextInt(nLength);
            int q = random.nextInt(nLength);
            logFile.AddLog(p, q, System.currentTimeMillis());
            unionFind.union(p, q);
            print(p + " " + q);
            try {
                //每次循环都暂停1毫秒，否则相邻的两次时间戳有可能相同。
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        return logFile;
    }

    public boolean check(UnionFind unionFind, int randomCount) {
        //当随机union的次数小于N的长度减一时，肯定不可能所有item均连接。
        if (randomCount < unionFind.getN().length - 1) {
            return false;
        }

        for (int i = 1; i < unionFind.getN().length; i++) {
            //由于UnionFind的树是经过Compress的，所以connected方法的时间复杂度为lg*N，lg*N的最大值为5。
            if (!unionFind.connected(0, i)) {
                return false;
            }
        }
        return true;
    }
}
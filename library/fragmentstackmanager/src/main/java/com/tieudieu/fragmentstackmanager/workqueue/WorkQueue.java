package com.tieudieu.fragmentstackmanager.workqueue;

import com.tieudieu.util.DebugLog;

import java.util.LinkedList;

/**
 * Created by chienchieu on 04/03/2017.
 */

public class WorkQueue {

    private static final int NUMBER_OF_CORE = Runtime.getRuntime().availableProcessors();

    private int maxThread;
    private LinkedList<Runnable> queue;
    private WorkerThread[] threads;
    private boolean isRunning;

    public WorkQueue(int maxThread) {
        DebugLog.d("xxx-availableProcessors=" + NUMBER_OF_CORE);
        if (maxThread <= 0) {
            maxThread = NUMBER_OF_CORE * 2;
        }
        this.maxThread = maxThread;
        queue = new LinkedList<>();
        threads = new WorkerThread[maxThread];
    }

    /**
     * Just start a Worker Thread
     * Will start Other if need: when queue tasks is not empty after have task running
     */
    public void start() {
        if (!isRunning) {
            isRunning = true;
            for (int i = 0; i < maxThread; i++) {
                threads[i] = new WorkerThread();
                // threads[i].start();
            }
            if (threads.length > 0) {
                threads[0] = new WorkerThread();
                threads[0].start();
            }
        }
    }

    public void stop() {
        isRunning = false;
    }

    public void execute(Runnable runnable) {
        DebugLog.d("xxx-execute");
        synchronized (queue) {
            queue.add(runnable);
            queue.notify();
        }
    }

    private void newWorkerIfNeed() {
        synchronized (queue) {
            if (!queue.isEmpty()) {
                for (int i = 0; i < threads.length; i++) {
                    if (threads[i].isAlive()){

                        try {
                            threads[i].start();
                        } catch (Exception e){
                            e.printStackTrace();
                        }

                        return;
                    }
                }
            }
        }
    }

    private class WorkerThread extends Thread {

        @Override
        public void run() {
            Runnable r;
            while (isRunning) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    r = queue.removeFirst();
                    // start new Worker if need
                    newWorkerIfNeed();
                    try {
                        DebugLog.d("xxx-new-work-run");
                        r.run();
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

package com.kuibu.algorithm.current.test;

/**
 * @Classname ThreadTest
 * @Description ThreadTest
 * @Date 2021/6/7
 * @Created by chenguangjin
 */
public class ThreadTest {
    private static final Object LOCK = new Object();
    private static volatile boolean FLAG = false;

    public static void main(String[] args) {

        new ThreadA().start();
        new ThreadB().start();

    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (LOCK) {
                for (int i = 0; i <= 10; i += 2) {
                    if(FLAG) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i);
                    FLAG = true;
                    LOCK.notify();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            synchronized (LOCK) {
                for (int i = 1; i <= 10; i += 2) {
                    if (!FLAG) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i);
                    FLAG = false;
                    LOCK.notify();
                }
            }
        }
    }
}

package com.kuibu.algorithm.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname ThreeThreadPrint
 * @Description thread demo
 * @Date 2021/6/27 22:47
 * @Created by chenguangjin
 */
public class ThreeThreadPrint {
    public static void main(String[] args) {
        Print print = new Print();

       new Thread(() -> {
           print.printA();
       }).start();

       new Thread(() -> {
           print.printB();
       }).start();

       new Thread(() -> {
           print.printC();
        }).start();
    }


}

class Print {
    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private  int flag = 1;


    public void printA() {
        lock.lock();
        try {
            for(int i = 0; i < 10; i++) {
                if (flag != 1) {
                    conditionA.await();
                }

                System.out.println("A");

                flag = 2;
                conditionB.signal();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            for(int i = 0; i < 10; i++) {
                if(flag != 2) {
                    conditionB.await();
                }

                System.out.println("B");

                flag = 3;
                conditionC.signal();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            for(int i = 0; i < 10; i++) {
                if(flag != 3) {
                    conditionC.await();
                }

                System.out.println("C");
                flag = 1;
                conditionA.signal();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

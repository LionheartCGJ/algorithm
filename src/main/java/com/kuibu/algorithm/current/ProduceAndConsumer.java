package com.kuibu.algorithm.current;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @Classname ProduceAndConsumer
 * @Description ProduceAndConsumer
 * @Date 2021/6/7
 * @Created by chenguangjin
 */
public class ProduceAndConsumer {
    private static final int CAPACITY = 5;

    public static void main(String args[]){
        Queue<Integer> queue = new LinkedList<Integer>();

        Thread producer1 = new Producer("P-1", queue, CAPACITY);
        Thread producer2 = new Producer("P-2", queue, CAPACITY);
        Thread consumer1 = new Consumer("C1", queue);
        Thread consumer2 = new Consumer("C2", queue);
        Thread consumer3 = new Consumer("C3", queue);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }

    /**
     * 生产者
     */
    public static class Producer extends Thread{
        private Queue<Integer> queue;
        String name;
        int maxSize;
        int i = 0;

        public Producer(String name, Queue<Integer> queue, int maxSize){
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run(){
            while(true){
                synchronized(queue){
                    while(queue.size() == maxSize){
                        try {
                            System.out .println("Queue is full, Producer[" + name + "] thread waiting for " + "consumer to take something from queue.");
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("[" + name + "] Producing value : +" + i);
                    queue.offer(i++);
                    queue.notifyAll();

                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    /**
     * 消费者
     */
    public static class Consumer extends Thread{
        private Queue<Integer> queue;
        String name;

        public Consumer(String name, Queue<Integer> queue){
            super(name);
            this.name = name;
            this.queue = queue;
        }

        @Override
        public void run(){
            while(true){
                synchronized(queue){
                    while(queue.isEmpty()){
                        try {
                            System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    int x = queue.poll();
                    System.out.println("[" + name + "] Consuming value : " + x);
                    queue.notifyAll();

                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

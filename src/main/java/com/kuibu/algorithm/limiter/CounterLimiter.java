package com.kuibu.algorithm.limiter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname Limiter
 * @Description Limiter
 * @Date 2021/6/15
 * @Created by chenguangjin
 * 计数限流
 */
public class CounterLimiter extends RateLimiter {
    // 计数器
    private volatile int counter = 0;

    // 上次计数时间
    private volatile long lastTime = 0;

    // cas自旋锁
    private Lock lock = new ReentrantLock();

    public CounterLimiter(int rate) {
        super(rate);
    }

    public boolean tryAcquire() {
        lock.lock();
        try{
            // 是否已经过期了
            if (System.currentTimeMillis() - lastTime > 1000){
                counter = 0;
                lastTime = System.currentTimeMillis();
            }

            // 计数
            counter ++;

            // 是否超过速率
            if (counter <= rate){
                return true;
            }
        }finally {
            lock.unlock();
        }

        return false;
    }
}

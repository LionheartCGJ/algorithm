package com.kuibu.algorithm.limiter;

/**
 * @Classname Limiter
 * @Description Limiter
 * @Date 2021/6/15
 * @Created by chenguangjin
 */
public abstract class RateLimiter {

    /**
     * 速率，每一秒多少次请求。
     */
    protected int rate = 1;


    RateLimiter(int rate){
        this.rate = rate;
    }

    /**
     * 是否通过请求（非阻塞）
     */
    public abstract boolean tryAcquire();

    /**
     * 是否允许通过(阻塞)
     */
    public void acquire(){
        do {
            if (tryAcquire()){
                return;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (true);
    }
}

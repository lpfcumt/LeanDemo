/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   SemaphoreTest.java   
 * @Package com.lpfcumt.thread   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月28日 下午4:57:32   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.thread;

import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreTest
 * @Description TODO(测试 semaphore 类的用法 负责协调各个线程，以保证它们能够正确、合理的使用公共资源的设施，也是操作系统中用于控制进程同步互斥的量。
 *              Semaphore是一种计数信号量，用于管理一组资源，内部是基于AQS的共享模式。它相当于给线程规定一个量从而控制允许活 动的线程数 )
 * @author lin.pf
 * @date 2019年2月28日 下午4:57:32
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class SemaphoreTest {

    public static Semaphore semaphore;
    private static final int THREADS_LENGTH = 10;
    private static final int CAR_PORT = 5;

    public static void main(String[] args) {
        semaphore = new Semaphore(CAR_PORT, true);
        Thread[] threads = new Thread[THREADS_LENGTH];
        System.out.println("总共有" + CAR_PORT + "个停车位");
        for (int i = 0; i < THREADS_LENGTH; i++) {
            threads[i] = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "获得了一个停车位");
                        System.out
                                .println(Thread.currentThread().getName() + "当前剩余停车位：" + semaphore.availablePermits());
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName() + "释放了一个停车位");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
    }

}

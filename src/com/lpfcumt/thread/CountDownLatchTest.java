/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   CountDownLatchTest.java   
 * @Package com.lpfcumt.thread   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月28日 下午3:39:42   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchTest
 * @Description TODO(测试 countdownlatch 类的用法 利用它可以实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行 )
 * @author lin.pf
 * @date 2019年2月28日 下午3:39:42
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class CountDownLatchTest {

    private static final int THREADS_LENGTH = 10;
    private static CountDownLatch downLatch;

    public static void main(String[] args) throws InterruptedException {
        downLatch = new CountDownLatch(THREADS_LENGTH);
        Thread[] threads = new Thread[THREADS_LENGTH];
        for (int i = 0; i < THREADS_LENGTH; i++) {
            int name = i;
            threads[i] = new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(name + "：正在干活。。。");
                    downLatch.countDown();
                }
            });
            threads[i].start();
        }
        threads[1].join();
        System.out.println("等待所有员工干活完成。。。");
        downLatch.await();
        System.out.println("领导检查。。。");
    }

}

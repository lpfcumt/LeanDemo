/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   VolatileTest.java   
 * @Package com.lpfcumt.thread   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月26日 下午5:12:22   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName VolatileTest
 * @Description TODO(volatile 关键字并发一致性测试 1.保证此变量对所有线程的可见性 2.禁止指令重排序优化 )
 * @author lin.pf
 * @date 2019年2月26日 下午5:12:22
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class VolatileTest {

	// public static volatile int race = 0; // 线程不安全，不具备原子性
	public static AtomicInteger race = new AtomicInteger(0);

	// incrementAndGet 方法是原子性 调用了Unsafe 类里的 原子性方法
	public static void increase() {
		// race++;
		race.incrementAndGet();
	}

	private static final int THREADS_COUNT = 20;

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[THREADS_COUNT];
		final CountDownLatch downLatch = new CountDownLatch(20);
		for (int i = 0; i < THREADS_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < 10000; j++) {
						increase();
					}
					System.out.println(Thread.currentThread().getName() + ":" + race);
					downLatch.countDown();
				}
			});
			threads[i].start();
		}
		downLatch.await();
		// while (Thread.activeCount() > 1) {
		// Thread.yield();
		// System.out.println(race);
		// }
		System.out.println(race);
	}

}

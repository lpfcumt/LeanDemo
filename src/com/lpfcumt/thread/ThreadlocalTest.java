/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   ThreadlocalTest.java   
 * @Package com.lpfcumt.thread   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年3月1日 下午3:05:30   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ThreadlocalTest
 * @Description TODO(测试 threadlocal 类的使用方法与实现原理 它是线程的局部变量，这些变量只能在这个线程内被读写，在其他线程内是无法访问的。 ThreadLocal
 *              定义的通常是与线程关联的私有静态字段（例如，用户ID或事务ID） )
 * @author lin.pf
 * @date 2019年3月1日 下午3:05:30
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class ThreadlocalTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch downLatch = new CountDownLatch(10);
		ThreadLocal<String> tLocal = new ThreadLocal<String>() {
			@Override
			protected String initialValue() {
				return "my first threadlocal";
			}
		};
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Runnable() {

				public void run() {

					System.out.println(Thread.currentThread().getName() + tLocal.get());
					tLocal.set(Thread.currentThread().getName());
					System.out.println(Thread.currentThread().getName() + tLocal.get());
					downLatch.countDown();
				}
			});
			threads[i].start();
		}
		// while (Thread.activeCount() > 1) {
		// Thread.yield();
		// System.out.println(tLocal.get());
		// }
		downLatch.await();
		tLocal.set("aaaaaaaaaaaaaaaaa");
		System.out.println(tLocal.get());
	}

}

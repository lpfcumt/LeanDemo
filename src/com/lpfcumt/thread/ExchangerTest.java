/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   ExchangerTest.java   
 * @Package com.lpfcumt.thread   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月28日 下午5:58:53   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ExchangerTest
 * @Description TODO(测试 exchanger 类的用法 用于进行线程间的数据交换。它提供一个同步点，在这个同步点两个线程可以交换彼此的数据。
 *              这两个线程通过exchange方法交换数据， 如果第一个线程先执行exchange方法，它会一直等待第二
 *              个线程也执行exchange，当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产 出来的数据传递给对方。 )
 * @author lin.pf
 * @date 2019年2月28日 下午5:58:53
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class ExchangerTest {
	
	public final native boolean isAlive();

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		System.out.println();
		final Exchanger exchanger = new Exchanger();
		executor.execute(new Runnable() {
			String data1 = "克拉克森，小拉里南斯";

			@Override
			public void run() {
				nbaTrade(data1, exchanger);
			}
		});

		executor.execute(new Runnable() {
			String data1 = "格里芬";

			@Override
			public void run() {
				nbaTrade(data1, exchanger);
			}
		});

//		executor.execute(new Runnable() {
//			String data1 = "哈里斯";
//
//			@Override
//			public void run() {
//				nbaTrade(data1, exchanger);
//			}
//		});
//
//		executor.execute(new Runnable() {
//			String data1 = "以赛亚托马斯，弗莱";
//
//			@Override
//			public void run() {
//				nbaTrade(data1, exchanger);
//			}
//		});

		executor.shutdown();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void nbaTrade(String data1, Exchanger exchanger) {
		try {
			System.out.println(Thread.currentThread().getName() + "在交易截止之前把 " + data1 + " 交易出去");
			Thread.sleep((long) (Math.random() * 1000));

			String data2 = (String) exchanger.exchange(data1);
			System.out.println(Thread.currentThread().getName() + "交易得到" + data2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

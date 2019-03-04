/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   CyclicBarrierTest.java   
 * @Package com.lpfcumt.thread   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月28日 下午4:21:45   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**   
 * @ClassName CyclicBarrierTest   
 * @Description TODO(测试 cyclicbarrier 类的用法
 * 		通过它可以实现让一组线程等待至某个状态之后再全部同时执行
 * )   
 * @author lin.pf 
 * @date 2019年2月28日 下午4:21:45     
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
public class CyclicBarrierTest {
	
	private static CyclicBarrier barrier;
	private static final int THREADS_LENGTH = 10;

	public static void main(String[] args) throws Exception{
		barrier = new CyclicBarrier(THREADS_LENGTH);
		Thread[] threads = new Thread[THREADS_LENGTH];
		for (int i = 0; i < THREADS_LENGTH; i++) {
			int name = i;
			threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(name + "：等待其他线程。。。");
					try {
						System.out.println(barrier.getNumberWaiting()); // 获取当前阻塞线程的数量
						barrier.await();
						
						System.out.println(name + "：开始执行。。。");
						Thread.sleep(1000);
						
						System.out.println(name + "：执行完毕。。。");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			});
			threads[i].start();
		}
	}

}

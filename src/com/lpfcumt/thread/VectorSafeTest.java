/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   VectorSafeTest.java   
 * @Package com.lpfcumt.thread   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月27日 下午5:34:43   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.thread;

import java.util.Vector;

/**   
 * @ClassName VectorSafeTest   
 * @Description TODO(测试vector集合是否 绝对线程安全
 * 		vector 是相对线程安全
 * 		如果另一个线程恰好在错误的时间里删除了一个元素，导致序号i已经不再可用，再用i访问就会报错
 * )   
 * @author lin.pf 
 * @date 2019年2月27日 下午5:34:43     
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
public class VectorSafeTest {
	
	private static Vector<Integer> vector = new Vector<Integer>();
	
	public static void main(String[] args) {
		while (true) {
			for (int i = 0; i < 10; i++) {
				vector.add(i);
			}
		
		
			Thread printThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < vector.size(); i++) {
						System.out.println(vector.get(i));
					}
				}
			});
			
			Thread removeTread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < vector.size(); i++) {
						vector.remove(i);
					}
				}
			});
			
			
			removeTread.start();
			printThread.start();
			
			while (Thread.activeCount() > 20);
		}
	}
}

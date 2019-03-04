/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   ArrayDisplay.java   
 * @Package com.lpfcumt.calculation   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月25日 下午5:57:02   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.calculation;

/**
 * @ClassName ArrayDisplay
 * @Description TODO(数据基类，实现dispaly方法)
 * @author lin.pf
 * @date 2019年2月25日 下午5:57:02
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class BaseArray {

	private int[] array;

	public BaseArray(int[] array) {
		this.array = array;
	}

	public void display() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

}

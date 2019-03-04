/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   ShellSort.java   
 * @Package com.lpfcumt.calculation   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月26日 下午4:26:24   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.calculation;

/**
 * @ClassName ShellSort
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author lin.pf
 * @date 2019年2月26日 下午4:26:24
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class ShellSort extends BaseArray {
	private int[] array;

	public ShellSort(int[] array) {
		super(array);
		this.array = array;
	}

	// 希尔排序
	public void shellSort() {
		int len = array.length;
		int counter = 1;
		int h = 1;
		while (3 * h + 1 < len) { // 确定第一轮排序时的间隔
			h = 3 * h + 1;
		}
		while (h > 0) {
			for (int i = 0; i < h; i++) {
				shellInsertSort(i, h); // 对间隔为h的元素进行插入排序
			}
			h = (h - 1) / 3; // 下一轮排序的间隔
			System.out.print("第" + counter + "轮排序结果：");
			display();
			counter++;
		}
	}

	/**
	 * 希尔排序内部使用的插入排序:
	 * 需要进行插入排序的元素为array[beginIndex]、array[beginIndex+increment]、array[
	 * beginIndex+2*increment]...
	 * 
	 * @param beginIndex
	 *            起始下标
	 * @param increment
	 *            增量
	 */
	private void shellInsertSort(int beginIndex, int increment) {
		int targetIndex = beginIndex + increment; // 欲插入元素的下标
		while (targetIndex < array.length) {
			int temp = array[targetIndex];
			int previousIndex = targetIndex - increment; // 前一个元素下标，间隔为increment
			while (previousIndex >= 0 && array[previousIndex] > temp) {
				array[previousIndex + increment] = array[previousIndex]; // 比欲插入数据项大的元素后移一位
				previousIndex = previousIndex - increment;
			}
			array[previousIndex + increment] = temp; // 插入到合适的位置
			targetIndex = targetIndex + increment; // 插入下一个元素
		}
	}

	public static void main(String[] args) {
	}

}

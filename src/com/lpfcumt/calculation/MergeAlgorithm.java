/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   MergeAlgorithm.java   
 * @Package com.lpfcumt.calculation   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月25日 上午10:29:52   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.calculation;

/**
 * @ClassName MergeAlgorithm
 * @Description TODO(归并排序)
 * @author lin.pf
 * @date 2019年2月25日 上午10:29:52
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class MergeAlgorithm {
	private int[] array; // 待排序的数组

	public MergeAlgorithm(int[] array) {
		this.array = array;
	}

	// 按顺序打印数组中的元素
	public void display() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

	// 归并排序
	public void mergeSort() {
		int[] workSpace = new int[array.length]; // 用于辅助排序的数组
		recursiveMergeSort(workSpace, 0, workSpace.length - 1);
	}

	/**
	 * 递归的归并排序
	 * 
	 * @param workSpace
	 *            辅助排序的数组
	 * @param lowerBound
	 *            欲归并数组段的最小下标
	 * @param upperBound
	 *            欲归并数组段的最大下标
	 */
	private void recursiveMergeSort(int[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) { // 该段只有一个元素，不用排序
			return;
		} else {
			int mid = (lowerBound + upperBound) / 2;
			recursiveMergeSort(workSpace, lowerBound, mid); // 对低位段归并排序
			recursiveMergeSort(workSpace, mid + 1, upperBound); // 对高位段归并排序
			merge(workSpace, lowerBound, mid, upperBound);
			display();
		}
	}

	/**
	 * 对数组array中的两段进行合并，lowerBound~mid为低位段，mid+1~upperBound为高位段
	 * 
	 * @param workSpace
	 *            辅助归并的数组，容纳归并后的元素
	 * @param lowerBound
	 *            合并段的起始下标
	 * @param mid
	 *            合并段的中点下标
	 * @param upperBound
	 *            合并段的结束下标
	 */
	private void merge(int[] workSpace, int lowerBound, int mid, int upperBound) {
		int lowBegin = lowerBound; // 低位段的起始下标
		int lowEnd = mid; // 低位段的结束下标
		int highBegin = mid + 1; // 高位段的起始下标
		int highEnd = upperBound; // 高位段的结束下标
		int j = 0; // workSpace的下标指针
		int n = upperBound - lowerBound + 1; // 归并的元素总数
		while (lowBegin <= lowEnd && highBegin <= highEnd) {
			if (array[lowBegin] < array[highBegin]) {// 将两者较小的那个放到workSpace中
				workSpace[j++] = array[lowBegin++];
			} else {
				workSpace[j++] = array[highBegin++];
			}
		}
		while (lowBegin <= lowEnd) {
			workSpace[j++] = array[lowBegin++];
		}
		while (highBegin <= highEnd) {
			workSpace[j++] = array[highBegin++];
		}
		for (j = 0; j < n; j++) { // 将归并好的元素复制到array中
			array[lowerBound++] = workSpace[j];
		}

	}

	public static void main(String[] args) {
		int[] a = { 6, 2, 7, 4, 8, 1, 5, 3 };
		MergeAlgorithm merge = new MergeAlgorithm(a);
		merge.mergeSort();
	}
}

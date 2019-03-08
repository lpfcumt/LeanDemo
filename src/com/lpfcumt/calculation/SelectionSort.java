/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   SelectionSort.java   
 * @Package com.lpfcumt.calculation   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月25日 下午5:54:41   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.calculation;

/**
 * @ClassName SelectionSort
 * @Description TODO(选择排序)
 * @author lin.pf
 * @date 2019年2月25日 下午5:54:41
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class SelectionSort extends BaseArray {

	private int[] array;

	public SelectionSort(int[] array) {
		super(array);
		this.array = array;
	}

	// 选择排序
	public void selectionSort() {
		int minPoint; // 存储最小元素的小标
		int len = array.length;
		int temp;
		int counter = 1;

		for (int i = 0; i < len - 1; i++) {
			minPoint = i;
			for (int j = i + 1; j <= len - 1; j++) { // 每完成一轮排序，就确定了一个相对最小元素，下一轮排序只对后面的元素排序
				if (array[j] < array[minPoint]) { // 如果待排数组中的某个元素比当前元素小，minPoint指向该元素的下标
					minPoint = j;
				}
			}
			if (minPoint != i) { // 如果发现了更小的元素，交换位置
				temp = array[i];
				array[i] = array[minPoint];
				array[minPoint] = temp;
			}
			System.out.print("第" + counter + "轮排序结果：");
			display();
			counter++;
		}
	}

	// 选择排序改进版
	public void selectionSort_improvement() {
		int minPoint; // 存储最小元素的小标
		int maxPoint; // 存储最大元素的小标
		int len = array.length;
		int temp;
		int counter = 1;

		for (int i = 0; i < len / 2; i++) {
			minPoint = i;
			maxPoint = i;
			for (int j = i + 1; j <= len - 1 - i; j++) { // 每完成一轮排序，就确定了两个最值，下一轮排序时比较范围减少两个元素
				if (array[j] < array[minPoint]) { // 如果待排数组中的某个元素比当前元素小，minPoint指向该元素的下标
					minPoint = j;
					continue;
				} else if (array[j] > array[maxPoint]) { // 如果待排数组中的某个元素比当前元素大，maxPoint指向该元素的下标
					maxPoint = j;
				}
			}
			if (minPoint != i) { // 如果发现了更小的元素，与第一个元素交换位置
				temp = array[i];
				array[i] = array[minPoint];
				array[minPoint] = temp;
				// 原来的第一个元素已经与下标为minPoint的元素交换了位置
				// 如果之前maxPoint指向的是第一个元素，那么需要将maxPoint重新指向array[minPoint]
				// 因为现在array[minPoint]存放的才是之前第一个元素中的数据
				if (maxPoint == i) {
					maxPoint = minPoint;
				}
			}
			if (maxPoint != len - 1 - i) { // 如果发现了更大的元素，与最后一个元素交换位置
				temp = array[len - 1 - i];
				array[len - 1 - i] = array[maxPoint];
				array[maxPoint] = temp;
			}
			System.out.print("第" + counter + "轮排序结果：");
			display();
			counter++;
		}
	}

	public static void main(String[] args) {
		int[] a = { 13, 5, 4, 11, 2, 20, 18, 15 };
		SelectionSort sort = new SelectionSort(a);
		sort.selectionSort();
	}

}

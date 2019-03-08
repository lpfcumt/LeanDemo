/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   InsertSort.java   
 * @Package com.lpfcumt.calculation   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月26日 上午10:53:48   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.calculation;

/**
 * @ClassName InsertSort
 * @Description TODO(插入排序)
 * @author lin.pf
 * @date 2019年2月26日 上午10:53:48
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class InsertSort extends BaseArray {

	private int[] array;

	public InsertSort(int[] array) {
		super(array);
	}

	// 插入排序
	public void insertionSort() {
		int len = array.length;
		int counter = 1;
		for (int i = 1; i < len; i++) {
			int temp = array[i]; // 存储待排序的元素值
			int insertPoint = i - 1; // 与待排序元素值作比较的元素的下标
			while (insertPoint >= 0 && array[insertPoint] > temp) { // 当前元素比待排序元素大
				array[insertPoint + 1] = array[insertPoint]; // 当前元素后移一位
				insertPoint--;
			}
			array[insertPoint + 1] = temp; // 找到了插入位置，插入待排序元素
			System.out.print("第" + counter + "轮排序结果：");
			display();
			counter++;
		}
	}

	// 二分插入排序
	public void BinaryInsertionSort() {
		int len = array.length;
		int counter = 1;
		int insertIndex;
		for (int i = 1; i < len; i++) {
			int temp = array[i]; // 存储待排序的元素值
			if (array[i - 1] > temp) { // 比有序数组的最后一个元素要小
				insertIndex = binarySearch(0, i - 1, temp); // 获取应插入位置的下标
				for (int j = i; j > insertIndex; j--) { // 将有序数组中，插入点之后的元素后移一位
					array[j] = array[j - 1];
				}
				array[insertIndex] = temp; // 插入待排序元素到正确的位置
			}
			System.out.print("第" + counter + "轮排序结果：");
			display();
			counter++;
		}
	}

	/**
	 * 二分查找法
	 * 
	 * @param lowerBound 查找段的最小下标
	 * @param upperBound 查找段的最大下标
	 * @param target 目标元素
	 * @return 目标元素应该插入位置的下标
	 */
	public int binarySearch(int lowerBound, int upperBound, int target) {
		int curIndex;
		while (lowerBound < upperBound) {
			curIndex = (lowerBound + upperBound) / 2;
			if (array[curIndex] > target) {
				upperBound = curIndex - 1;
			} else {
				lowerBound = curIndex + 1;
			}
		}
		return lowerBound;
	}

	// 2-路插入排序
	public void two_wayInsertionSort() {

		int len = array.length;
		int[] newArray = new int[len];
		newArray[0] = array[0]; // 将原数组的第一个元素作为枢纽元素
		int first = 0; // 指向最小元素的指针
		int last = 0; // 指向最大元素的指针

		for (int j = 0; j < newArray.length; j++) { // 打印初始化数组
			System.out.print(newArray[j] + "\t");
		}
		System.out.println();

		for (int i = 1; i < len; i++) {

			if (array[i] >= newArray[last]) { // 大于等于最大元素，直接插入到last后面，不用移动元素
				last++;
				newArray[last] = array[i];
			} else if (array[i] < newArray[first]) { // 小于最小元素，直接插到first前面，不用移动元素
				first = (first - 1 + len) % len;
				newArray[first] = array[i];
			} else if (array[i] >= newArray[0]) { // 在最大值与最小值之间，且大于等于枢纽元素，插入到last之前，需要移动元素
				int curIndex = last;
				last++;
				do { // 比array[i]大的元素后移一位
					newArray[curIndex + 1] = newArray[curIndex];
					curIndex--;
				} while (newArray[curIndex] > array[i]);

				newArray[curIndex + 1] = array[i]; // 插入到正确的位置
			} else { // 在最大值与最小值之间，且小于枢纽元素，插入到first之后，需要移动元素
				int curIndex = first;
				first = (first - 1 + len) % len;
				do { // 比array[i]小的元素前移一位
					newArray[curIndex - 1] = newArray[curIndex];
					curIndex = (curIndex + 1 + len) % len;
				} while (newArray[curIndex] <= array[i]);

				newArray[(curIndex - 1 + len) % len] = array[i]; // 插入到正确的位置
			}

			for (int j = 0; j < newArray.length; j++) { // 打印新数组中的元素
				System.out.print(newArray[j] + "\t");
			}
			System.out.println();

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

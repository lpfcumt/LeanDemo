/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   BubbleSort.java   
 * @Package com.lpfcumt.calculation   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月25日 下午4:57:51   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.calculation;

/**
 * @ClassName BubbleSort
 * @Description TODO(冒泡排序)
 * @author lin.pf
 * @date 2019年2月25日 下午4:57:51
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class BubbleSort extends BaseArray {
    private int[] array;

    public BubbleSort(int[] array) {
        super(array);
    }

    public void bubbleSort() {
        int temp;
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 1; j < len - i; j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.print("第" + (i + 1) + "次排序：");
            display();
        }
    }

    // 冒泡排序改进1 当第i轮没有发生数据交换，则表示已经排好序
    public void bubbleSort_improvement_1() {
        int temp;
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            boolean exchange = false; // 设置交换变量
            for (int j = 1; j < len - i; j++) {
                if (array[j - 1] > array[j]) { // 如果前一位大于后一位，交换位置
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    if (!exchange)
                        exchange = true; // 发生了交换操作
                }
            }
            System.out.print("第" + (i + 1) + "轮排序结果：");
            display();
            if (!exchange)
                break; // 如果上一轮没有发生交换数据，证明已经是有序的了，结束排序
        }
    }

    // 冒泡排序改进2 加入指针， 指针后面的数已经排好序
    public void bubbleSort_improvement_2() {
        int temp;
        int counter = 1;
        int endPoint = array.length - 1; // endPoint代表最后一个需要比较的元素下标
        while (endPoint > 0) {
            int pos = 1;
            for (int j = 1; j <= endPoint; j++) {
                if (array[j - 1] > array[j]) { // 如果前一位大于后一位，交换位置
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    pos = j; // 下标为j的元素与下标为j-1的元素发生了数据交换
                }
            }
            endPoint = pos - 1; // 下一轮排序时只对下标小于pos的元素排序，下标大于等于pos的元素已经排好
            System.out.print("第" + counter + "轮排序结果：");
            display();
        }
    }

    // 冒泡排序改进3 最大最小， 两头排序
    public void bubbleSort_improvement_3() {
        int temp;
        int low = 0;
        int high = array.length - 1;
        int counter = 1;
        while (low < high) {
            for (int i = low; i < high; ++i) { // 正向冒泡，确定最大值
                if (array[i] > array[i + 1]) { // 如果前一位大于后一位，交换位置
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            --high;

            for (int j = high; j > low; --j) { // 反向冒泡，确定最小值
                if (array[j] < array[j - 1]) { // 如果前一位大于后一位，交换位置
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            ++low;
            System.out.print("第" + counter + "轮排序结果：");
            display();
            counter++;
        }
    }

    public static void main(String[] args) {
        int[] a = { 13, 5, 4, 11, 2, 20, 18, 1 };
        BubbleSort sort = new BubbleSort(a);
        System.out.print("未排序时的结果：");
        sort.display();
        sort.bubbleSort_improvement_3();
    }
}

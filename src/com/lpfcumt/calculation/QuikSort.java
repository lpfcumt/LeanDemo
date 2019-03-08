/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   QuikSort.java   
 * @Package com.lpfcumt.calculation   
 * @Description    TODO(用一句话描述该文件做什么)   
 * @author  lin.pf     
 * @date    2019年2月26日 下午3:21:16   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.calculation;

/**
 * @ClassName QuikSort
 * @Description TODO(快速排序)
 * @author lin.pf
 * @date 2019年2月26日 下午3:21:16
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class QuikSort extends BaseArray {

    private int[] array;

    public QuikSort(int[] array) {
        super(array);
        this.array = array;
    }

    // 快速排序
    public void quikSort() {
        recursiveQuikSort(0, array.length - 1);
    }

    /**
     * 递归的快速排序
     * 
     * @param low 数组的最小下标
     * @param high 数组的最大下标
     */
    private void recursiveQuikSort(int low, int high) {
        if (low >= high) {
            return;
        } else {
            int pivot = array[low]; // 以第一个元素为基准
            int partition = partition(low, high, pivot); // 对数组进行划分，比pivot小的元素在低位段，比pivot大的元素在高位段
            display();
            recursiveQuikSort(low, partition - 1); // 对划分后的低位段进行快速排序
            recursiveQuikSort(partition + 1, high); // 对划分后的高位段进行快速排序
        }
    }

    /**
     * 以pivot为基准对下标low到high的数组进行划分
     * 
     * @param low 数组段的最小下标
     * @param high 数组段的最大下标
     * @param pivot 划分的基准元素
     * @return 划分完成后基准元素所在位置的下标
     */
    private int partition(int low, int high, int pivot) {
        while (low < high) {
            while (low < high && array[high] >= pivot) { // 从右端开始扫描，定位到第一个比pivot小的元素
                high--;
            }
            swap(low, high);
            while (low < high && array[low] <= pivot) { // 从左端开始扫描，定位到第一个比pivot大的元素
                low++;
            }
            swap(low, high);
        }
        return low;

    }

    /**
     * 交换数组中两个元素的数据
     * 
     * @param low 欲交换元素的低位下标
     * @param high 欲交换元素的高位下标
     */
    private void swap(int low, int high) {
        int temp = array[high];
        array[high] = array[low];
        array[low] = temp;
    }

    public static void main(String[] args) {
        int[] a = { 13, 5, 4, 11, 2, 20, 18, 15 };
        QuikSort sort = new QuikSort(a);
        sort.quikSort();
    }

}

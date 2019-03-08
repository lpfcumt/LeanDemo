package com.lpfcumt.datastructure;

/**
 * @ClassName MyArray
 * @Description TODO(一个简单的无序数组实现)
 * @author lin.pf
 * @date 2019年2月22日 上午11:03:45
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class MyArray {

	private Object[] tempArray;
	private int length;

	public MyArray(int max) {
		if (max < 0) {
			try {
				throw new Exception("数组容量小于零！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		tempArray = new Object[max];
	}

	/**
	 * @Title contains
	 * @Description TODO(检查数组中是否包含某个元素)
	 * @param target
	 * @return int
	 */
	public int contains(Object target) {
		int index = -1;
		if (target == null) {
			for (int i = 0; i < tempArray.length; i++) {
				if (tempArray[i] == target) {
					index = i;
					break;
				}
			}
		} else {
			for (int i = 0; i < tempArray.length; i++) {
				if (target.equals(tempArray[i])) {
					index = i;
					break;
				}
			}
		}
		return index;
	}

	/**
	 * @Title push @Description TODO(这里用一句话描述这个方法的作用) @param element @return void @throws
	 */
	public void push(Object element) {
		if (length >= tempArray.length) {
			try {
				throw new Exception("RangeOver!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			tempArray[length++] = element;
		}
	}

	public Object remove(Object object) {
		int index = contains(object);
		if (index != -1) {
			Object oldValue = tempArray[index];
			for (int i = index; i < tempArray.length - 1; i++) {
				tempArray[i] = tempArray[i + 1];
			}
			length--;
			return oldValue;
		} else {
			return false;
		}
	}

	public void dsplay() {
		for (int i = 0; i < tempArray.length; i++) {
			System.out.println(tempArray[i]);
		}
	}

	public static void main(String[] args) {
		MyArray array = new MyArray(2);
		array.push("aaa");
		array.push("bbb");
		array.dsplay();
	}

}

package com.kuibu.algorithm.sort;

import common.util.CommonUtil;

/**
 * 性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、稳定排序 4、原地排序
 * 过程简单描述：
 * 1、从数组第2个元素开始抽取元素。
 * <p>
 * 2、把它与左边第一个元素比较，如果左边第一个元素比它大，则继续与左边第二个元素比较下去，
 * 直到遇到不比它大的元素，然后插到这个元素的右边。
 * <p>
 * 3、继续选取第3，4，....n个元素,重复步骤 2 ，选择适当的位置插入。
 *
 * @ClassName InsertSort
 * <p>
 * InsertSort Description
 * @Date 2020/07/29
 * @Author chenguangjin
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = CommonUtil.generateRandomIntArr(20, 100);

        CommonUtil.printIntArr(arr);

        insertSort(arr);

        CommonUtil.printIntArr(arr);

    }

    public static void insertSort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                CommonUtil.swap(arr, j, j - 1);
            }
        }
    }
}

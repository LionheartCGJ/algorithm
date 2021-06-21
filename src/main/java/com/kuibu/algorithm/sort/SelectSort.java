package com.kuibu.algorithm.sort;

import common.util.CommonUtil;

/**
 * 选择排序性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、非稳定排序 4、原地排序
 *
 * 过程简单描述：
 * 首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置(如果第一个元素
 * 就是最小元素那么它就和自己交换)。其次，在剩下的元素中找到最小的元素，将它与数组的第
 * 二个元素交换位置。如此往复，直到将整个数组排序。这种方法我们称之为选择排序。
 *
 * @ClassName SelectSort
 * <p>
 * SelectSort Description
 * @Date 2020/07/29
 * @Author chenguangjin
 */
public class SelectSort {

    public static void main(String[] args) {
        // int[] arr = CommonUtil.generateRandomLengthIntArr(10, 100);
        int[] arr = CommonUtil.generateRandomIntArr(5, 100);

        CommonUtil.printIntArr(arr);

        selectSort(arr);

        CommonUtil.printIntArr(arr);
    }

    public static void selectSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            CommonUtil.swap(arr, i, minIndex);
        }
    }
}

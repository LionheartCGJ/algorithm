package com.kuibu.algorithm.sort;

import common.util.CommonUtil;

/**
 * 冒泡排序性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、稳定排序 4、原地排序
 *
 * 过程描述:
 * 把第一个元素与第二个元素比较，如果第一个比第二个大，则交换他们的位置。接着继续比较第二个与第三个元素，
 * 如果第二个比第三个大，则交换他们的位置....
 *
 * 我们对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样一趟比较交换下来之后，
 * 排在最右的元素就会是最大的数。
 *
 * 除去最右的元素，我们对剩余的元素做同样的工作，如此重复下去，直到排序完成。
 *
 * @ClassName BubbleSort
 *
 * BubbleSort Description
 * @Date 2020/07/29
 * @Author chenguangjin
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = CommonUtil.generateRandomIntArr(20, 100);

        CommonUtil.printIntArr(arr);

        bubbleSort(arr);

        CommonUtil.printIntArr(arr);
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            // 如果某次冒泡的过程中,没有发生未知交互,说明数组已经有序
            boolean hasChange = false;

            // 冒泡排序时相邻元素比较
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    CommonUtil.swap(arr, j, j + 1);

                    hasChange = true;
                }
            }

            if (!hasChange) {
                return;
            }
        }
    }
}

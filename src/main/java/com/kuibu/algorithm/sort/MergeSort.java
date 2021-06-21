package com.kuibu.algorithm.sort;

import common.util.CommonUtil;

/**
 * 性质：1、时间复杂度：O(nlog2n) 2、空间复杂度：O(n) 3、稳定排序 n4、原地排序
 *
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 *
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * @Classname MergeSort
 * @Description MergeSort
 * @Date 2021/2/25
 * @Created by chenguangjin
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = CommonUtil.generateRandomIntArr(10, 100);

        // int[] arr = new int[] {50, 17, 2, 43, 1, 25, 94, 95, 53, 66};

        CommonUtil.printIntArr(arr);

        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);

        CommonUtil.printIntArr(arr);
    }

    public static void mergeSort(int[] arr, int head, int tail, int[] temp) {
        if (head >= tail) {
            return;
        }

        int mid = (head + tail) / 2;

        mergeSort(arr, head, mid, temp);
        mergeSort(arr, mid + 1, tail, temp);

        merge(arr, head, mid, tail, temp);
    }

    private static void merge(int[] arr, int head, int mid, int tail, int[] temp) {
        int tempIndex = head;
        int left = head;
        int right = mid + 1;

        while (left <= mid && right <= tail) {
            if (arr[left] > arr[right]) {
                temp[tempIndex++] = arr[right++];
            } else {
                temp[tempIndex++] = arr[left++];
            }
        }

        while (left <= mid) {
            temp[tempIndex++] = arr[left++];
        }

        while (right <= tail) {
            temp[tempIndex++] = arr[right++];
        }

        tempIndex = head;
        while (head <= tail) {
            arr[head++] = temp[tempIndex++];
        }
    }
}

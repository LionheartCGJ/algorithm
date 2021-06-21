package com.kuibu.algorithm.find.test;

import common.util.CommonUtil;

/**
 * @Classname TestDemo
 * @Description TestDemo
 * @Date 2021/6/7
 * @Created by chenguangjin
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = CommonUtil.generateRandomIntArr(20, 100);
        CommonUtil.printIntArr(arr);

        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);

        CommonUtil.printIntArr(arr);
    }

    public static void mergeSort(int[] arr, int head, int tail, int[] temp) {
        if(head >= tail) {
            return;
        }

        int mid = (head + tail) / 2;

        mergeSort(arr, head, mid, temp);
        mergeSort(arr, mid + 1, tail, temp);

        merge(arr, head, mid, tail, temp);
    }

    private static void merge(int[] arr, int head, int mid, int tail, int[] temp) {
        int tempIdx = head;
        int left = head;
        int right = mid + 1;

        while(left <= mid && right <= tail) {
            if(arr[left] < arr[right]) {
                temp[tempIdx++] = arr[left++];
            } else {
                temp[tempIdx++] = arr[right++];
            }
        }

        while(left <= mid) {
            temp[tempIdx++] = arr[left++];
        }

        while (right <= tail) {
            temp[tempIdx++] = arr[right++];
        }

        tempIdx = head;
        while (head <= tail) {
            arr[head++] = temp[tempIdx++];
        }
    }
}

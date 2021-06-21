package com.kuibu.algorithm.sort.test;

import common.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname TestDemo2
 * @Description TestDemo2
 * @Date 2021/6/3
 * @Created by chenguangjin
 */
public class TestDemo2 {

    public static void main(String[] args) {
        // int[] arr = CommonUtil.generateRandomIntArr(10, 100);

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,100,200,300, 600, 500};

        System.out.println(findKth(arr, arr.length, 3));

    }

    public static int findKth(int[] a, int n, int K) {
        int[] heap = new int[K];


        for (int i = 0; i < K; i++) {
            heap[i] = a[i];
        }

        // 调整大顶堆
        for(int i = heap.length / 2; i >= 0; i--) {
            heapAdjust(heap, i, K);
        }

        // 遍历剩余元素
        for(int i = K; i < a.length; i++) {
            if(a[i] > heap[0]) {
                heap[0] = a[i];


                heapAdjust(heap, 0, K);
            }
        }

        return heap[0];
    }

    private static void heapAdjust(int[] arr, int father, int length) {
        int fatherValue = arr[father];

        while(leftChild(father) < length) {
            int child = leftChild(father);

            if(child + 1 < length && arr[child] > arr[child + 1]) {
                child++;
            }

            if(fatherValue > arr[child]) {
                arr[father] = arr[child];
            } else {
                break;
            }

            father = child;
        }

        arr[father] = fatherValue;
    }

    private static int leftChild(int father) {
        return father * 2 + 1;
    }
}

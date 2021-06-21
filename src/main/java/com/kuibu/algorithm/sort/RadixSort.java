package com.kuibu.algorithm.sort;

import common.util.CommonUtil;

import java.util.Arrays;

/**
 * 性质：1、时间复杂度：O(n*k) 2、空间复杂度：O(n+k) 3、稳定排序
 *
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
 *
 * 算法描述
 * 取得数组中的最大数，并取得位数；
 * arr为原始数组，从最低位开始取每个位组成radix数组；
 * 对radix进行计数排序（利用计数排序适用于小范围数的特点）
 *
 * @Classname RadixSort
 * @Description RadixSort
 * @Date 2021/3/5
 * @Created by chenguangjin
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = CommonUtil.generateRandomIntArr(30, 100);

        CommonUtil.printIntArr(arr);

        radixSort(arr);

        CommonUtil.printIntArr(arr);
    }

    public static void radixSort(int[] arr) {
        int maxDigit = getMaxDigit(arr);

        int dev = 1;
        for(int i = 0; i < maxDigit; i++, dev *= 10) {
            int[][] counter = new int[19][0];

            for(int current : arr) {
                int bucket = (current / dev) % 10 + 9;
                counter[bucket] = arrAppend(counter[bucket], current);
            }

            int index = 0;
            for(int[] bucket : counter) {
                for(int current : bucket) {
                    arr[index++] = current;
                }
            }
        }
    }

    private static int getMaxDigit(int[] arr) {
        int max = arr[0];
        for(int current : arr) {
            if(current > max) {
                max = current;
            }
        }

        int digit = 0;
        while (max != 0) {
            max /= 10;
            digit++;
        }
        return digit;
    }


    private static int[] arrAppend(int[] arr, int current) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = current;
        return arr;
    }
}

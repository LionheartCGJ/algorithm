package com.kuibu.algorithm.sort;

import common.util.CommonUtil;

/**
 * 选择排序性质：1、时间复杂度：最坏O(n2)平均O(n1.3) 2、空间复杂度：O(1) 3、非稳定排序 4、原地排序
 * <p>
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度
 *
 * @Classname ShellSort
 * @Description ShellSort
 * @Date 2021/2/24
 * @Created by chenguangjin
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = CommonUtil.generateRandomIntArr(20, 100);

        CommonUtil.printIntArr(arr);

        shellSort(arr);

        CommonUtil.printIntArr(arr);
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int length = arr.length;

        for (int gap = length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < length; i++) {

                int current = arr[i];
                int j = i;

                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
    }
}

package com.kuibu.algorithm.sort;

import common.util.CommonUtil;

/**
 * 性质 ：1、时间复杂度：O(n + k) 2、空间复杂度：O(n + k) 3、稳定排序?
 * <p>
 * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * <p>
 * 算法描述
 * 找出待排序的数组中最大和最小的元素；
 * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 *
 * @Classname CountingSort
 * @Description CountingSort
 * @Date 2021/3/2
 * @Created by chenguangjin
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = CommonUtil.generateRandomIntArr(10, 1000);

        CommonUtil.printIntArr(arr);

        countingSort(arr);

        CommonUtil.printIntArr(arr);
    }

    private static void countingSort(int[] arr) {
        int maxValue = getMaxValue(arr);

        int[] bucket = new int[maxValue + 1];

        for (int current : arr) {
            bucket[current]++;
        }

        int index = 0;
        for (int i = 0; i <= maxValue; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
    }

    private static int getMaxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int current : arr) {
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
}

package com.kuibu.algorithm.sort;

import common.util.CommonUtil;

/**
 * 性质：1、时间复杂度：O(nlogn) 2、空间复杂度：O(logn) 3、非稳定排序 4、原地排序
 *
 * 过程描述:
 * 我们从数组中选择一个元素，我们把这个元素称之为中轴元素吧，然后把数组中所有小于中轴元素的元素放在其左边，
 * 所有大于或等于中轴元素的元素放在其右边，显然，此时中轴元素所处的位置的是有序的。
 * 也就是说，我们无需再移动中轴元素的位置。
 *
 * 从中轴元素那里开始把大的数组切割成两个小的数组(两个数组都不包含中轴元素)，接着我们通过递归的方式，
 * 让中轴元素左边的数组和右边的数组也重复同样的操作，直到数组的大小为1，此时每个元素都处于有序的位置。
 * @ClassName QuickSort
 * <p>
 * QuickSort Description
 * @Date 2020/07/28
 * @Author chenguangjin
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = CommonUtil.generateRandomIntArr(20, 100);


        // int[] arr = new int[]{3, 5, 2, 1, 4, 99, 1, 23, 34, 68, 79};

        CommonUtil.printIntArr(arr);

        quickSort(arr, 0, arr.length - 1);

        CommonUtil.printIntArr(arr);
    }

    /**
     * 递归实现快速排序
     *
     * @param arr
     * @param head
     * @param tail
     */
    private static void quickSort(int[] arr, int head, int tail) {
        if (head >= tail) {
            return;
        }

        int pivot = partition(arr, head, tail);

        quickSort(arr, head, pivot - 1);
        quickSort(arr, pivot + 1, tail);

    }

    /**
     * 分区函数, 返回pivot, pivot左侧的元素都小于pivotValue, 右侧的元素都大于pivotValue
     * pivot 默认从头部获取, 可以进行优化, 采用3数取中或者9数取中,
     * pivotValue的值接近中位数有助于提升性能,减少递归深度
     *
     * @param arr
     * @param head
     * @param tail
     * @return pivot
     */
    private static int partition(int[] arr, int head, int tail) {
        int pivotValue = arr[head];

        int left = head;
        int right = tail;

        while (left < right) {
            while (left < right && pivotValue <= arr[right]) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && pivotValue >= arr[left]) {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = pivotValue;

        return left;
    }
}

package com.kuibu.algorithm.sort;

import common.util.CommonUtil;

import java.util.Arrays;

/**
 * 性质 ：1、时间复杂度：O(n+k) O(n^2) O(n) 2、空间复杂度：O(n+k) 3、稳定排序?
 *
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。为了使桶排序更加高效，我们需要做到这两点：
 *
 * 在额外空间充足的情况下，尽量增大桶的数量
 * 使用的映射函数能够将输入的 N 个数据均匀的分配到 K 个桶中
 * 同时，对于桶中元素的排序，选择何种比较排序算法对于性能的影响至关重要。
 *
 * 1. 什么时候最快
 * 当输入的数据可以均匀的分配到每一个桶中。
 *
 * 2. 什么时候最慢
 * 当输入的数据被分配到了同一个桶中。
 *
 * @Classname BucketSort
 * @Description BucketSort
 * @Date 2021/3/3
 * @Created by chenguangjin
 */
public class BucketSort {
    public static final int DEFAULT_BUCKET_SIZE = 5;

    public static void main(String[] args) {
        int[] arr = CommonUtil.generateRandomIntArr(10, 100);

        CommonUtil.printIntArr(arr);

        bucketSort(arr);

        CommonUtil.printIntArr(arr);
    }

    public static void bucketSort(int[] arr) {
        int maxValue = arr[0];
        int minValue = arr[0];

        for(int current : arr) {
            if(current > maxValue) {
                maxValue = current;
            } else if(current < minValue) {
                minValue = current;
            }
        }

        int bucketCount = (maxValue - minValue) / DEFAULT_BUCKET_SIZE + 1;

        int[][] buckets = new int[bucketCount][0];

        // 将数据分配到桶中
        for(int current : arr) {
            int index = (current - minValue) / DEFAULT_BUCKET_SIZE;

            buckets[index] = arrAppend(buckets[index], current);
        }

        int index = 0;
        for(int[] bucket : buckets) {
            // 对每个桶进行排序， 选择插入排序
            InsertSort.insertSort(bucket);

            // 将桶中数据放回数组
            for (int current : bucket) {
                arr[index++] = current;
            }

        }
    }

    private static int[] arrAppend(int[] arr, int current) {
        arr = Arrays.copyOf(arr, arr.length + 1);

        arr[arr.length - 1] = current;

        return arr;
    }
}

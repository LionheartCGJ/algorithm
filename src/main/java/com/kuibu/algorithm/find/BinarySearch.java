package com.kuibu.algorithm.find;

/**
 * @ClassName BinarySearch
 *
 * <p>
 * BinarySearch Description
 * @Date 2020/07/28
 * @Author chenguangjin
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[] {3};

        System.out.println(find(arr, 3, 0, arr.length - 1));
    }



    public static int find(int[] arr, int x, int start, int end) {
        if(arr == null || arr.length == 0) {
            return -1;
        }

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if(x == arr[mid]) {
            return mid;
        }

        if (x > arr[mid]) {
            start = mid + 1;
        }

        if (x < arr[mid]) {
            end = mid - 1;
        }

        return find(arr, x, start, end);
    }

}

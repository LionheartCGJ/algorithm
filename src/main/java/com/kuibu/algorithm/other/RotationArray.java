package com.kuibu.algorithm.other;

import common.util.CommonUtil;

/**
 * 描述
 * 一个数组A中存有N（N&gt0）个整数，在不允许使用另外数组的前提下，将每个整数循环向右移M（M>=0）个位置，
 * 即将A中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）（最后M个数循环移至最前面的M个位置）。
 * 如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 */
public class RotationArray {

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        CommonUtil.printIntArr(solve(a.length, 5, a));
    }

    public static int[] solve(int n, int m, int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        if (m >= n) {
            m = m % n;
        }
        if (m == 0) {
            return a;
        }
        int right = n - m - 1;


        while (right >= m - 1) {
            for (int i = 0; i < m; i++) {
                swap(a, right, right + m);
                right--;
            }
        }
        while (right >= 0) {
            for (int i = right; i < right + m; i++) {
                swap(a, i, i + 1);
            }
            right--;
        }
        return a;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

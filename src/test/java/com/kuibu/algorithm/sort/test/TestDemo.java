package com.kuibu.algorithm.sort.test;

import common.util.CommonUtil;

public class TestDemo {
    public static void main(String[] args) {
//        int[] arr = CommonUtil.generateRandomIntArr(20, 100);
//        CommonUtil.printIntArr(arr);
//
//        quickSort(arr, 0, arr.length - 1);
//
//        CommonUtil.printIntArr(arr);

        System.out.println(sqrt(2, 5));

    }


    public static double sqrt(int n, int m) {
        if(n < 0) {
            return Double.NaN;
        }

        if(n <= 1) {
            return n;
        }

        double delta = getDelta(m);

        double mid = n / 2d;
        double up = n;
        double low = 0d;
        double product = mid * mid;

        while(Math.abs(product - n) > delta) {
            if(product > n) {
                up = mid;
            } else if( product < n) {
                low = mid;
            }

            mid = (up + low) / 2d;

            product = mid * mid;
        }

        return mid;

    }

    private static double getDelta(int m) {
        double delta = 1d;

        for(int i = 0; i < m; i++) {
            delta = delta / 10d;
        }

        return delta;
    }
}
package com.kuibu.algorithm.sort.test;

import common.util.CommonUtil;

public class TestDemo {


    public int[] merger (int[] arr1, int[] arr2) {
        if(arr1 == null) {
            return arr2;
        }

        if(arr2 == null) {
            return arr1;
        }

        int[] res = new int[arr1.length + arr2.length];

        int idx1 = 0;
        int idx2 = 0;
        int resIdx = 0;

        while (idx1 < arr1.length && idx2 < arr2.length) {
            if(arr1[idx1] < arr2[idx2]) {
                res[resIdx++] = arr1[idx1++];
            } else {
                res[resIdx++] = arr2[idx2++];
            }
        }

        while (idx1 < arr1.length) {
            res[resIdx++] = arr1[idx1++];
        }

        while (idx2 < arr2.length) {
            res[resIdx++] = arr2[idx2++];
        }

        return res;
    }

}
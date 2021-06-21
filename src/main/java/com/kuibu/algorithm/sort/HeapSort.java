package com.kuibu.algorithm.sort;

import common.util.CommonUtil;

/**
 * 性质：1、时间复杂度：O(nlog2n) 2、空间复杂度：O(1) 3、非稳定排序
 * <p>
 * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 *
 * @Classname HeapSort
 * @Description HeapSort
 * @Date 2021/3/1
 * @Created by chenguangjin
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = CommonUtil.generateRandomIntArr(10, 100);

        // int[] arr = new int[]{93, 2, 38, 62, 93, 26, 66, 74, 77, 46};

        CommonUtil.printIntArr(arr);

        heapSort(arr);

        CommonUtil.printIntArr(arr);

    }

    /**
     * 堆排序
     */
    private static void heapSort(int[] arr) {
        // 将待排序的数组构建成一个大顶堆
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            CommonUtil.swap(arr, 0, i);
            // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
            heapAdjust(arr, 0, i);
        }
    }

    /**
     * 构建堆的过程
     *
     * @param arr    需要排序的数组
     * @param father 需要构建堆的根节点的序号
     * @param length 数组的长度
     */
    private static void heapAdjust(int[] arr, int father, int length) {
        int fatherValue = arr[father];

        while (leftChild(father) < length) {
            int child = leftChild(father);

            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                // 序号增1，指向右子树
                child++;
            }

            // 如果父节点小于孩子结点，则需要交换
            if (fatherValue < arr[child]) {
                arr[father] = arr[child];
            } else {
                // 大顶堆结构未被破坏，不需要调整
                break;
            }

            // 循环判断孩子节点
            father = child;
        }
        // 确定根节点正确位置后赋值
        arr[father] = fatherValue;
    }

    /**
     * 获取左孩子节点
     *
     * @param father
     * @return leftChild
     */
    private static int leftChild(int father) {
        return father * 2 + 1;
    }
}

package common.util;

import java.util.Random;

/**
 * @ClassName CommonUtil
 * <p>
 * CommonUtil Description
 * @Date 2020/07/29
 * @Author chenguangjin
 */
public class CommonUtil {
    /**
     * 打印 int 数组
     * @param arr
     */
    public static void printIntArr(int[] arr) {
        if (arr == null) {
            System.out.println("null");
        }

        if (arr.length < 1) {
            System.out.println("[]");
        }

        System.out.print("[");

        System.out.print(arr[0]);

        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                System.out.print(", " + arr[i]);
            }
        }

        System.out.println("]");
    }


    /**
     * 随机生成int数组
     *
     * @param length
     * @param max
     * @return arr
     */
    public static int[] generateRandomIntArr(int length, int max) {
        int[] arr = new int[length];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(max);
        }

        return arr;
     }

    /**
     * 生成随机长度的随机数组
     *
     * @param lengthMax
     * @param max
     * @return arr
     */
    public static int[] generateRandomLengthIntArr(int lengthMax, int max) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(lengthMax)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(max);
        }

        return arr;
    }

    /**
     * 交换数组中两个元素的位置
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

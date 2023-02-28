package org.hthu.array;

import java.util.Arrays;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2023/2/28
 */
public class MergeTwoArray {

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3, 5, 7, 9, 0, 0, 0};

        int[] num2 = new int[]{2, 4, 6};

        mergeArrayByDoublePoint(num1, num2, 5, 3);

        System.out.println(Arrays.toString(num1));

    }

    /**
     * 逆向双指针，原地合并
     * @param num1
     * @param num2
     * @param m
     * @param n
     */
    public static void mergeArrayByDoublePoint(int[] num1, int[] num2, int m, int n) {
        // 数组长度 num1.length
        int k = num1.length - 1;
        int p = m - 1;
        int q = n - 1;
        while (p >= 0 && q >= 0) {
            if (num1[p] <= num2[q]) {
                num1[k] = num2[q];
                k--;
                q--;
            } else {
                num1[k] = num1[p];
                k--;
                p--;
            }
        }

        // 校验短数组是否还余下元素，余下元素全部放到num1数组前部
        while (q > 0) {
            num1[k] = num2[q];
            k--;
            q--;
        }
    }
}

package org.hthu.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 12, 23};
        optimizeSort(a);
        System.out.println(Arrays.toString(a));
    }

    // 改1 是否继续比较标志
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    flag = true;
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    // 改2,增加比较边界,和是否继续比较标志
    public static void optimizeSort(int[] a) {
        int temp = 0;
        int sortBorder = a.length - 1;
        int lastIndex = 0;
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    flag = true;
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    lastIndex = j; // 记录下最后一次交换元素位置,下次交换仅仅比较到这里即停止
                }
            }
            sortBorder = lastIndex;
            if (flag) {
                break;

            }
        }
    }

}

package org.hthu.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 12, 23};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    // 改1
    public static void sort(int[] a){
        boolean flag = false;
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length-i-1;j++){
                if (a[j]>a[j+1]){
                    flag = true;
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
            if (flag){
                break;
            }
        }
    }
}

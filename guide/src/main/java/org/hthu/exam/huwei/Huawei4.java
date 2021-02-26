package org.hthu.exam.huwei;

import java.util.Arrays;
import java.util.Scanner;

public class Huawei4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cpuAndWork = scanner.nextLine().split(" ");
        String[] time = scanner.nextLine().split(" ");
        String cpuNum = cpuAndWork[0]; // cpu个数
        String workNum = cpuAndWork[1]; // 作业数
        // 对time排序
        int[] m = stringArrayToInt(time);//字符串数组变成int数组
        sortIntArray(m);//对int数组进行排序
        System.out.println(Arrays.toString(m));

    }

    public static int[] stringArrayToInt(String[] arr1) {
        int[] arr2 = new int[arr1.length];
        for(int i = 0;i<arr1.length;i++){
            arr2[i] = Integer.parseInt(arr1[i]);
        }
        return arr2;
    }

    public static void sortIntArray(int[] m) {
        Arrays.sort(m);
    }
}

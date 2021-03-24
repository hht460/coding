package org.hthu.exam.huwei;

import java.lang.reflect.Array;
import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        String str1 = "11 23 -32 88 0 -228 99 29 560 33" ;
        System.out.println(str1);
        str1 = stringToIntSort(str1);
        System.out.println(str1);
    }
    private static String stringToIntSort(String str1) {
        String[] arr1 =stringToArray(str1);//字符串变成字符串数组
        int[] m = stringArrayToInt(arr1);//字符串数组变成int数组
        sortIntArray(m);//对int数组进行排序
        String str2 = intArrayToString(m);//将int数组变成字符串
        return str2;
    }
    public static String intArrayToString(int[] m) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<m.length;i++){
            if(i!=m.length)
                sb.append(m[i]+" ");
            else
                sb.append(m[i]);
        }
        return sb.toString();
    }
    public static void sortIntArray(int[] m) {
        Arrays.sort(m);
    }
    public static int[] stringArrayToInt(String[] arr1) {
        int[] arr2 = new int[arr1.length];
        for(int i = 0;i<arr1.length;i++){
            arr2[i] = Integer.parseInt(arr1[i]);
        }
        return arr2;
    }
    public static String[] stringToArray(String str1) {
        return str1.split(" ");
    }
}


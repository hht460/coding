package org.hthu.test;

public class Solution1 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Start = 0;
        int num2Start = 0;
        int numStart = 0;
        int[] nums = new int[m + n];
        
        while (num2Start < n && num1Start < m) {
            if (nums2[num2Start] < nums1[num1Start]) {
                nums[numStart] = nums2[num2Start++];
                numStart++;
                num2Start++;
            } else {
                nums[numStart] = nums1[num1Start];
                numStart++;
                num1Start++;
            }
        }
        //检验数组元素是否都放入新数组中
        while (num1Start < m) {
            nums[numStart] = nums1[num1Start];
            numStart++;
            num1Start++;
        }
        while (num2Start < n) {
            nums[numStart++] = nums2[num2Start++];
            numStart++;
            num2Start++;
        }

        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
    }
}

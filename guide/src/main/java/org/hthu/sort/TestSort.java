package org.hthu.sort;

import java.util.Arrays;

public class TestSort {

    public static void main(String[] args) {
        int[] a = new int[]{344,123,34,1,434,432,5,134,64,3};
        QuickSortLearn quickSortLearn = new QuickSortLearn();
        quickSortLearn.quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}

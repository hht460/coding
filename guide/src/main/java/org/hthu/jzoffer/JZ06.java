package org.hthu.jzoffer;

public class JZ06 {
    public static int minNumberInRotateArray(int [] array) {
        int low = 0;
        int len = array.length;
        int hight = len-1;

        if(len == 0){
            return 0;
        }

        if (len==1){
            return array[0];
        }

        // 选取最右端数据为假定目标值
        while(low < hight){
            int mid = low + (hight-low)/2; // (hight + low)/2
            if(array[mid] < array[hight]){
                hight = mid;
            }else if(array[mid] > array[hight]){
                low = mid+1;
            }else{
                hight--;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,1,2};
        System.out.println(minNumberInRotateArray(a));
    }
}

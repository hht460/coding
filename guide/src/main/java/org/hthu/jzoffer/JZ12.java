package org.hthu.jzoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class JZ12 {

    public int[] reOrderArray (int[] array) {
        int len = array.length;
        if(len<=1){
            return array;
        }
        Queue<Integer> odd = new LinkedList<>();
        Queue<Integer> even = new LinkedList<>();
        for(int i=0;i<len;i++){
            if(array[i] % 2 !=0){
                odd.offer(array[i]);
            }else{
                even.offer(array[i]);
            }
        }
        for(int i=0;i<len;i++){
            if(!odd.isEmpty()){
                array[i] = odd.poll();
            }else{
                array[i] = even.poll();
            }
        }
        return array;
    }
}

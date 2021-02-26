package org.hthu.exam.huwei;

import java.util.Scanner;
import java.util.TreeSet;

public class Huawei2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            TreeSet<Integer> set=new TreeSet<Integer>();
            // 接收数组长度和数组数据
            int n=sc.nextInt();
            if(n>0){
                for(int i=0;i<n;i++){
                    set.add(sc.nextInt());
                }
            }
            // 打印
            for(Integer i:set){
                System.out.println(i);
            }
        }
    }
}

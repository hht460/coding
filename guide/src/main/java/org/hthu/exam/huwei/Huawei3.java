package org.hthu.exam.huwei;

import java.util.Scanner;

public class Huawei3 {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            System.out.println(Integer.decode(str));
        }
    }
}

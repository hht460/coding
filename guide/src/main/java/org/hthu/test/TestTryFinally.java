package org.hthu.test;

import java.util.Scanner;

public class TestTryFinally {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        String ss = scanner.nextLine();
        System.out.println(ss);

        System.out.println(f(2));
    }
    public static int f(int v){
        try {
            return v * v;
        }finally {
            if (v == 2){
                return 0;
            }
        }
    }

}

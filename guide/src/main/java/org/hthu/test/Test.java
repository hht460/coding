package org.hthu.test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "abababab";
        String[] split = s.split(s.substring(0, 2));
        System.out.println(Arrays.toString(split));
    }
}

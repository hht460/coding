package org.hthu;

public class Test {
    public static int getValue() {
        int i = 1;
        try {
            i++;
            return i;
        } finally {
            i++;
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        int j = getValue();
        System.out.println(j);
    }
}

package org.hthu.test;

import java.util.concurrent.TimeUnit;

public class Solution2 {

        private static Integer COUNT = 1;
        private static Integer FLAG = 0;
        private static Object lock = new Object();

        public static void main(String[] args) {
            new Thread(() -> {
                while (true) {
                    synchronized (lock){
                        if (FLAG == 0) {
                            System.out.print("X ");
                            FLAG = 1;
                        }
                    }
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    synchronized (lock){
                        if (FLAG == 1) {
                            System.out.print("Y ");
                            FLAG = 2;
                        }
                    }
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    synchronized (lock){
                        if (FLAG == 2) {
                            System.out.println("Z ");
                            COUNT++;
                            if(COUNT == 10){
                                System.exit(0);
                            }
                            FLAG = 0;
                        }
                    }
                }
            }).start();
        }






}


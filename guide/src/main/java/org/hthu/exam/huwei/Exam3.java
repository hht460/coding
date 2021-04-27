package org.hthu.exam.huwei;

import java.util.Arrays;
import java.util.Scanner;

public class Exam3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(); // 行
        int n = in.nextInt(); // 列
        if (m == 1 && n == 1) {
            System.out.println(1);
        }
        // 生成全量数据
        int total = m * n;
        int[] data = new int[total];
        int i = 0;
        int j = 1;
        while (i < total) {
            data[i] = j;
            if ((i + 1) >= total) {
                break;
            }
            data[i + 1] = j;
            j++;
            i = i + 2;

        }
        System.out.println(Arrays.toString(data));

        int lie = total / n;
        for (int hh = 0; hh < lie; hh++) {
            System.out.println(data[hh] + data[data.length - lie + hh]);
        }
    }

}

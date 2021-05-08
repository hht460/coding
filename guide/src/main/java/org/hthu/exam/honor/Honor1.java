package org.hthu.exam.honor;

import java.util.Scanner;

public class Honor1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        String Ns = strings[0];
        String Ms = strings[1];
        int N = Integer.valueOf(Ns);
        int M = Integer.valueOf(Ms);
        if (N < M) {
            System.out.println(0);
        }
        else if (N == M) {
            System.out.println(1);
        }else {
            String[] str = new String[N + 1];
            int total = 0;
            String pat = String.valueOf(M);
            for (int i = 1; i <= N; i++) {
                String cur = String.valueOf(i);
                String temp = cur.replaceAll(pat,"");
                int ll = cur.length() - temp.length();
                total += ll;
            }
            System.out.println(total);
        }
    }
}

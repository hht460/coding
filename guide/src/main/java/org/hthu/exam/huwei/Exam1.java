package org.hthu.exam.huwei;

import java.util.Arrays;
import java.util.Scanner;

public class Exam1 {

    static class Base implements Comparable<Base> {
        int mCost;
        int nPrice;
        Base(int m, int n) {
            this.mCost = m;
            this.nPrice = n;
        }
        @Override
        public int compareTo(Base oBase) {
            if(mCost > oBase.mCost) {
                return 1;
            }
            if(mCost < oBase.mCost) {
                return -1;
            }
            if(nPrice > oBase.nPrice) {
                return -1;
            }
            if(nPrice < oBase.nPrice) {
                return 1;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] mm = scanner.nextLine().split(",");
        String[] nn = scanner.nextLine().split(",");
        int k = scanner.nextInt();
        Base[] base = new Base[mm.length];
        for (int i = 0; i < base.length; i++) {
            base[i] = new Base(Integer.parseInt(mm[i]), Integer.parseInt(nn[i]));
        }
        mm = null;
        nn = null;
        Arrays.sort(base);
        for (int i = 0; i < base.length; i++) {
            if (k >= base[i].mCost && base[i].nPrice > base[i].mCost) {
                k += (base[i].nPrice - base[i].mCost);
            }
        }
        System.out.print(k);
        scanner.close();
    }
}

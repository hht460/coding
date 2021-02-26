package org.hthu.exam.huwei;

import java.util.Scanner;

/**
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
 * 方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
 * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
 * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 */
public class ThreeBottlesWater {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("0")) {

            String s = scanner.nextLine();
            int temp = Integer.parseInt(s);
            if (Integer.parseInt(s) == 0) {
                return;
            }
            int result = 0;
            while (temp > 0) {
                result += temp / 3;
                if (temp / 3 == 0) {
                    if (temp == 2) {
                        result++;
                        System.out.println(result);
                        //return;
                        break;
                    } else if (temp == 1 || temp == 0) {
                        System.out.println(result);
                        //return;
                        break;
                    }
                }
                int y = temp % 3;
                temp = temp / 3 + y;
            }
        }
    }
}

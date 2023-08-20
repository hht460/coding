package org.hthu.test;

import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) throws InterruptedException {

//        System.out.println(tt());


        int i1 = 20;

        System.out.println(0 % i1);

        System.out.println(20 % i1);

        System.out.println(40 % i1);

        System.out.println(60 % i1);

        System.out.println(80 % i1);
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("4.2").append("/").append("5.6").append("/");
//        System.out.println(stringBuilder.toString());
//
//        String str = stringBuilder.toString();
//        String substring = str.substring(0, str.length() - 1);
//
//
//
//        List<Double> collect = new ArrayList<>();
//        collect.add(6.8d);
//        collect.add(4.8d);
//        collect.add(5.8d);
//        System.out.println(collect);
//
//        List<Double> sortedLens = collect.stream().sorted().collect(Collectors.toList());
//
//        System.out.println(sortedLens);
//        long times = 1663776000000L;
//        Date date = new Date(times);
//        System.out.println("date格式："+date);
//
//        double a = 8.7;
//        BigDecimal bigDecimal = BigDecimal.valueOf(a);
//        System.out.println(bigDecimal.multiply(BigDecimal.valueOf(100)));
//
//        System.out.println(800/100);
//
//        System.out.println(StringUtils.isBlank(" "));
//
//        System.out.println(new Date(1665889459000L));
    }

    public static int tt() {
        int i = 1;
        try {
            System.out.println(12 / 0);
            return i;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("asa");
            i = i + 1;
        }
        return i;
    }
    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}

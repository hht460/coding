package org.hthu.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Test {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) throws InterruptedException {

        long times = 1663776000000L;
        Date date = new Date(times);
        System.out.println("date格式："+date);

        double a = 8.7;
        BigDecimal bigDecimal = BigDecimal.valueOf(a);
        System.out.println(bigDecimal.multiply(BigDecimal.valueOf(100)));

        System.out.println(800/100);

        System.out.println(StringUtils.isBlank(" "));

        System.out.println(new Date(1665889459000L));
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

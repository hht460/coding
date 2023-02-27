package org.hthu.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/11/5
 * 加减乘除运算
 */
public class NumberUtil {

    public static void main(String[] args) {

//        double div1 = cn.hutool.core.util.NumberUtil.div(2, 0.7);
//        double div2 = cn.hutool.core.util.NumberUtil.div(2, 0.7, 1, RoundingMode.HALF_UP);
//
//        double mul1 = cn.hutool.core.util.NumberUtil.mul(12, 0.232);
//        BigDecimal round = cn.hutool.core.util.NumberUtil.round(mul1, 1);
//
//        System.out.println(div1+"   "+div2+"  "+round);

        System.out.println(ThreadLocalRandom.current().nextInt(100));
    }
}

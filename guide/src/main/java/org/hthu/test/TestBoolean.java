package org.hthu.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/8/8
 */
public class TestBoolean {

    public static void main(String[] args) {

        Integer x1Count = 18;
        Integer x2Count = 23;

        BigDecimal x1 = new BigDecimal(x1Count);
        BigDecimal x2 = new BigDecimal(x2Count);

        // 调用特征平台获取用户搜获行为比例
        BigDecimal rate = x1.divide(x2, 1, RoundingMode.HALF_UP);

        System.out.println(rate);
    }
}

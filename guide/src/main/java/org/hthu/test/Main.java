package org.hthu.test;

import cn.hutool.core.util.NumberUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.hthu.jzoffer.JZ07;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Main {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

//    public static void main(String[] args) {
////        MasStringTool masStringTool = Sinleton.getMasStringTool();
////
////        System.out.println(masStringTool.maxStr("ababab"));
//
//        List<Integer> startCityList = new ArrayList<>();
//        startCityList.add(12);
//        startCityList.add(12);
//        startCityList.add(13);
//        startCityList.add(14);
//        startCityList.add(14);
//        startCityList.add(14);
//        System.out.println(startCityList);
//        Set<Integer> startCitys = new HashSet<>(startCityList);
//        List<Integer> distinctStart = new ArrayList<>();
//        distinctStart.addAll(startCitys);
//        System.out.println(distinctStart);
//    }


    public static String dateToString(Date date) {
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
        datestr = df.format(date);
        return datestr;
    }

    public static void main(String[] args) {
//        Integer queryOrderTime = -24 * 30;
//        System.out.println(addHour(System.currentTimeMillis(), queryOrderTime));

//        BigDecimal weight = calculateMax(0d);
//
//        Integer expectFreight = 100;
//        int i = BigDecimal.valueOf(expectFreight).multiply(weight).intValue();
//        System.out.println(i);

        Integer oldFreight = 131;

        Integer presentFreight = -10;

        Integer addPriceAmount = presentFreight + oldFreight;

        BigDecimal weight = new BigDecimal("4.6");

        System.out.println(BigDecimal.valueOf(oldFreight).multiply(weight).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());

        BigDecimal mul = NumberUtil.mul(weight, oldFreight);
        BigDecimal capacityRate = NumberUtil.round(mul, 1);

        System.out.println(capacityRate);
    }

    public final static long DAY = 24 * 60 * 60 * 1000;

    public static long getTodayZeroTime() {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static long addHour(long time, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(time));
        cal.add(Calendar.HOUR_OF_DAY, num);
        return cal.getTime().getTime();
    }

    /**
     * 获取最大值
     *
     * @param max 最大值
     * @return 结果
     */
    private static BigDecimal calculateMax(Double max) {
        if (Objects.isNull(max)) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(max);
    }
}

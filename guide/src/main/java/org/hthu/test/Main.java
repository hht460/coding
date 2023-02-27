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

//        String s = dateToString(new Date(1660838400000L));
//        System.out.println(s);

//        String item = "10##0.5434";
//        String SHARP_SEPARATOR = "#";
//        String[] split = StringUtils.split(item, SHARP_SEPARATOR);
//        System.out.println(Arrays.toString(split));

//        byte[] decode = Base64.getDecoder().decode("ChVzbHBkX3YyX3JvdXRlc18zMGRheXMTChVzbHBkX3YyX3JvdXRlc18zMGRheXMTCg1jaXR5X2lkX3RvX2lkEg01MTE5MDBfNDQwMTAwFBQ=");

//        System.out.println(decode.toString());


//        BigDecimal maxTruckWeight = new BigDecimal("15.5");
//
//        Double truckWeight = 2.2d;
//
//        BigDecimal remainTruckWeight = NumberUtil.sub(maxTruckWeight, truckWeight);
//
//        System.out.println(remainTruckWeight);
        
//        List<Long> memberIds = new ArrayList<>();
//        memberIds.add(1L);
//        memberIds.add(2L);
//        memberIds.add(3L);
//        System.out.println(memberIds);
//        memberIds.removeIf(memberId -> memberId.equals(2L));
//        System.out.println(memberIds);
//
//        System.out.println(UUID.randomUUID().toString().replace("-", ""));

//        System.out.println(System.currentTimeMillis() % 100);

//        long startTime = System.currentTimeMillis();
//        JZ07 jz07 = new JZ07();
//        long fibonacci = jz07.fibonacci(50);
//        System.out.println(fibonacci);
//        long time = System.currentTimeMillis() - startTime;
//        System.out.println(time/1000);

//        System.out.println(Long.valueOf(""));
//
//        Long ss = 965006065497596735222L;
        System.out.println(getTodayZeroTime()+DAY);
        System.out.println(addHour(getTodayZeroTime()+DAY, 4));

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
}

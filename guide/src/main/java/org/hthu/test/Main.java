package org.hthu.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


        List<Long> memberIds = new ArrayList<>();
        memberIds.add(1L);
        memberIds.add(2L);
        memberIds.add(3L);
        System.out.println(memberIds);
        memberIds.removeIf(memberId -> memberId.equals(2L));
        System.out.println(memberIds);
    }
}

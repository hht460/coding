package org.hthu.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        MasStringTool masStringTool = Sinleton.getMasStringTool();
//
//        System.out.println(masStringTool.maxStr("ababab"));

        List<Integer> startCityList = new ArrayList<>();
        startCityList.add(12);
        startCityList.add(12);
        startCityList.add(13);
        startCityList.add(14);
        startCityList.add(14);
        startCityList.add(14);
        System.out.println(startCityList);
        Set<Integer> startCitys = new HashSet<>(startCityList);
        List<Integer> distinctStart = new ArrayList<>();
        distinctStart.addAll(startCitys);
        System.out.println(distinctStart);
    }
}

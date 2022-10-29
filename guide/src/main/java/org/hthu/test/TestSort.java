package org.hthu.test;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/10/17
 */
public class TestSort {

    public static void main(String[] args) {

        List<BusyLineNotifyDto> noConnectDriverList = null;

//        BusyLineNotifyDto noBusyLineNotifyDto1 = new BusyLineNotifyDto();
//        noBusyLineNotifyDto1.setDriverId(965006065498211402L);
//        noBusyLineNotifyDto1.setCargoId(10152948079125L);
//        noConnectDriverList.add(noBusyLineNotifyDto1);
//
//        BusyLineNotifyDto noBusyLineNotifyDto2 = new BusyLineNotifyDto();
//        noBusyLineNotifyDto2.setDriverId(965006065498211403L);
//        noBusyLineNotifyDto2.setCargoId(10152948079125L);
//        noConnectDriverList.add(noBusyLineNotifyDto2);
//
//        BusyLineNotifyDto noBusyLineNotifyDto3 = new BusyLineNotifyDto();
//        noBusyLineNotifyDto3.setDriverId(965006065498211404L);
//        noBusyLineNotifyDto3.setCargoId(10152948079125L);
//        noConnectDriverList.add(noBusyLineNotifyDto3);

        List<BusyLineNotifyDto> busyLineNotifyDtoList = new ArrayList<>();
//
//        BusyLineNotifyDto busyLineNotifyDto2 = new BusyLineNotifyDto();
//        busyLineNotifyDto2.setDriverId(965006065498210090L);
//        busyLineNotifyDto2.setCargoId(10152948079125L);
//        busyLineNotifyDtoList.add(busyLineNotifyDto2);
//
//        BusyLineNotifyDto busyLineNotifyDto3 = new BusyLineNotifyDto();
//        busyLineNotifyDto3.setDriverId(965006065498211402L);
//        busyLineNotifyDto3.setCargoId(10152948079125L);
//        noConnectDriverList.add(busyLineNotifyDto3);

//        System.out.println(mergeDriver2(noConnectDriverList, busyLineNotifyDtoList));

        AtomicInteger normalPairNum = new AtomicInteger(0);

        AtomicInteger totalPairNum = new AtomicInteger(0);

        if (Objects.isNull(totalPairNum)){
            System.out.println("sasas");
        }
        System.out.println(totalPairNum);

    }

    public static List<BusyLineNotifyDto> mergeDriver1(List<BusyLineNotifyDto> noConnectDriverList, List<BusyLineNotifyDto> busyLineNotifyDtoList) {

        List<BusyLineNotifyDto> satisfyPairBusyLineList = new ArrayList<>();

        if (busyLineNotifyDtoList.size() < noConnectDriverList.size()) {

            satisfyPairBusyLineList.addAll(noConnectDriverList);

            busyLineNotifyDtoList.forEach(busyDriver -> {
                satisfyPairBusyLineList.forEach(noConnectDriver -> {
                    if (!busyDriver.getDriverId().equals(noConnectDriver.getDriverId()) || !busyDriver.getCargoId().equals(noConnectDriver.getCargoId())) {
                        satisfyPairBusyLineList.add(busyDriver);
                    }
                });
            });
        } else {
            satisfyPairBusyLineList.addAll(busyLineNotifyDtoList);

            noConnectDriverList.forEach(noConnectDriver -> {
                satisfyPairBusyLineList.forEach(busyDriver -> {
                    if (!noConnectDriver.getDriverId().equals(busyDriver.getDriverId()) || !noConnectDriver.getCargoId().equals(busyDriver.getCargoId())) {
                        satisfyPairBusyLineList.add(noConnectDriver);
                    }
                });
            });
        }

        return satisfyPairBusyLineList;
    }


    public static List<BusyLineNotifyDto> mergeDriver2(List<BusyLineNotifyDto> noConnectDriverList, List<BusyLineNotifyDto> busyLineNotifyDtoList) {

        if (CollectionUtils.isEmpty(noConnectDriverList) && CollectionUtils.isEmpty(busyLineNotifyDtoList)){
            return null;
        }

        Set<BusyLineNotifyDto> set = new HashSet<>();

        if (CollectionUtils.isEmpty(noConnectDriverList) && CollectionUtils.isNotEmpty(busyLineNotifyDtoList)) {
            set.addAll(busyLineNotifyDtoList);
        }

        if (CollectionUtils.isEmpty(busyLineNotifyDtoList) && CollectionUtils.isNotEmpty(noConnectDriverList)) {
            set.addAll(noConnectDriverList);
        }

        if (CollectionUtils.isNotEmpty(busyLineNotifyDtoList) && CollectionUtils.isNotEmpty(noConnectDriverList)) {
            set.addAll(busyLineNotifyDtoList);
            set.addAll(noConnectDriverList);
        }

        List<BusyLineNotifyDto> result = null;
        if (!set.isEmpty()) {
            result = new ArrayList<>(set);
        }

        return result;
    }
}

package org.hthu.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) throws InterruptedException {
//        System.out.println(tableSizeFor(10000));
//
//        String str = "{\"aRelId\":\"4000000017081518237\",\"bRelId\":\"4000000028128429902\",\"bindId\":\"16630662776424746676021\",\"bizId\":\"35904249929902\",\"bizType\":\"manhattan\",\"businessId\":\"35904249929902\",\"callId\":\"622142289250140160\",\"callInTime\":\"20220913185136\",\"callOutTime\":\"20220913185120\",\"calledNum\":\"999187264596891663\",\"calledRelCause\":\"ANSWERED\",\"callerNum\":\"999130922742708610\",\"callerType\":1,\"cargoId\":35904249929902,\"disconnectTime\":\"20220913185211\",\"duration\":35,\"middleNum\":\"18533214663\",\"phoneA\":\"999130922742708610\",\"phoneB\":\"999187264596891663\",\"providerId\":4,\"status\":7}";
//        CallRecordMessageDto callRecordMessageDto = JSON.parseObject(str, CallRecordMessageDto.class);
//        System.out.println(callRecordMessageDto);

//        long start = System.currentTimeMillis();
//        System.out.println(start);
//        Thread.sleep(2000);
//        long end = System.currentTimeMillis();
//        System.out.println(end);
//        System.out.println((end - start)/1000);

//        Long cargoId = 10152225649125L;
//        System.out.println(cargoId.hashCode());


        List<BusyLineNotifyDto> busyLineNotifyDtoList = new ArrayList<>();

        BusyLineNotifyDto dto1 = new BusyLineNotifyDto();
        dto1.setCargoId(121L);
        busyLineNotifyDtoList.add(dto1);

        BusyLineNotifyDto dto2 = new BusyLineNotifyDto();
        dto2.setCargoId(121L);
        busyLineNotifyDtoList.add(dto2);

        BusyLineNotifyDto dto3 = new BusyLineNotifyDto();
        dto3.setCargoId(11L);
        busyLineNotifyDtoList.add(dto3);

        BusyLineNotifyDto dto4 = new BusyLineNotifyDto();
        dto4.setCargoId(121L);
        busyLineNotifyDtoList.add(dto4);

        Set<Long> collect = busyLineNotifyDtoList.stream().map(BusyLineNotifyDto::getCargoId).collect(Collectors.toSet());

        System.out.println(collect);
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

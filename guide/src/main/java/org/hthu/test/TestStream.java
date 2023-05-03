package org.hthu.test;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2023/3/2
 */
public class TestStream {

    public static void main(String[] args) {

        List<SelectFleetMember> selectFleetMemberList = new ArrayList<>();
        SelectFleetMember selectFleetMember1 = new SelectFleetMember();
        selectFleetMember1.setUserId(123L);
        selectFleetMemberList.add(selectFleetMember1);

        System.out.println(selectFleetMemberList);
        selectFleetMemberList.removeIf(next->next.getUserId().equals(123L));

        System.out.println(selectFleetMemberList);
//
//        SelectFleetMember selectFleetMember2 = new SelectFleetMember();
//        selectFleetMember2.setUserId(234L);
//        selectFleetMemberList.add(selectFleetMember2);
//
//        Map<Long, List<String>> batchCrowdsHp = new HashMap<>(16);
//        List<String> list1 = new ArrayList<>();
//        list1.add("1");
//        batchCrowdsHp.put(123L, list1);
//
//        System.out.println(selectFleetMemberList);
//
//        selectFleetMemberList.stream()
//                .filter(selectFleetMember -> CollectionUtils.isEmpty(batchCrowdsHp.get(selectFleetMember.getUserId())))
//                .forEach(selectFleetMember -> selectFleetMember.setFilterType(1));
//
//        System.out.println(selectFleetMemberList);

//        List<TransportDTO> transportingList = new ArrayList<>();
//        TransportDTO transportDTO2 = new TransportDTO();
//        transportDTO2.setUserName("王杰");
//        transportingList.add(transportDTO2);
//
//        TransportDTO transportDTO3 = new TransportDTO();
//        transportDTO3.setUserName("你还");
//        transportingList.add(transportDTO3);
//
//        TransportDTO transportDTO1 = new TransportDTO();
//        transportDTO1.setUserName("胡还金");
//        transportingList.add(transportDTO1);
//
//        TransportDTO transportDTO4 = new TransportDTO();
//        transportDTO4.setUserName("哎好家伙");
//        transportingList.add(transportDTO4);
//
//        TransportDTO transportDTO5 = new TransportDTO();
//        transportDTO5.setUserName("胡海");
//        transportingList.add(transportDTO5);
//
//        System.out.println(transportingList.toString());
//
//        Comparator<Object> comparator = Collator.getInstance(Locale.CHINA);
//        transportingList.sort((e1, e2) -> comparator.compare(e1.getUserName(), e2.getUserName()));
//
//        System.out.println(transportingList.toString());

        System.out.println(UUID.randomUUID().toString());
    }
}

package org.hthu.list;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/8/10
 */
public class SubList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);


        if (list.size() > 3) {
            list = list.subList(0, 3);
            System.out.println("sub");
        }
        System.out.println(list);
    }

    public static void listDemo() {
        List<Long> list1 = new ArrayList<>();
        list1.add(1267L);
        list1.add(121211L);
        list1.add(11221211L);

        List<Long> list2 = new ArrayList<>();
        list2.add(121211L);
        list2.add(11221211L);
        // 交集
        List<Long> intersection = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println("---交集---" + intersection);

        // 差集 (list1 - list2)
        List<Long> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        System.out.println("---差集 (list1 - list2)---" + reduce1);

        // 差集 (list2 - list1)
        List<Long> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(Collectors.toList());
        System.out.println("---差集 (list2 - list1)---" + reduce2);

        // 并集
        CollectionUtils.addAll(list1, list2);
        System.out.println("---并集 list---" + list1);

        // 去重并集，方法有很多这里只列举一种
        HashSet<Long> hashSet = new HashSet<>(list1);
        System.out.println("---去重并集 list---" + hashSet);
    }
}

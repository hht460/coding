package org.hthu.list;

import java.util.ArrayList;
import java.util.List;

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


        if (list.size()>3){
            list = list.subList(0, 3);
            System.out.println("sub");
        }
        System.out.println(list);
    }
}

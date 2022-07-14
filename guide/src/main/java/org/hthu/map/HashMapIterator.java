package org.hthu.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/7/5
 */
public class HashMapIterator {

    public static void main(String[] args) {

        //创建Map 对象
        Map<Integer, String> map = new HashMap<>(16);
        //添加数据
        map.put(1, "娇娇");
        map.put(2, "娇娇1");
        map.put(3, "娇娇2");
        map.put(4, "娇娇3");
        map.put(5, "娇娇4");
        map.put(6, "娇娇5");

        //遍历
        map.forEach((key, value) -> {
            System.out.print(key+":"+value);
        });

        System.out.println();
        //遍历
        map.entrySet().forEach((integerStringEntry -> {
            System.out.print(integerStringEntry.getKey()+":"+integerStringEntry.getValue());
        }));

    }
}

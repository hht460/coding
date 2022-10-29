package org.hthu.test;

import java.util.List;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/10/18
 */
public class LogTest {


    private List<BusyLineNotifyDto> list;

    private Integer num;

    public List<BusyLineNotifyDto> getList() {
        return list;
    }

    public void setList(List<BusyLineNotifyDto> list) {
        this.list = list;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "LogTest{" +
                "list=" + list +
                ", num=" + num +
                '}';
    }
}

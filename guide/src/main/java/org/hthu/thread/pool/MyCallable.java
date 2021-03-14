package org.hthu.thread.pool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<PersonBean> {

    private String command;

    public MyCallable(String command){
        this.command = command;
    }

    @Override
    public PersonBean call() throws Exception {
//        System.out.println("curr thread ["+Thread.currentThread().getName()+"]");
        PersonBean personBean = new PersonBean();
        personBean.setAddr("新福利");
        personBean.setName(Thread.currentThread().getName());
        personBean.setAge(12);
        Thread.sleep(1000);
        return personBean;
    }
}

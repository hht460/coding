package org.hthu.thread.condition;

public class MyServiceThread1 implements Runnable{

    private MyService service;

    // 构造函数,入参
    public MyServiceThread1(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}

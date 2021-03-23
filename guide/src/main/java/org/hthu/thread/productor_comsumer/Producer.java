package org.hthu.thread.productor_comsumer;

public class Producer extends Thread{
    private Product p;

    public Producer(Product p){
        this.p = p;
    }

    @Override
    public void run(){
        int i=0;
        while (true){
            synchronized (Tools.object){
                if (!p.isFlag()){
                    if (i%2 == 0){
                        p.setName("苹果");
                        p.setPrice(6.5);
                    }else{
                        p.setName("香蕉");
                        p.setPrice(3.5);
                    }
                    System.out.println("生产了: "+p.getName()+" 价格: "+p.getPrice());
                    i++;
                    p.setFlag(true);
                    Tools.object.notify();
                }else{
                    try {
                        System.out.println("当前已经生产了产品,通知消费者尽快消费");
                        Tools.object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

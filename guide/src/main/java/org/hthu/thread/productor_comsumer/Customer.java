package org.hthu.thread.productor_comsumer;

public class Customer extends Thread{

    private Product p;
    public Customer(Product p){
        this.p = p;
    }

    @Override
    public void run(){
        while(true){
            synchronized (Tools.object){
                if (p.isFlag()){
                    System.out.println("消费者消费了: "+p.getName()+" 价格为: "+p.getPrice());
                    p.setFlag(false);
                    Tools.object.notify();
                }else{
                    System.out.println("当前没有产品可以消费,通知生产者尽快进行生产!");
                    try {
                        Tools.object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

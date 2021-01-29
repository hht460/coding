package thread.alternateprint;

public class ThreadOne extends Thread{

    public ThreadOne(String name){
        super(name);
    }

    @Override
    public void run() {
        while (LockConstant.initValue<=100){
            synchronized (LockConstant.lock){
                // 奇数
                if (LockConstant.initValue % 2 == 1){
                    System.out.println("当前奇数线程: " + Thread.currentThread().getName() + "; 当前值:" + LockConstant.initValue);
                    LockConstant.initValue ++;
                    // 唤醒持有该锁的线程
                    LockConstant.lock.notify();
                    try {
                        // 当前线程进入阻塞状态
                        LockConstant.lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }else {
                    // 当前线程任然进入阻塞状态
                    try {
                        LockConstant.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

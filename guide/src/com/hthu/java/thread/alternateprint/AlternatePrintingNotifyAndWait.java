package thread.alternateprint;

/**
 * 两个线程交替执行
 * 思路：定义一个object 作为锁，然后将打印的逻辑都用synchronized包含起来，
 * 先启动了奇数线程，因为初始值i为0，i%2==1不成立，奇数线程进入wait状态，
 * 这个时候偶数线程启动，然后打印完偶数，执行notify唤醒奇数线程，然后进入wait状态。
 * 奇数线程被唤醒之后，打印奇数，然后执行notify唤醒偶数线程，随后自己进入wati状态。
 */
public class AlternatePrintingNotifyAndWait {

    // 锁
    private static Object lock = new Object();

    // 起始值
    private static int i = 1;

    public static void main(String[] args) {
        // 打印奇数线程
        new Thread("奇数线程"){
            @Override
            public void run() {
                while (i<=100){
                    synchronized (lock){
                        if (i % 2 == 1) {
                            System.out.println("当前奇数线程: " + Thread.currentThread().getName() + "; 当前值:" + i);
                            i++;
                            lock.notify(); // 让处于阻塞状态线程进入可执行状态(竞争锁,获得锁即可执行)
                            try {
                                System.out.println("当前奇数线程: " + Thread.currentThread().getName() + "处于等待状态");
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("当前奇数线程: " + Thread.currentThread().getName() + "处于等待状态");
                            try {
                                lock.wait(); // 让当前线程处于阻塞状态
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        }.start();

        // 打印偶数线程
        new Thread("偶数线程"){
            @Override
            public void run() {
                while (i<=100){
                    synchronized (lock){
                        if (i % 2 == 0) {
                            System.out.println("当前偶数线程: " + Thread.currentThread().getName() + "; 当前值:" + i);
                            i++;
                            lock.notify(); // 让处于阻塞状态线程进入可执行状态(竞争锁,获得锁即可执行)
                            try {
                                System.out.println("当前偶数线程: " + Thread.currentThread().getName() + "处于等待状态");
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("当前偶数线程: " + Thread.currentThread().getName() + "处于等待状态");
                            try {
                                lock.wait(); // 让当前线程处于阻塞状态
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }.start();

    }
}

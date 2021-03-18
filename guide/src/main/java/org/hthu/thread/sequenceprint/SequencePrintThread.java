package org.hthu.thread.sequenceprint;

/**
 * 顺序执行线程，顺序打印
 */
public class SequencePrintThread {

    public static void main(String[] args) throws InterruptedException {
        OneThread oneThread = new OneThread("one");
        TwoThread twoThread = new TwoThread("two");
        ThreeThread threeThread = new ThreeThread("three");
        // 顺序打印
        oneThread.start();
        oneThread.join(); // 阻塞主线程,等待oneThread线程执行结束

        twoThread.start();
        twoThread.join(); // 阻塞主线,等待twoThread线程执行结束

        threeThread.start();
        threeThread.join(); // 阻塞主线,等待threeThread线程执行结束
    }
}

class OneThread extends Thread{
    public OneThread(String name){
        super(name);
    };
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" ; OneThread print...");
    }
}

class TwoThread extends Thread{
    public TwoThread(String name){
        super(name);
    };
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" ; TwoThread print...");
    }
}

class ThreeThread extends Thread{
    public ThreeThread(String name){
        super(name);
    };
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" ; ThreeThread print...");
    }
}
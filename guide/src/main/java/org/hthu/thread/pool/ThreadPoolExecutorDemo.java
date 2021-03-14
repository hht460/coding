package org.hthu.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池的使用
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
                );

        CompletionService<PersonBean> completionService = new ExecutorCompletionService(executor);

        // 向CompletionService中提交10个任务
        for (int i = 0; i < 10; i++) {
            MyCallable myCallable = new MyCallable("哈哈哈");
            completionService.submit(myCallable);
            System.out.println("已经提交: "+i);
        }

        //获取结果,循环次数表示获取先前放入多少个线程结果【之前放入几个线程，此刻就需要获取多少个结果】
        for (int i =0;i<10;i++){
            System.out.println("get :"+i);
            String temp = "";
            try {
                PersonBean personBean = completionService.take().get();
                list.add(personBean.getName() +","+ personBean.getAddr());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("result: "+list);
    }
}

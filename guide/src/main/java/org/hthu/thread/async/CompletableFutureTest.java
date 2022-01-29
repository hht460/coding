package org.hthu.thread.async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/1/27
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> initData = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futureList = new ArrayList<>();

        initData.forEach(item -> {
                    CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
                        // TODO
                        if ("b".equalsIgnoreCase(item)){
                            System.out.println(1/0);
                        }
                        return item + "sync";
                    });
                    futureList.add(stringCompletableFuture);
                }
        );

        CompletableFuture<Void> resultCompletableFuture = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        System.out.println(resultCompletableFuture.get());

//        CompletableFuture<List<String>> listCompletableFuture = resultCompletableFuture.thenApply(e -> futureList.stream().map(CompletableFuture::join).collect(Collectors.toList()));
        List<String> collect = futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
//        List<String> join = listCompletableFuture.join();
        System.out.println(collect);

    }
}

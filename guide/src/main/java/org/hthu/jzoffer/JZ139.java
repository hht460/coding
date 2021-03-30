package org.hthu.jzoffer;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 给定无序整数序列，求其中第K大的数
 * 使用小顶堆，堆中有k个元素，堆顶元素为当前的第k大数，
 * 如果堆中不足k个元素，直接入堆，
 * 否则，如果大于堆顶，删除堆顶，这个数入堆。
 * 最后，堆顶元素即为所求
 */
public class JZ139 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        int k = scanner.nextInt(); // 第K大数
        scanner.close();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k); //初始容量K的优先队列(默认按照自然排序)
        for (int i = 0; i < arr.length; i++) { // 遍历每个元素
            // 优先队列中元素不足K个，直接插入
            if (priorityQueue.size() < k) {
                priorityQueue.offer(arr[i]);
            } else if (arr[i] > priorityQueue.peek()) {
                // 优先队列中元素大于等于K个，与队列头部元素（堆顶元素）比较
                priorityQueue.poll(); // 弹出队列头部元素
                priorityQueue.offer(arr[i]);
            }
        }
        System.out.println(priorityQueue.peek());
    }
}

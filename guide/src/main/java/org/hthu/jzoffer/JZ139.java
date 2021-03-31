package org.hthu.jzoffer;

import org.hthu.sort.QuickSortLearn;

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

        // 实现方式一：优先队列（小顶堆）
//        KlargestNumberByQueue(arr, k);

        // 实现方式二：快排
        KlargestNumberByQuickSort(arr, k);
    }

    private static void KlargestNumberByQuickSort(int[] arr, int k) {
        int destIndex = arr.length - k;  // 当数组从小大排好序后，第k大数字，位于 arr.length - k（目标位置）
        int start = 0;
        int end = arr.length - 1;
        QuickSortLearn quickSortLearn = new QuickSortLearn();
        // 获取第一个分区点
        int partition = quickSortLearn.getPartitionMethod2(arr,start,end);
        // 当前分区点不等于 目标位置
        while ( partition != destIndex){
            if (partition < destIndex){
                int i = partition + 1;
                partition = quickSortLearn.getPartitionMethod2(arr, i, end);
            }else {
                int j = partition - 1;
                partition = quickSortLearn.getPartitionMethod2(arr, start, j);
            }
        }
        // 当前分区点等于 目标位置
        System.out.println(arr[partition]);
    }

    private static void KlargestNumberByQueue(int[] arr, int k) {
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

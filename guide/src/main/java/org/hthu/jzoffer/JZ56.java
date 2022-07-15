package org.hthu.jzoffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 数组所有滑动窗口中最大值
 *
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/7/14
 */
public class JZ56 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 23, 54, 1, 65, 7, 23, 67};
        System.out.println(maxInWindows(nums, 3));
    }

    /**
     * 滑动窗口最大值
     *
     * @param nums 数组
     * @param size 窗口大小
     * @return 窗口最大值集合
     */
    public static ArrayList<Integer> maxInWindows(int[] nums, int size) {

        ArrayList<Integer> result = new ArrayList<>();
        if (size < 1 || size > nums.length) {
            return result;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        // 先放入第一个滑动窗口数据
        for (int i = 0; i < size; i++) {
            heap.add(nums[i]);
        }

        // 取第一个滑动窗口最大值
        result.add(heap.peek());

        // 窗口向右移动
        for (int i = 0, j = i + size; j < nums.length; i++, j++) {
            // 移除第一个滑动窗口最左侧数值
            heap.remove(nums[i]);
            // 放入第二个滑动窗口最右侧数值
            heap.add(nums[j]);
            // 取当前窗口最大值
            result.add(heap.peek());
        }

        return result;
    }
}

package org.hthu.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最长不不含重复元素子串
 */
public class MaxLengthOfSubstring {

    public static void main(String[] args) {
        System.out.println(getMaxLengthSubStr("abcbe"));
    }

    public static int getMaxLengthSubStr(String str) {
        Queue<String> queue = new LinkedList<>();
        int result = 0;
        for (int index = 0; index < str.length(); index++) {
            String ss = str.charAt(index) + "";
            if (queue.contains(ss)) {
                queue.clear();
            }
            queue.offer(ss);
            if (queue.size() > result) {
                result = queue.size();
            }
        }
        return result;
    }
}

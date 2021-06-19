package org.hthu.jzoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 */
public class JZ05_1 {

    Queue<String> queue1 = new LinkedList<>();
    Queue<String> queue2 = new LinkedList<>();

    /**
     * 往不为空的队列放
     * @param value
     */
    public void push(String value){
        if (!queue1.isEmpty()){
            queue1.offer(value);
        }else {
            queue2.offer(value);
        }
    }

    public String pop(){
        // quque1 不为空
        if (!queue1.isEmpty()){
            int size = queue1.size();
            // 保留一个元素,作为出栈元素
            while (size > 1){
                queue2.offer(queue1.peek());
                queue1.poll();
                size--;
            }
            return queue1.poll();
        }else {
            int size = queue2.size();
            // 保留一个元素,作为出栈元素
            while (size > 1){
                queue1.offer(queue2.peek());
                queue2.poll();
                size--;
            }
            return queue2.poll();
        }
    }
}
